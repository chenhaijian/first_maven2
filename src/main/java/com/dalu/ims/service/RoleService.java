package com.dalu.ims.service;

import com.dalu.ims.pojo.EasyUIResult;
import com.dalu.ims.pojo.Role;

public interface RoleService extends BaseService<Role>{

    /**
     * 分页查询
     * @param page
     * @param rows
     * @return
     */
    EasyUIResult queryItemList(Integer page, Integer rows);

}
