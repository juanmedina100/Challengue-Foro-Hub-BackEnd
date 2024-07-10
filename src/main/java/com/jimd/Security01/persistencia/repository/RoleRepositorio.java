package com.jimd.Security01.persistencia.repository;

import com.jimd.Security01.persistencia.entities.login.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepositorio extends CrudRepository<RoleEntity,Long> {
    List<RoleEntity> findRoleEntityByReloEnumIn(List<String> roleNames);
}
