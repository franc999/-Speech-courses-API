package com.manuels.principal.service;
import java.util.Optional;
import java.util.List;
import com.manuels.principal.models.Image;

public interface IImageService {
    
    public List<Image> listImages();

    public Image create(Image image);

    public void delete(Image image);
    
    public Image update(Image image);
    
    public Image find(Long idImage);
    
    public List<Image> findByName(String imageName);
}
