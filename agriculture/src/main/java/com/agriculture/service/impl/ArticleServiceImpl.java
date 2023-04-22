package com.agriculture.service.impl;

import com.agriculture.entity.Article;
import com.agriculture.mapper.ArticleMapper;
import com.agriculture.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {
}

