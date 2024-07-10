package com.jimd.Security01.service;


import com.jimd.Security01.mapper.TopicMapper;
import com.jimd.Security01.persistencia.entities.foro.CourseEntity;
import com.jimd.Security01.persistencia.entities.foro.TopicEntity;
import com.jimd.Security01.persistencia.entities.login.UserEntity;
import com.jimd.Security01.persistencia.repository.CourseRepository;
import com.jimd.Security01.persistencia.repository.TopicRepository;
import com.jimd.Security01.persistencia.repository.UserRepository;
import com.jimd.Security01.service.dtoTopic.DatosMostrarTopicList;
import com.jimd.Security01.service.dtoTopic.DatosRegistrarTopic;
import com.jimd.Security01.service.dtoTopic.DatosUpdateTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;

    //Agregar Topico
    public DatosRegistrarTopic addTopic(DatosRegistrarTopic topic){
        Optional<UserEntity> user = userRepository.findById(topic.usuario());
        if (!user.isPresent()){
            throw new RuntimeException("Usuario no existe");
        }
        Optional<CourseEntity> course = courseRepository.findById(topic.curso());
        if (!course.isPresent()){
            throw new RuntimeException("Curso no existe");
        }
        TopicEntity topico = new TopicEntity();
        topico.setUser(user.get());
        topico.setCourse(course.get());
        topico.setTitulo(topic.titulo());
        topico.setMensaje(topic.mensaje());
        topico.setStatus(true);
        topico.setFechaCreacion(topico.getFechaCreacion());
        return TopicMapper.toTopic(topicRepository.save(topico));
    }
    //Lista de topico
    public List<DatosMostrarTopicList> topics(){
        return TopicMapper.toTopiccList(topicRepository.findAll());
    }
    //Actualizar topico
    public DatosUpdateTopic updateTopic(Long id, DatosUpdateTopic datosUpdateTopic){
        Optional<TopicEntity> topicExist = topicRepository.findById(id);
        if (!topicExist.isPresent()){
            throw new RuntimeException("El topico no exite");
        }
        if (topicExist.get().getTitulo().equals(datosUpdateTopic.titulo())){
            throw new RuntimeException("El titulo exite");
        }
        if (topicExist.get().getMensaje().equals(datosUpdateTopic.mensaje())){
            throw new RuntimeException("El Mensaje exite");
        }
        TopicEntity updateTopic = new TopicEntity();
        updateTopic.setId(id);
        updateTopic.setTitulo(datosUpdateTopic.titulo());
        updateTopic.setMensaje(datosUpdateTopic.mensaje());
        updateTopic.setStatus(datosUpdateTopic.status());
        updateTopic.setFechaCreacion(topicExist.get().getFechaCreacion());
        updateTopic.setCourse(topicExist.get().getCourse());
        updateTopic.setUser(topicExist.get().getUser());
        topicRepository.save(updateTopic);
        return datosUpdateTopic;
    }

    //Eliminar
    public void deleteTopicc(Long id){
        Optional<TopicEntity> topicExist = topicRepository.findById(id);
        if (!topicExist.isPresent()){
            throw new RuntimeException("Topico no existe");
        }
        topicRepository.deleteById(id);
    }
    //bUSCAR UN TOPIC
    public DatosRegistrarTopic searchTopic(Long id){
        Optional<TopicEntity> topic = topicRepository.findById(id);
        if (!topic.isPresent()){
            throw new RuntimeException("El topico no exite");
        }
        return TopicMapper.toDatosMostrar(topic.get());
    }
}
