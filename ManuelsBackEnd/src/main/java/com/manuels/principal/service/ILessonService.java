package com.manuels.principal.service;

import com.manuels.principal.models.Discounts;
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
    
    public void moreQuota(Long idLesson); 
    
    public void lessQuota(Long idLesson); 
    
    public Lesson createDiscount(Lesson lesson);
    
    public boolean verifyDiscount(Discounts discount);
}