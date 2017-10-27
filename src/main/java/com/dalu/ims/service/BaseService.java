package com.dalu.ims.service;

import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BaseService<T> {
    //根据ID查询数据
    T queryById(Integer id);
    //查询所有的数据
    List<T> queryAll();
    //根据条件查询一条数据
    T queryByWhere(T record);
    //根据条件查询数据
    List<T> queryListByWhere(T record);
    //根据条件分页查询数据
    PageInfo<T> queryPageListByWhere(Integer pageNum, Integer pageSize, T record);
    //插入数据，返回插入条数
    Integer save(T record);
    //修改数据
    Integer update(T record);
    //删除数据
    Integer deleteById(Integer id);

}
