package com.jimd.Security01.persistencia.entities.foro;

import com.jimd.Security01.persistencia.entities.login.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "responses")
@Entity(name = "response")
public class ResponEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @CreationTimestamp
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    private boolean solucion;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private TopicEntity topic;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


}
