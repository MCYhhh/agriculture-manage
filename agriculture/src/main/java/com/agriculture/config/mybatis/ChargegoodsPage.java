package com.agriculture.config.mybatis;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChargegoodsPage {
    private int page;//页面参数，当前页面
    private int size;//页面参数，当前大小
    private Integer cid;
    private Integer uid;
    private Integer gid;
    private Integer cnum;
    private LocalDateTime cdate;
    private Integer state;
    private LocalDateTime updateTime;
}
