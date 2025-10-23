package com.rabbiter.cm.service.admin;

import com.rabbiter.cm.manager.admin.ScoreManager;
import com.rabbiter.cm.model.vo.response.ResultVO;
import com.rabbiter.cm.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ScoreService extends BaseService {


    private final ScoreManager manager;

    public ScoreService(ScoreManager manager) {
        this.manager = manager;
    }


    public ResultVO scoreList() {
        return result(manager.list());
    }
}
