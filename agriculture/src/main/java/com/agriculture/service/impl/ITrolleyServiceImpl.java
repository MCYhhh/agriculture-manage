package com.agriculture.service.impl;


import com.agriculture.entity.Trolley;
import com.agriculture.mapper.TrolleyMapper;
import com.agriculture.service.ITrolleyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ITrolleyServiceImpl extends ServiceImpl<TrolleyMapper, Trolley> implements ITrolleyService {
}
