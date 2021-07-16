package com.manuels.principal.service;

import com.manuels.principal.models.Publication;

import java.util.List;

public interface IPublicationService {
    
    public List<Publication> listPublications();
    
    public Publication create(Publication publication);
    
    public void delete(Publication publication);
    
    public Publication update(Publication publication);

    public Publication find(Long idPublication);
    
    public List<Publication> findByName(String publication); 
}
