package com.manuels.principal.dao;

import com.manuels.principal.models.Discounts;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IDiscountsDao extends JpaRepository<Discounts, Long>{
    @Query(value = "SELECT *FROM discounts WHERE code LIKE %?1%", nativeQuery = true)
    public List<Discounts> findByCode(String code);
}