package com.jerome.habits.repository;

import com.jerome.habits.model.Habit;
import org.springframework.data.mongodb.repository.MongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HabitRepository extends MongoRepository<Habit, String>{

    
} 
