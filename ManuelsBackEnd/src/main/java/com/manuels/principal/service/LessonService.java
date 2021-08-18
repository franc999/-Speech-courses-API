package com.manuels.principal.service;

import com.manuels.principal.dao.ILessonDao;
import com.manuels.principal.models.Lesson;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService implements ILessonService{
    
    @Autowired
    private ILessonDao lessonDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Lesson> listLessons() {
        return lessonDao.findAll();
    }

    @Override
    public Lesson create(Lesson lesson) {
        return lessonDao.save(lesson);
    }

    @Override
    public void delete(Lesson lesson) {
        lessonDao.delete(lesson);
    }

    @Override
    public Lesson find(Lesson lesson) {
        return lessonDao.findById(lesson.getIdLesson()).orElse(null);
    }
    
    @Override
    public Lesson update(Lesson lesson){
        
        Lesson existingLesson = lessonDao.findById(lesson.getIdLesson()).orElse(null);
        
        existingLesson.setDates(lesson.getDates());
        existingLesson.setDescription(lesson.getDescription());
        existingLesson.setDuration(lesson.getDuration());
        existingLesson.setForWho(lesson.getForWho());
        existingLesson.setQuota(lesson.getQuota());
        existingLesson.setRequeriments(lesson.getRequeriments());
        existingLesson.setTeacher(lesson.getTeacher());
        existingLesson.setTitle(lesson.getTitle());
        
        return lessonDao.save(existingLesson);
    }
    
    @Override
    public List<Lesson> findByName(String title) {
        return lessonDao.findByName(title);
    }

    @Override
    public Lesson findWithId(Long idLesson) {
        return lessonDao.findById(idLesson).orElse(null);    
    }

    @Override
    public void moreQuota(Long idLesson) {
        Lesson lesson = findWithId(idLesson);  
        lesson.setQuota(lesson.getQuota() + 1);
        lessonDao.save(lesson);
    }

    @Override
    public void lessQuota(Long idLesson) {
        Lesson lesson = findWithId(idLesson);  
        lesson.setQuota(lesson.getQuota() - 1);
        lessonDao.save(lesson);
    }   
}