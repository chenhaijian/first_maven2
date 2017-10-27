package com.dalu.ims.service.impl;

import com.dalu.ims.mapper.RoleMapper;
import com.dalu.ims.pojo.EasyUIResult;
import com.dalu.ims.pojo.Role;
import com.dalu.ims.service.RoleService;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 根据条件分页查询数据
     * @param page
     * @param rows
     * @return
     */
    @Override
    public EasyUIResult queryItemList(Integer page, Integer rows) {


        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();


        PageHelper.startPage(page, rows);

        Example example = new Example(Role.class);
        example.setOrderByClause("id desc");

        List<Role> roleList = this.roleMapper.selectByExample(example);

        PageInfo<Role> rolePageInfo = new PageInfo<>(roleList);
        return new EasyUIResult(rolePageInfo.getTotal(), rolePageInfo.getList());

    }
}
