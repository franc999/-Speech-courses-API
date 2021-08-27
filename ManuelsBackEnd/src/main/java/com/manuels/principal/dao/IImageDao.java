package com.manuels.principal.dao;

import com.manuels.principal.models.Image;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IImageDao extends JpaRepository<Image, Long>{
    @Query(value = "SELECT *FROM image WHERE name LIKE ?1", nativeQuery = true)
    List<Image> findByName(String name);
}