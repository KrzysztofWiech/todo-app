package com.example.todoapp.repository;

import com.example.todoapp.model.ToDoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoTask, Integer> {

    @Query(value = "delete from ToDoTask t where t.taskName = ?1")//JPQL
    @Transactional
    @Modifying
    void deleteByToDoName(String toDoName);


    @Query(value = "select t from ToDoTask t where t.taskName = ?1")
//JPQL
    Optional<ToDoTask> findByToDoName(String taskName);

}
