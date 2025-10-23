package com.rabbiter.cm.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ScoreVo implements Serializable {

    private String studentName;

    private Integer score;
}
