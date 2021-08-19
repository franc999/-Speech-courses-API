package com.manuels.principal.models;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Entity
@Table(name = "payment")
public class Payment implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Long idPayment;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "date")
    private LocalDate date;
    
    @Column(name = "payment")
    private Boolean payment;
    
    @Transient
    private MultipartFile file;
       
    @Transient
    private String email; 
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_lesson")
    private Lesson lesson;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "voucher")
    private Image image;
}