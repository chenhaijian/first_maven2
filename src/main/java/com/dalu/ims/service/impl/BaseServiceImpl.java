package com.dalu.ims.service.impl;

import com.dalu.ims.service.BaseService;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private Mapper<T> mapper;

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public T queryById(Integer id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public List<T> queryAll() {
        return this.mapper.select(null);
    }

    /**
     * 根据条件查询一条数据
     * @param record
     * @return
     */
    @Override
    public T queryByWhere(T record) {
        return this.mapper.selectOne(record);
    }

    /**
     * 根据条件查询出所有数据
     * @param record
     * @return
     */
    @Override
    public List<T> queryListByWhere(T record) {
        return this.mapper.select(record);
    }

    /**
     * 分页查询
     * @param pageNum  页数
     * @param pageSize 页的大小
     * @param record   查询条件
     * @return
     */
    @Override
    public PageInfo<T> queryPageListByWhere(Integer pageNum, Integer pageSize, T record) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> list = this.queryListByWhere(record);

        return new PageInfo<T>(list);
    }

    /**
     * 保存数据
     * @param record
     * @return
     */
    @Override
    public Integer save(T record) {
        return this.mapper.insert(record);
    }

    /**
     * 更新数据
     * @param record
     * @return
     */
    @Override
    public Integer update(T record) {
        return this.mapper.updateByPrimaryKey(record);
    }

    /**
     * 删除数据
     * @param id
     * @return
     */
    @Override
    public Integer deleteById(Integer id) {
        return this.mapper.deleteByPrimaryKey(id);
    }
}
