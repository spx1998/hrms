package com.hrms.security.dao;

import com.hrms.security.entity.Submodule;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SubmodulesDao {

    List<Submodule> getSubmodules();

    List<Submodule> getSubmoduleByRole(int roleId);
}
