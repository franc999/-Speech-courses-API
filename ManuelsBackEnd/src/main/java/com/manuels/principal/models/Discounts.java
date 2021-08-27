package com.manuels.principal.models;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
@Entity
@Table(name = "discounts")
public class Discounts {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_discount")
    private Long idDiscounts;
    
    @Column(name = "code")
    private String code;
}