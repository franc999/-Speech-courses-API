package com.manuels.principal.service;

import com.manuels.principal.models.Lesson;
import java.util.List;

public interface ILessonService {
    
    public List<Lesson> listLessons();
    
    public Lesson create(Lesson lesson);
    
    public void delete(Lesson lesson);
    
    public Lesson update(Lesson lesson);
    
    public Lesson find(Lesson lesson);
    
    public Lesson findWithId(Long idLesson);
    
    public List<Lesson> findByName(String title); 
}
