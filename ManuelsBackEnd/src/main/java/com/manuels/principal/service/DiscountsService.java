package com.manuels.principal.service;

import com.manuels.principal.dao.IDiscountsDao;
import com.manuels.principal.models.Discounts;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiscountsService implements IDiscountsService{
    
    @Autowired
    private IDiscountsDao discountsDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Discounts> listDiscounts() {
        return discountsDao.findAll();
    }

    @Override
    public Discounts create(Discounts discount) {
        Discounts discounts = discountsDao.save(discount);
        System.out.println(discounts);
        return discounts;
    }

    @Override
    public void delete(Discounts discount) {
        discountsDao.delete(discount);
    }

    @Override
    public Discounts update(Discounts discount) {
        
        Discounts existingDiscount = discountsDao.findById(discount.getIdDiscounts()).orElse(null);
        
        existingDiscount.setCode(discount.getCode());
        existingDiscount.setLesson(discount.getLesson());
        
        return discountsDao.save(existingDiscount);
    }

    @Override
    @Transactional(readOnly = true)
    public Discounts findWithId(Long idDiscounts) {
        return discountsDao.findById(idDiscounts).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Discounts> findByCode(String code) {
        return discountsDao.findByCode(code);
    }
}
