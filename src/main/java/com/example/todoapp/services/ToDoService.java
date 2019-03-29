package com.example.todoapp.services;

import com.example.todoapp.model.ToDoTask;
import com.example.todoapp.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }


    public List<ToDoTask> getToDo() {
        return toDoRepository.findAll();
    }

    public ToDoTask addToDo(ToDoTask toDoTask) {
        return toDoRepository.save(toDoTask);
    }

    public void deleteToDo(String toDo) {
        toDoRepository.deleteByToDoName(toDo);
    }

    public void updateToDo(ToDoTask toDoTask) {

        System.out.println(toDoTask);
        toDoRepository
                .findByToDoName(toDoTask.getTaskName())
                .ifPresent(p -> {
                    p.setTaskInfo(toDoTask.getTaskInfo());
                    p.setDate(toDoTask.getDate());
                    p.setDone(toDoTask.getDone());
                    toDoRepository.save(p);
                });
    }

    public ToDoTask getToDoByName(String name) {
        return toDoRepository
                .findByToDoName(name).get();
    }

}
