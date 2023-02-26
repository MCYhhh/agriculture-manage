package com.agriculture.service.impl;

import com.agriculture.entity.Comment;
import com.agriculture.mapper.CommentMapper;
import com.agriculture.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
