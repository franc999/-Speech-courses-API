package com.manuels.principal.service;

import com.manuels.principal.dao.IPublicationDao;
import com.manuels.principal.models.Image;
import com.manuels.principal.models.Publication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PublicationService implements IPublicationService {
    
    @Autowired
    private ImageService imageService;
    
    @Autowired
    private IPublicationDao publicationDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Publication> listPublications() {
        List<Publication> publications = publicationDao.listOrderDate();
        
        publications.forEach(p -> {
            if(p.getImage() !=  null)
                p.getImage().setBytes(imageService.decompressBytes(p.getImage().getBytes()));
        });
        
        return publications;
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public Publication create(Publication publication) {
        
        if(publication.getImage() != null){
            
           Image image = imageService.create(publication.getImage());
           publication.setImage(image);
        }

        return publicationDao.save(publication);
    }

    @Override
    public void delete(Publication publication) {
        publicationDao.delete(publication);
    }

    @Override
    public Publication update(Publication publication) {
        
        Publication existingPublication = publicationDao.findById(publication.getIdPublication()).orElse(null);

        existingPublication.setTitle(publication.getTitle());
        existingPublication.setDescription(publication.getDescription());
        existingPublication.setDescription(publication.getDescription1());
        existingPublication.setDescription(publication.getDescription2());
        existingPublication.setDescription(publication.getDescription3());
        existingPublication.setSubtitle(publication.getSubtitle());
        existingPublication.setSubtitle(publication.getSubtitle2());
        existingPublication.setImage(publication.getImage());

        return publicationDao.save(publication);
    }

    @Override
    @Transactional(readOnly = true)
    public Publication find(Long idPublication) {
        Publication publication = publicationDao.findById(idPublication).orElse(null);
        if(publication.getImage() !=  null)
                publication.getImage().setBytes(imageService.decompressBytes(publication.getImage().getBytes()));
        return publication;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Publication> findByName(String publication) {
        List<Publication> publications = publicationDao.findByName(publication);
        
        publications.forEach(p -> {
            if(p.getImage() !=  null)
                p.getImage().setBytes(imageService.decompressBytes(p.getImage().getBytes()));
        });
        
        return publications;
    }
}