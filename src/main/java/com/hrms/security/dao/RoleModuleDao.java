package com.hrms.security.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoleModuleDao {
    List<Integer> getModulesByRole(int roleId);
}
