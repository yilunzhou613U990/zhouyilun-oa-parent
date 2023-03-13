package com.yi.auth.controller;

import com.yi.auth.service.SysRoleService;
import com.yi.model.system.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {
    //注入service
    @Autowired
    private SysRoleService sysRoleService;

    //查询所有
    @GetMapping("/findAll")
    private List<SysRole> findAll() {
        List<SysRole> list = sysRoleService.list();
        return list;
    }
}
