package com.yi.auth;

import com.baomidou.mybatisplus.core.conditions.ISqlSegment;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yi.auth.mapper.SysRoleMapper;
import com.yi.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TestMpDemo1 {
    @Autowired
    private SysRoleMapper mapper;

    @Test
    public void getAll() {
        List list = mapper.selectList(null);
        System.out.println(list);
    }

    @Test
    public void add() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");
        int rows = mapper.insert(sysRole);
        System.out.println(rows);
        System.out.println(sysRole);
    }

    @Test
    public void update() {
        SysRole sysRole = mapper.selectById(9);
        sysRole.setRoleName("2角色管理员2");
        int row = mapper.updateById(sysRole);
        System.out.println(row);
    }

    @Test
    public void deleteId() {
        int row = mapper.deleteById(9);
        System.out.println(row);
    }

    @Test
    public void testDeleteBatchIds() {
        int row = mapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(row);
    }

    @Test
    public void testQuery1() {
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name", "系统管理员");
        List<SysRole> sysRoles = mapper.selectList(wrapper);
        System.out.println(sysRoles);
    }

    @Test
    public void testQuery2() {
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();

        wrapper.eq(SysRole::getRoleName, "系统管理员");
        List<SysRole> sysRoles = mapper.selectList(wrapper);
        System.out.println(sysRoles);
    }


}
