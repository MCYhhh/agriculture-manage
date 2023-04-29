package com.agriculture.config.mybatis;

import lombok.Data;

@Data
public class SceneryPage {
    private int page;//页面参数，当前页面
    private int size;//页面参数，当前大小
    private String sname;//景点名称
    private int sprice;//价格价格
    private int sid;//景点id
    private int sstate;//景点状态
    private int uid;//景点管理员
}