package com.example.service.impl;

import com.example.demorepo.repository.mapper.TbUserMapper;
import com.example.demorepo.repository.model.TbUser;
import com.example.demorepo.repository.model.TbUserExample;
import com.example.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "tbUserService")
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    TbUserMapper tbUserMapper;

    @Override
    public String fortest(){
        return "For Test";
    }

    @Override
    public List<TbUser> getAllUsers() {
       List<TbUser> userList = tbUserMapper.selectByExample(new TbUserExample());
       return userList;
    }

    @Override
    public TbUser getById(Integer id) {
        return tbUserMapper.selectByPrimaryKey(id);
    }
}
