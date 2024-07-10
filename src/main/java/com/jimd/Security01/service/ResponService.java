package com.jimd.Security01.service;


import com.jimd.Security01.persistencia.entities.foro.ResponEntity;
import com.jimd.Security01.persistencia.entities.foro.TopicEntity;
import com.jimd.Security01.persistencia.entities.login.UserEntity;
import com.jimd.Security01.persistencia.repository.ResponRepository;
import com.jimd.Security01.persistencia.repository.TopicRepository;
import com.jimd.Security01.persistencia.repository.UserRepository;
import com.jimd.Security01.service.dtoRespon.DatosAgregarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponService {

    @Autowired
    private ResponRepository responRepository;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private UserRepository userRepository;

    public DatosAgregarResponse addResponse(DatosAgregarResponse datos){
        Optional<UserEntity> user = userRepository.findById(datos.user());
        if (!user.isPresent()){
            throw new RuntimeException("Usuario no exite");
        }
        Optional<TopicEntity> topic = topicRepository.findById(datos.topic());
        if (!topic.isPresent()){
            throw new RuntimeException("Topico no exite");
        }
        ResponEntity response = new ResponEntity();
        response.setMensaje(datos.mensaje());
        response.setFechaCreacion(datos.fechaCreacion());
        response.setSolucion(datos.solucion());
        response.setUser(user.get());
        response.setTopic(topic.get());
        responRepository.save(response);
        return datos;
    }
}
