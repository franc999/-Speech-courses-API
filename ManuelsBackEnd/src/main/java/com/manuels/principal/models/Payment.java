package com.manuels.principal.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

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
    
<<<<<<< HEAD
=======
    @Column(name = "lastname")
    private String lastname;
    
>>>>>>> das
    @Column(name = "date")
    private LocalDate date;
    
    @Column(name = "payment")
    private Boolean payment;
    
<<<<<<< HEAD
=======
    @Column(name = "phone")
    private String phone;
    
    @Transient
    private MultipartFile file;
       
    @Transient
    private String email; 

    @Transient
    private Date dateSelected;
    
    @Column(name = "date_lesson")
    private Date dateLesson;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_lesson")
    private Lesson lesson;
    
>>>>>>> das
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "voucher")
    private Image image;
}