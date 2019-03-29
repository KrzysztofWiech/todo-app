package com.example.todoapp.controller;


import com.example.todoapp.model.ToDoTask;
import com.example.todoapp.services.ToDoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class HomeController {


    private ToDoService toDoService;

    public HomeController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("todo", toDoService.getToDo()); // binduje, przekazuje planetService.get pod parametrem planets
        return "index";
    }

    @GetMapping("/add")
    public String addToDoTask(@ModelAttribute ToDoTask toDoTask) {
        System.out.println(toDoTask.getDate());
        toDoService.addToDo(toDoTask);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteToDo(@RequestParam(value = "todo") String taskName) {
        toDoService.deleteToDo(taskName);
        return "redirect:/";
    }

    @GetMapping("/upd")
    public String updateToDo(@ModelAttribute ToDoTask toDoTask) {

        System.out.println(toDoTask);
        toDoService.updateToDo(toDoTask);
        return "redirect:/";
    }

    @GetMapping("/updatepage")
    public String updateHome(@RequestParam(value = "todo") String taskName, Model model) {
        System.out.println(taskName);
        System.out.println(taskName);
        ToDoTask toDoTask = toDoService.getToDoByName(taskName);
        model.addAttribute("todo", toDoTask);
        return "update";
    }

}
