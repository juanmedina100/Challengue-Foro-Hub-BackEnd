package com.jimd.Security01.persistencia.repository;

import com.jimd.Security01.persistencia.entities.foro.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<TopicEntity, Long> {
}
