package com.jimd.Security01.controler;

import com.jimd.Security01.service.TopicService;
import com.jimd.Security01.service.dtoTopic.DatosMostrarTopicList;
import com.jimd.Security01.service.dtoTopic.DatosRegistrarTopic;
import com.jimd.Security01.service.dtoTopic.DatosUpdateTopic;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
@SecurityRequirement(name = "bearer-key")
public class TopicController {


    @Autowired
    private TopicService topicService;

//    @GetMapping("/topics")
    @PostMapping("/topic")
    public ResponseEntity<DatosRegistrarTopic> topic(@RequestBody @Valid DatosRegistrarTopic topic){
        return new ResponseEntity<>(topicService.addTopic(topic), HttpStatus.CREATED);
    }
    @GetMapping("/topics")
    public ResponseEntity<List<DatosMostrarTopicList>> topics(){
        return new ResponseEntity<>(topicService.topics(),HttpStatus.OK);
    }
    @PutMapping("/topic/{id}")
    public ResponseEntity<DatosUpdateTopic> updateTopic(@PathVariable Long id, @RequestBody @Valid DatosUpdateTopic topic){
        return ResponseEntity.ok().body(topicService.updateTopic(id,topic));
    }
    @DeleteMapping("/topic/{id}")
    public void deleteTopic(@Valid @PathVariable Long id){
        topicService.deleteTopicc(id);
    }
    @GetMapping("/topic/{id}")
    public ResponseEntity<DatosRegistrarTopic>  topicById(@Valid @PathVariable Long id){
        return new ResponseEntity<>(topicService.searchTopic(id),HttpStatus.OK);
    }

}
