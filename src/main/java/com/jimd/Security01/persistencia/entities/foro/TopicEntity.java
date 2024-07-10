package com.jimd.Security01.persistencia.entities.foro;

import com.jimd.Security01.persistencia.entities.login.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "topics")
@Entity(name = "topic")
public class TopicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @Column(unique = true)
    private String mensaje;
    @CreationTimestamp
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "course")
    private CourseEntity course;
    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;
    @OneToMany(mappedBy = "topic")
    private List<ResponEntity> responEntityList;

}
