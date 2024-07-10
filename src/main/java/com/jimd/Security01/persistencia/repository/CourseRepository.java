package com.jimd.Security01.persistencia.repository;

import com.jimd.Security01.persistencia.entities.foro.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
