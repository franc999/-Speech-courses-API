package com.manuels.principal.controller;

import com.manuels.principal.exceptions.NotFoundException;
import com.manuels.principal.models.DateC;
import com.manuels.principal.service.DateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class DateController {
    
    @Autowired
    private DateService dateService;
    
    @PostMapping
    public ResponseEntity<DateC> create(@RequestBody DateC date){
        
        return ResponseEntity.status(HttpStatus.CREATED).body(dateService.create(date));
    }
    
    @GetMapping("/dates")
    public List<DateC> listAll(){
        return dateService.listDates();
    }
    
    @GetMapping("dates/{id}")
    public ResponseEntity<DateC> readBy(@PathVariable(value = "id") Long idDate) throws NotFoundException{

        DateC date = dateService.find(idDate);

        if (date == null) {
            
            throw new NotFoundException("Not found date");
            //return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(date);
    }
    
    @PutMapping("dates/{id}")
    public ResponseEntity<DateC> update(@RequestBody DateC dateC,
           @PathVariable(value = "id") Long idDate){
        return ResponseEntity.status(HttpStatus.CREATED).body(dateService.update(dateC));
    }
    
    @DeleteMapping("dates/{id}")
    public ResponseEntity<DateC> delete(@PathVariable(value = "id") Long idDate) {

        DateC date = dateService.find(idDate);

        if (date == null) {
            return ResponseEntity.notFound().build();
        }

        dateService.delete(date);
        return ResponseEntity.ok().build();
    }
}
