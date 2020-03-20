package com.hrms.security.dao;

import com.hrms.security.entity.Module;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ModulesDao {
    List<Module> getModules(List<Integer> moduleIds);
}
