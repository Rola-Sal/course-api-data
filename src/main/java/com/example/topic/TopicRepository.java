package com.example.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> { //<class name, type of id> لحتى نطبق الCRUD methods عليها

}
