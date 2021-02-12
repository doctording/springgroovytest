package com.example.demorepo;

import com.example.demorepo.repository.mapper.TbUserMapper;
import com.example.demorepo.repository.model.TbUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author mubi
 * @Date 2021/2/12 14:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoRepoApplication.class)
public class UserMapperTests {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Test
    public void testGetUser(){
        TbUser tbUser = tbUserMapper.selectByPrimaryKey(1);
        Assert.assertTrue(tbUser != null);
        Assert.assertTrue(tbUser.getId() == 1);
    }
}
