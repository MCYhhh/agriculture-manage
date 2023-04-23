package com.agriculture.config.mybatis;

import com.agriculture.entity.Menu;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MenuPage {
    private int page;//页面参数，当前页面
    private int size;//页面参数，当前大小
    private Integer mid;
    private String mtitle;
    private String mdesp;
    private String mpath;
    private String mrouter;
    private Integer mvisible;
    private Integer state;
    private Integer updateBy;
    private Integer createBy;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer del;
    private Integer mpid;
    private String micon;
    private List<Menu> children;
}
