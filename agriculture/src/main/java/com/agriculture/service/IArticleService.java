package com.agriculture.service;

import com.agriculture.entity.Article;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IArticleService extends IService<Article> {
    Page<Article> selectPage(Page<Article> spage, QueryWrapper<Article> queryWrapper);

}
