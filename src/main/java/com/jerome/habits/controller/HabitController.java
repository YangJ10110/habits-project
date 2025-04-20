package com.jerome.habits.controller;

import com.jerome.habits.model.Habit;
import com.jerome.habits.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/habits")  // Base URL for all habit-related routes
public class HabitController {

    @Autowired
    private HabitRepository habitRepository;

    // Create or update a habit
    @PostMapping
    public ResponseEntity<Habit> createOrUpdateHabit(@RequestBody Habit habit) {
        Habit savedHabit = habitRepository.save(habit);
        return new ResponseEntity<>(savedHabit, HttpStatus.CREATED);
    }

    // Get a habit by ID
    @GetMapping("/{id}")
    public ResponseEntity<Habit> getHabitById(@PathVariable String id) {
        Optional<Habit> habit = habitRepository.findById(id);
        return habit.map(ResponseEntity::ok)
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all habits
    @GetMapping("getall")
    public ResponseEntity<Iterable<Habit>> getAllHabits() {
        Iterable<Habit> habits = habitRepository.findAll();
        return new ResponseEntity<>(habits, HttpStatus.OK);
    }
    @GetMapping("/hello")
    public String home() {
        return "Hello, this is your HabitsTracker app!";
    }

    // Delete a habit by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabit(@PathVariable String id) {
        if (habitRepository.existsById(id)) {
            habitRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
