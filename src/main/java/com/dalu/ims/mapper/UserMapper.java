package com.dalu.ims.mapper;

import com.dalu.ims.pojo.User;
import com.github.abel533.mapper.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends Mapper<User>{

    /**
     * 根据ID批量删除数据
     * @param ids
     * @return
     */
    boolean deleteBatch(String[] ids);
}
