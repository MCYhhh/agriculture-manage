package com.agriculture.config.mybatis;

import lombok.Data;

@Data
public class GoodsPage {
    private int page;//页面参数，当前页面
    private int size;//页面参数，当前大小
    private int gid;
    private String gname;
    private float gprice;
    private int gsate;
    private String gimg;
    private String gdesp;
    private int state;
}
