package com.jimd.Security01.persistencia.repository;


import com.jimd.Security01.persistencia.entities.foro.ResponEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponRepository extends JpaRepository<ResponEntity, Long> {


}
