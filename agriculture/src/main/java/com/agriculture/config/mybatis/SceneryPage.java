package com.agriculture.config.mybatis;

import lombok.Data;

@Data
public class SceneryPage {
    private int page;//页面参数，当前页面
    private int size;//页面参数，当前大小
    private String name;//景点名称
    private int price;//价格价格
    private int id;//景点id
    private int n;//景点状态
    private int uid;//景点管理员
}
