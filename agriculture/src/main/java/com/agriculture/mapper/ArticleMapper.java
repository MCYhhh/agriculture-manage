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

    @Select("select a.id,a.title,a.type,a.summary,a.content,a.score,a.uid,a.create_time,a.update_time,a.img,b.uaccount,b.uname,b.upwd,b.utype,b.usex,b.uemail,b.utel,b.uaddress,b.uimg,b.udesp,b.state from article a left join user b on a.uid=b.uid where a.uid=#{uid}")
    IPage<ArticleUserVo> getByUid(Page<ArticleUserVo> iPage, Integer uid);

    @Select("select a.id,a.title,a.type,a.summary,a.content,a.score,a.uid,a.create_time,a.update_time,a.img,b.uaccount,b.uname,b.upwd,b.utype,b.usex,b.uemail,b.utel,b.uaddress,b.uimg,b.udesp,b.state from article a left join user b on a.uid=b.uid")
    IPage<ArticleUserVo> getAll(Page<ArticleUserVo> iPage);
}

