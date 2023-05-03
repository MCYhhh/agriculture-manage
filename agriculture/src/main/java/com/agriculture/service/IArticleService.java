package com.agriculture.service;

import com.agriculture.entity.Article;
import com.agriculture.entity.vo.ArticleUserVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IArticleService extends IService<Article> {
    Page<Article> selectPage(Page<Article> spage, QueryWrapper<Article> queryWrapper);

    IPage<ArticleUserVo> getByUid(Page<ArticleUserVo> iPage, Integer uid);

    IPage<ArticleUserVo> getAll(Page<ArticleUserVo> iPage);

    IPage<ArticleUserVo> getByAid(Page<ArticleUserVo> iPage, Integer id);
}
