package com.manuels.principal.service;

import com.manuels.principal.dao.ILessonDao;
import com.manuels.principal.models.Discounts;
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
    
    @Autowired
    private DiscountsService discountsService;
    
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
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public List<Lesson> findByName(String title) {
        return lessonDao.findByName(title);
    }

    @Override
    @Transactional(readOnly = true)
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
    
    /*@Override
    public Lesson createDiscount(Lesson lesson){
        Lesson existingLesson = lessonDao.findById(lesson.getIdLesson()).orElse(null);
        if(existingLesson != null){
                    
            Discounts discount = new Discounts();
            discount.setCode(lesson.getCode());
            discount.setLesson(lesson);

            discountsService.create(discount);
        
            existingLesson.setDiscountLink(lesson.getDiscountLink());
        }
        return lessonDao.save(existingLesson);
    }
    
    @Override
    public boolean verifyDiscount(Discounts discount){
       /* Lesson lesson = lessonDao.findById(idLesson).orElse(null);
        
        if(lesson != null){
        boolean flag = false;
            List<Discounts> discounts = discountsService.findByCode(discount.getCode());
            if(!discounts.isEmpty()){
                flag=true;
            }
        return flag;
    }*/
}