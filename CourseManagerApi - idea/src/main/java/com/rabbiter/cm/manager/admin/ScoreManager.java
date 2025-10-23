package com.rabbiter.cm.manager.admin;

import com.rabbiter.cm.dao.ScoreVoDao;
import com.rabbiter.cm.manager.BaseManager;
import com.rabbiter.cm.model.entity.AdminEntity;
import com.rabbiter.cm.model.vo.ScoreVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScoreManager extends BaseManager {

    private final ScoreVoDao scoreVoDao;

    public ScoreManager(ScoreVoDao scoreVoDao) {
        this.scoreVoDao = scoreVoDao;
    }

    public List<ScoreVo> list() {
        return scoreVoDao.scoreVoList();
    }
}
