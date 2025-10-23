package com.rabbiter.cm.controller.admin;

import com.alibaba.fastjson.JSON;
import com.rabbiter.cm.config.themis.annotation.Admin;
import com.rabbiter.cm.controller.BaseController;
import com.rabbiter.cm.model.vo.ScoreVo;
import com.rabbiter.cm.model.vo.response.ResultVO;
import com.rabbiter.cm.service.admin.ScoreService;
import com.rabbiter.cm.util.Md5Encrypt;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Admin(Admin.ADMIN_MANAGE)
@RequestMapping("/admin/score")
@RestController
@SuppressWarnings("all")
public class ScoreController extends BaseController {

    private final ScoreService service;


    private static RedisTemplate<String, Object> redisTemplate;


    public static final String KEY="resultVo";


    @Resource
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        ScoreController.redisTemplate = redisTemplate;
    }



    public ScoreController(ScoreService service) {
        this.service = service;
    }

    @GetMapping("/scoreList")
    public ResultVO scoreList() {
        ResultVO resultVO = service.scoreList();
        List<String> studentName=new ArrayList<>();
        List<Integer> score=new ArrayList<>();
        List<ScoreVo> voData = (List<ScoreVo>) resultVO.getData();
        for (ScoreVo voDatum : voData) {
            studentName.add(voDatum.getStudentName());
            score.add(voDatum.getScore());
        }
        Map<String,Object> studentMap=new HashMap<>();
        studentMap.put("studentName",studentName);
        studentMap.put("scores",score);
        resultVO.setData(studentMap);
        System.out.println("测试====="+JSON.toJSONString(resultVO));
        boolean exists = exists(KEY);
        if (exists==true){
            redisTemplate.delete("resultVo");
        }else {
            redisTemplate.opsForValue().set("resultVo",resultVO);
        }
        ResultVO resultVo = (ResultVO) redisTemplate.opsForValue().get("resultVo");
        if (exists==false){
            redisTemplate.opsForValue().set("resultVo",resultVO);
        }
        if (resultVo!=null){
            return resultVo;
        }
        return resultVO;
    }



    public boolean exists(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {

        Md5Encrypt md5=new Md5Encrypt();

        String password = "098f6bcd4621d373cade4e832627b4f6";

        String decry = md5.decry(password);

        System.out.println(decry);

    }

}
