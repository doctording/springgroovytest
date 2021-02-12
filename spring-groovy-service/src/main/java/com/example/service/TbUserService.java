package com.example.service;


import com.example.demorepo.repository.model.TbUser;

import java.util.List;

public interface TbUserService {
    String fortest();

    List<TbUser> getAllUsers();

    TbUser getById(Integer id);
}