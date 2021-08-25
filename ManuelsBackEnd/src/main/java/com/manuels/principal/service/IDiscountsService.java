package com.manuels.principal.service;

import com.manuels.principal.models.Discounts;
import java.util.List;

public interface IDiscountsService {
    
    public List<Discounts> listDiscounts();
    
    public Discounts create(Discounts discount);
    
    public void delete(Discounts discount);
    
    public Discounts update(Discounts discount);
    
    public Discounts findWithId(Long idDiscounts);
    
    public List<Discounts> findByCode(String code); 
}