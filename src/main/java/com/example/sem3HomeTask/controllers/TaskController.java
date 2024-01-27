package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Конструктор обработки задач.
 */
@RestController
@RequestMapping("/tasks") //localhost:8080/tasks
public class TaskController {

    /**
     * Сервис обработки задач.
     */
    @Autowired
    private DataProcessingService service;

    /**
     * Получение списка поддерживаемых задач.
     * @return список задач.
     */
    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Получение списка пользователей отсортированных по возрасту.
     *
     * @return JSON ответ со списком пользователй.
     */
    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return service.sortUserByAge(service.getRepository().getUsers());
    }

    /**
     * Получение списка пользователя старше заданного возраста.
     * @param age возраст пользователей.
     * @return JSON ответ со списком пользователей.
     */
    @GetMapping("/filter/{age}") //localhost:8080/tasks/filter
    public List<User> filterUsersByAge(@PathVariable("age") int age) {
        List<User> users = service.getRepository().getUsers();
        return service.filterUserByAge(users, age);
    }

    /**
     * Получение среднего возраста пользователей
     * @return JSON ответ со среднем возрастом.
     */
    @GetMapping("/calc")//localhost:8080/tasks/calc
    public double calculateAverageAge(){
        List<User> users = service.getRepository().getUsers();
        return service.calculateAverageAge(users);
    }
}
