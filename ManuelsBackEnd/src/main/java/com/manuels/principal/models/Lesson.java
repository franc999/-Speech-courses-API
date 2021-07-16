package com.manuels.principal.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@JsonInclude
@Data
@Entity
@Table(name = "lesson")
public class Lesson implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lesson")
    private Long idLesson;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "requeriments")
    private String requeriments;
    
    @Column(name = "forWho")
    private String forWho;
    
    @Column(name = "teacher")
    private String teacher;
    
    @Column(name = "duration")
    private int duration;
    
    @Column(name = "quota")
    private int quota;
    
    @ManyToMany
    @JoinTable(name="lesson_dates"
              ,joinColumns=@JoinColumn(name="fk_lesson")
              ,inverseJoinColumns=@JoinColumn(name="fk_date")
              )
    private List<DateC> dates;
}