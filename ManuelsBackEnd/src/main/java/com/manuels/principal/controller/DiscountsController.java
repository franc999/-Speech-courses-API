package com.manuels.principal.controller;

import com.manuels.principal.exceptions.NotFoundException;
import com.manuels.principal.models.Discounts;
import com.manuels.principal.service.DiscountsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/discounts")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DiscountsController {
    
    @Autowired
    private DiscountsService discountsService;
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Discounts> create(@RequestBody Discounts discount){
        return ResponseEntity.status(HttpStatus.CREATED).body(discountsService.create(discount));
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<Discounts> listAll(){
        return discountsService.listDiscounts();
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Discounts> readBy(@PathVariable(value = "id") Long idDiscount){

        Discounts discount = discountsService.findWithId(idDiscount);

        if (discount == null) { 
            throw new NotFoundException("No se encontro el codigo");
        }
        return ResponseEntity.ok(discount);
    }
    
    @GetMapping("/names/{code}")
    public ResponseEntity<List<Discounts>> readByCode(@PathVariable(value = "code") String code) throws NotFoundException{

        List<Discounts> discounts = discountsService.findByCode(code);

        if (discounts.isEmpty()) {
            throw new NotFoundException("No se encontro el codigo");
        }
        return ResponseEntity.ok(discounts);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Discounts> update(@RequestBody Discounts discount,
           @PathVariable(value = "id") Long idDiscount){
        return ResponseEntity.status(HttpStatus.CREATED).body(discountsService.update(discount));
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Discounts> delete(@PathVariable(value = "id") Long idDiscount) {

        Discounts discount = discountsService.findWithId(idDiscount);

        if (discount == null) {
            return ResponseEntity.notFound().build();
        }

        discountsService.delete(discount);
        return ResponseEntity.ok().build();
    }
}