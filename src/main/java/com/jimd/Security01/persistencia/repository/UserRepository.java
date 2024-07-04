package com.jimd.Security01.persistencia.repository;

import com.jimd.Security01.persistencia.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByUsername(String username);

//    @Query(value = "select u.username FROM UserEntity where username =:user")
//    List<UserCustoms> findByUsername(String user);
}
