package com.example.demoapi.control;

import com.example.demorepo.repository.model.TbUser;
import com.example.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author mubi
 * @Date 2021/2/13 12:04
 */
@RestController
public class UserControl {
    @Autowired
    TbUserService tbUserService;

    @GetMapping(value = "/test-service")
    public String test() {
        return tbUserService.fortest();
    }

    @GetMapping(value = "/user-all")
    public List<TbUser> getTestAll() {
        return tbUserService.getAllUsers();
    }

    @GetMapping(value = "/user-id/{id}")
    public TbUser getById(@PathVariable Integer id) {
        return tbUserService.getById(id);
    }

}
