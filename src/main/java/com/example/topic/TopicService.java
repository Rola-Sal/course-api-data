package com.example.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //we will link it to database
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics(){
       // return topics; //now we will return it from db using Repository
        List<Topic> topics = new ArrayList<Topic>();
        topicRepository.findAll()
                .forEach(topics :: add);
        return topics;
    }

    public Optional<Topic> getTopic(String id){
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic); //the same as create new topic it will search by id first
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
