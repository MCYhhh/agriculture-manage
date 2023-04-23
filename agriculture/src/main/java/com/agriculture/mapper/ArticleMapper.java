package com.agriculture.mapper;

import com.agriculture.entity.Article;
import com.agriculture.entity.vo.ArticleUserVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    @Select("")
    IPage<ArticleUserVo> getByUid(Page<ArticleUserVo> iPage, Integer uid);

    @Select("")
    IPage<ArticleUserVo> getAll(Page<ArticleUserVo> iPage);
}

