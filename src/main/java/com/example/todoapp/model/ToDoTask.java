package com.example.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor//gdy mamy buildera to tej adnotacji nie potrzebujemy - LOMBOK
@AllArgsConstructor//gdy mamy builidera to tej adnotacji nie potrzebujemy
//@Data robi nam gett sett toString hashCode Equals
@Data
//@Builder wzorzec projektowy, tworzy nam nową wewnterzna klasę statyczna  która posiada metody nazwane tak samo jak zmienne
@Builder
//Entity baza danych mapuje na encje bazy danych
@Entity
//@Table tworzy nam tabelę o nazwie
@Table(name = "liststodo")
public class ToDoTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //kolumny, unique - unikalny, nulltable
    @Column(name = "task_name", unique = true, nullable = false)
    private String taskName;

    @Column(name = "task_info")
    private String taskInfo;

    @Column(name = "date")
    private Date date;

    @Column(name = "done")
    private Boolean done;

}
