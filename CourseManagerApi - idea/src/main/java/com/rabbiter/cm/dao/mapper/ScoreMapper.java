package com.rabbiter.cm.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rabbiter.cm.model.vo.ScoreVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreMapper extends BaseMapper<ScoreVo> {

    List<ScoreVo> getScoreList();
}
