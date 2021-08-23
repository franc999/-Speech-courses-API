package com.manuels.principal.service;

import com.manuels.principal.dao.IDateDao;
import com.manuels.principal.models.DateC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DateService implements IDateService {
    
    @Autowired
    private IDateDao dateDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<DateC> listDates() {
        return dateDao.findAll();
    }

    @Override
    public DateC create(DateC date) {
        return dateDao.save(date);
    }

    @Override
    public void delete(DateC date) {
        dateDao.delete(date);
    }

    @Override
    @Transactional(readOnly = true)
    public DateC find(Long idDate) {
        return dateDao.findById(idDate).orElse(null);
    }

    @Override
    public DateC update(DateC date) {

        DateC existingDate = dateDao.findById(date.getIdDate()).orElse(null);
      
        existingDate.setDate(date.getDate());

        return dateDao.save(existingDate);    
    }
}