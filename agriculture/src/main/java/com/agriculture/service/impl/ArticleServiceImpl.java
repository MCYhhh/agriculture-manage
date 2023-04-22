package com.agriculture.service.impl;

import com.agriculture.entity.Article;
import com.agriculture.mapper.ArticleMapper;
import com.agriculture.service.IArticleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Resource
    ArticleMapper articleMapper;
    @Override
    public Page<Article> selectPage(Page<Article> page, QueryWrapper<Article> queryWrapper) {
        return articleMapper.selectPage(page,queryWrapper);
    }
}

