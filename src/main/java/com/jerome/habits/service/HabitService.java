package com.jerome.habits.service;

import com.jerome.habits.model.Habit;
import com.jerome.habits.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class HabitService {

    private final HabitRepository habitRepository;

    @Autowired
    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    // Method to create or update a habit
    public Habit createOrUpdateHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    // Method to get all habits
    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    // Method to get a habit by ID
    public Optional<Habit> getHabitById(String id) {
        return habitRepository.findById(id);
    }

    // Method to delete a habit
    public void deleteHabit(String id) {
        habitRepository.deleteById(id);
    }
}
