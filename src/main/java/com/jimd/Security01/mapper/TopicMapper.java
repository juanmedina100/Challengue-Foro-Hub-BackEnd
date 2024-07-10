package com.jimd.Security01.mapper;

import com.jimd.Security01.persistencia.entities.foro.TopicEntity;
import com.jimd.Security01.service.dtoTopic.DatosMostrarTopicList;
import com.jimd.Security01.service.dtoTopic.DatosRegistrarTopic;
import com.jimd.Security01.service.dtoTopic.RespuestaAMostrar;

import java.util.List;
import java.util.stream.Collectors;

public class TopicMapper {

    public static DatosRegistrarTopic toTopic(TopicEntity topic){
        return new DatosRegistrarTopic(
                topic.getTitulo(),
                topic.getMensaje(),
                topic.getFechaCreacion(),
                true,
                topic.getCourse().getId(),
                topic.getUser().getId()
        );
    }

    public static List<DatosMostrarTopicList> toTopiccList(List<TopicEntity> topicEntityList){
        return topicEntityList.stream().map(t->new DatosMostrarTopicList(
                t.getTitulo(),t.getMensaje(),t.getFechaCreacion(),t.isStatus(),
                t.getCourse().getNombre(),t.getUser().getUsername(),
                t.getResponEntityList().stream().map(respuesta->
                                new RespuestaAMostrar(respuesta.getMensaje(), respuesta.getFechaCreacion()))
                        .collect(Collectors.toList())
        )).collect(Collectors.toList());
    }
    public static DatosRegistrarTopic toDatosMostrar(TopicEntity topic){
        DatosRegistrarTopic topico = new DatosRegistrarTopic(
                topic.getTitulo(),
                topic.getMensaje(),
                topic.getFechaCreacion(),
                topic.isStatus(),
                topic.getCourse().getId(),
                topic.getUser().getId()
        );
        return topico;
    }
}
