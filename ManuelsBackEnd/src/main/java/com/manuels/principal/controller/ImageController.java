package com.manuels.principal.controller;

import com.manuels.principal.service.ImageService;
import com.manuels.principal.models.Image;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/images")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ImageController {
    
    @Autowired
    private ImageService imageService;
    
    @PostMapping
    public ResponseEntity<Image> create(@RequestBody MultipartFile image)
                                             throws IOException{
        Image img = new Image(image.getOriginalFilename(),
                              image.getContentType(),
                              imageService.compressBytes(image.getBytes()));
        
        return ResponseEntity.status(HttpStatus.CREATED).body(imageService.create(img));
    }
    
    @GetMapping
    public List<Image> read() throws IOException {
        
        /*List<Image> aux = imageService.listImages();

        List<Image> images = new ArrayList();

        for(Image img : aux){
 
            Image retrievedImage = new Image(
                    img.getName(),
                    img.getType(),
                    imageService.decompressBytes(img.getBytes()));
            retrievedImage.setIdImage(img.getIdImage());
                    
            images.add(retrievedImage);
        }*/

        return imageService.listImages();
    }
    
    /*@GetMapping("/{names}")
    public List<Image> getImage(@PathVariable("names") String names) throws IOException {
        
        final List<Image> aux = imageService.findByName(names);
        List<Image> images = new ArrayList();
        
        Image retrievedImage;
        
        for(Image img : aux){
            retrievedImage = new Image(img.getName(), img.getType(),
                imageService.decompressBytes(img.getBytes()));
            retrievedImage.setIdImage(img.getIdImage());
            images.add(retrievedImage);
        }
        
        return images;
    }*/
    
    @GetMapping("/{names}")
    public List<Image> getImage(@PathVariable("names") String names) throws IOException {
        
        return imageService.findByName(names);
    }
}
