package com.manuels.principal.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "lesson")
public class Lesson implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLesson;
    
    private String title;
    private String description;
    private String requeriments;
    private String forWho;
    private String teacher;
    private int duration;
    private int quota;
    
    @ManyToMany
    @JoinTable(name="lesson_dates"
              ,joinColumns=@JoinColumn(name="fk_lesson")
              ,inverseJoinColumns=@JoinColumn(name="fk_date")
              )
    private List<DateC> dates;
}