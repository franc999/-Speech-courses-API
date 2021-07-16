package com.manuels.principal;

import com.manuels.principal.dao.IDateDao;
import com.manuels.principal.dao.ILessonDao;
import com.manuels.principal.models.DateC;
import com.manuels.principal.models.Lesson;
import com.manuels.principal.service.LessonService;
import java.util.ArrayList;
import java.util.Date;
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
public class LessonServiceTest {
    
    @MockBean
    private ILessonDao lessonMock;
    
    @MockBean
    private IDateDao dateMock;
    
    @InjectMocks
    private LessonService lessonService;
    
    /*
    
    
    public Lesson update(Lesson lesson);
    
 
    
    public Lesson findWithId(Long idLesson);
    
    public List<Lesson> findByName(String title); */
    
        
    @Test
    public void listLessonsTest(){
        
        Lesson lesson = new Lesson();
        Lesson lesson1 = new Lesson();
        DateC date = new DateC();
        DateC date1 = new DateC();
        List<DateC>dates = new ArrayList<>();
            
        date.setIdDate(1L);
        date.setDate(new Date(System.currentTimeMillis()));
        
        date1.setIdDate(2L);
        date1.setDate(new Date(System.currentTimeMillis()));
        
        dates.add(date);
        dates.add(date1);
        
        lesson.setDates(dates);
        lesson.setDescription("descripcion");
        lesson.setRequeriments("requeriments");
        lesson.setForWho("para vos");
        lesson.setTeacher("teacher");
        lesson.setTitle("title");
        lesson.setDuration("90");
        lesson.setQuota(50);
        
        lesson1.setDates(dates);
        lesson1.setDescription("sssfffasda");
        lesson1.setRequeriments("sdasadsad");
        lesson1.setForWho("para fasfsadasda");
        lesson1.setTeacher("asdasdas");
        lesson1.setTitle("asdasads");
        lesson1.setDuration("60");
        lesson1.setQuota(40);
        
        List<Lesson>lessons = new ArrayList();
        lessons.add(lesson);
        lessons.add(lesson1);
        
        given(lessonMock.findAll()).willReturn(lessons);
        
        List<Lesson> expected = lessonService.listLessons();
        
        assertEquals(expected, lessons);
    }
    
    @Test
    public void createLessonTest(){
        
        Lesson lesson = new Lesson();
        DateC date = new DateC();
        
        date.setIdDate(1L);
        date.setDate(new Date(System.currentTimeMillis()));
        List<DateC>dates = new ArrayList<>();
        dates.add(date);
        
        lesson.setDates(dates);
        lesson.setDescription("descripcion");
        lesson.setRequeriments("requeriments");
        lesson.setForWho("para vos");
        lesson.setTeacher("teacher");
        lesson.setTitle("title");
        lesson.setDuration("90");
        lesson.setQuota(50);
        
        given(lessonMock.save(lesson)).willAnswer
        (invocation -> invocation.getArgument(0));
        
        Lesson savedLesson = lessonMock.save(lesson);
        
        assertThat(savedLesson).isNotNull();
        
        verify(lessonMock).save(any(Lesson.class));
    }
    
    @Test
    public void findLessonTest(){
        
        Lesson lesson = new Lesson();
        DateC date = new DateC();
        
        date.setIdDate(1L);
        date.setDate(new Date(System.currentTimeMillis()));
        List<DateC>dates = new ArrayList<>();
        dates.add(date);
        
        lesson.setDates(dates);
        lesson.setDescription("descripcion");
        lesson.setRequeriments("requeriments");
        lesson.setForWho("para vos");
        lesson.setTeacher("teacher");
        lesson.setTitle("title");
        lesson.setDuration("90");
        lesson.setQuota(50);
        
        given(lessonMock.findById(lesson.getIdLesson()))
                .willReturn(Optional.of(lesson));

        verify(lessonMock, never()).save(any(Lesson.class));
    }
    
    /*@Test
    public void findLessonByNameTest(){
        
        Lesson lesson = new Lesson();
        DateC date = new DateC();
        
        date.setIdDate(1L);
        date.setDate(new Date(System.currentTimeMillis()));
        List<DateC>dates = new ArrayList<>();
        dates.add(date);
        
        lesson.setDates(dates);
        lesson.setDescription("descripcion");
        lesson.setRequeriments("requeriments");
        lesson.setForWho("para vos");
        lesson.setTeacher("teacher");
        lesson.setTitle("title");
        lesson.setDuration(90);
        lesson.setQuota(50);
        
        String title = "title";
        
        given(lessonMock.findById(lesson.getIdLesson()))
                .willReturn(Optional.of(lesson));

        verify(lessonMock, never()).save(any(Lesson.class));
    }*/
    
    @Test
    public void deleteLessonTest(){
        
        Lesson lesson = new Lesson();
        DateC date = new DateC();
        
        date.setIdDate(1L);
        date.setDate(new Date(System.currentTimeMillis()));
        List<DateC>dates = new ArrayList<>();
        dates.add(date);
        
        lesson.setIdLesson(1L);
        lesson.setDates(dates);
        lesson.setDescription("descripcion");
        lesson.setRequeriments("requeriments");
        lesson.setForWho("para vos");
        lesson.setTeacher("teacher");
        lesson.setTitle("title");
        lesson.setDuration("90");
        lesson.setQuota(50);
        
        lessonService.delete(lesson);
        lessonService.delete(lesson);
        
        verify(lessonMock, times(2)).delete(lesson);
    }
}
