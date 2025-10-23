package com.rabbiter.cm.dao;

import com.rabbiter.cm.dao.mapper.ScoreMapper;
import com.rabbiter.cm.model.vo.ScoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ScoreVoDao extends BaseDAO {

    @Autowired
    private final ScoreMapper mapper;

    public ScoreVoDao(ScoreMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 查询学生成绩分组
     * @return
     */
   public List<ScoreVo> scoreVoList(){
//       QueryWrapper<ScoreVo> scoreVoQueryWrapper=new QueryWrapper<>();
//       scoreVoQueryWrapper.select("");
       List<ScoreVo> scoreVos = mapper.getScoreList();
       return scoreVos;
   }
}
