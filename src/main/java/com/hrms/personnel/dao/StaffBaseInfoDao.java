package com.hrms.personnel.dao;

import com.hrms.personnel.entity.StaffBaseInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (StaffBaseInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-31 17:29:33
 */
public interface StaffBaseInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param staffId 主键
     * @return 实例对象
     */
    StaffBaseInfo queryById(String staffId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<StaffBaseInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param staffBaseInfo 实例对象
     * @return 对象列表
     */
    List<StaffBaseInfo> queryAll(StaffBaseInfo staffBaseInfo);

    /**
     * 新增数据
     *
     * @param staffBaseInfo 实例对象
     * @return 影响行数
     */
    int insert(StaffBaseInfo staffBaseInfo);

    /**
     * 修改数据
     *
     * @param staffBaseInfo 实例对象
     * @return 影响行数
     */
    int update(StaffBaseInfo staffBaseInfo);

    /**
     * 通过主键删除数据
     *
     * @param staffId 主键
     * @return 影响行数
     */
    int deleteById(String staffId);

}