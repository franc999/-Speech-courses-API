package com.manuels.principal.models;

import java.io.Serializable;
import javax.persistence.CascadeType;

import com.manuels.principal.models.Image;

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
@Table(name = "publication")
public class Publication implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publication")
    private Long idPublication;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "description")
    private String descripcion;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_img")
    private Image image;
}
