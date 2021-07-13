package com.manuels.principal.service;

import com.manuels.principal.models.DateC;
import java.util.List;

public interface IDateService {

    public List<DateC> listDates();

    public DateC create(DateC date);

    public void delete(DateC date);
    
    public DateC update(DateC date);
    
    public DateC find(Long idDate);
}
