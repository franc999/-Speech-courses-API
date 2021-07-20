package com.manuels.principal;

import com.manuels.principal.dao.IPublicationDao;
import com.manuels.principal.service.PublicationService;
import com.manuels.principal.models.Publication;
import com.manuels.principal.models.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PublicationServiceTest {
    
    @MockBean
    private IPublicationDao publicationMock;
    
    @InjectMocks
    private PublicationService publicationService;
    
    @Test
    public void listPublicationsTest(){
        
        Publication publication1 = new Publication();
        Publication publication2 = new Publication();
        
        List<Publication> publications = new ArrayList<>();
        
        Image image = new Image();
        
        image.setIdImage(1L);
        image.setName("hola.jpg");
        image.setType("image/jpeg");
        //image.setBytes(bytes);
        
        publication1.setDescripcion("djdj djkjdk");
        publication1.setIdPublication(1L);
        publication1.setTitle("llalal");
        publication1.setImage(image);
        
        publication2.setDescripcion("skk ksks");
        publication2.setIdPublication(2L);
        publication2.setTitle("lals fkfk");
        publication2.setImage(image);
        
        publications.add(publication1);
        publications.add(publication2);
        
        given(publicationMock.findAll()).willReturn(publications);
        
        List<Publication> expected = publicationService.listPublications();
        
        assertEquals(expected, publications);
    }
    
    @Test
    public void createPublicationTest(){
        
        Publication publication1 = new Publication();
        Publication publication2 = new Publication();
        
        Image image = new Image();
        
        image.setIdImage(1L);
        image.setName("hola.jpg");
        image.setType("image/jpeg");
        //image.setBytes(bytes);
        
        publication1.setDescripcion("djdj djkjdk");
        publication1.setIdPublication(1L);
        publication1.setTitle("llalal");
        publication1.setImage(image);
        
        given(publicationMock.save(publication1)).willAnswer
        (invocation -> invocation.getArgument(0));
        
        Publication savedDateC = publicationMock.save(publication1);
        
        assertThat(savedDateC).isNotNull();
        
        verify(publicationMock).save(any(Publication.class));
    }
    
    @Test
    public void findPublicationTest(){
        
        Publication publication1 = new Publication();
        Publication publication2 = new Publication();
        
        Image image = new Image();
        
        image.setIdImage(1L);
        image.setName("hola.jpg");
        image.setType("image/jpeg");
        //image.setBytes(bytes);
        
        publication1.setDescripcion("djdj djkjdk");
        publication1.setIdPublication(1L);
        publication1.setTitle("llalal");
        publication1.setImage(image);
        
        given(publicationMock.findById(publication1.getIdPublication()))
                .willReturn(Optional.of(publication1));

        verify(publicationMock, never()).save(any(Publication.class));
    }
    
    @Test
    public void deletePublicationTest(){
        
        Publication publication1 = new Publication();
        Publication publication2 = new Publication();
        
        Image image = new Image();
        
        image.setIdImage(1L);
        image.setName("hola.jpg");
        image.setType("image/jpeg");
        //image.setBytes(bytes);
        
        publication1.setDescripcion("djdj djkjdk");
        publication1.setIdPublication(1L);
        publication1.setTitle("llalal");
        publication1.setImage(image);
        
        publicationService.delete(publication1);
        publicationService.delete(publication1);
        
        verify(publicationMock, times(2)).delete(publication1);
    }
    
    @Test
    public void updatePublicationTest(){
        
    }
}