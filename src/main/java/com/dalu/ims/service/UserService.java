package com.dalu.ims.service;

import com.dalu.ims.pojo.User;

public interface UserService extends BaseService<User>{


    /**
     * 根据id, 批量删除
     * @param ids id数组
     * @return
     */
    boolean deleteBatch(String[] ids);
}
