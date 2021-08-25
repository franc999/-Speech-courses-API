package com.manuels.principal;

import com.manuels.principal.service.PaymentService;
import com.manuels.principal.dao.IPaymentDao;
import com.manuels.principal.models.Image;
import com.manuels.principal.models.Payment;
import com.manuels.principal.service.ImageService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {
    
    @MockBean
    private IPaymentDao paymentMock;
    
    @InjectMocks
    private PaymentService paymentService;

    /*@Test
    public void listPaymentsTest(){
        
        Image aux = new Image();
        
        aux.setIdImage(1L);
        aux.setName("hola.jpg");
        aux.setType("image/jpeg");
        String string = "lala";
        byte[] data = string.getBytes();
        aux.setBytes(data);
        
        Payment payment = new Payment();
        payment.setDate(LocalDate.MAX);
        payment.setEmail("lala");
        payment.setImage(aux);
        payment.setLastname("lala");
        payment.setName("lalalala");
        payment.setPhone("2131231");
        payment.setPayment(Boolean.FALSE);
        payment.setDateLesson("dasas");
        
        Payment payment1 = new Payment();
        
        payment1.setDate(LocalDate.MAX);
        payment1.setEmail("lala");
        payment1.setImage(aux);
        payment1.setLastname("lala");
        payment1.setName("lalalala");
        payment1.setPhone("2131231");
        payment1.setPayment(Boolean.FALSE);
        payment1.setDateLesson("dasas");
        
        List<Payment> payments = new ArrayList<>();
        payments.add(payment);
        payments.add(payment1);
        
        given(paymentMock.findAll()).willReturn(payments);
        
        List<Payment> expected = paymentService.listPayments();
        
        assertEquals(expected, payments);
    }
    
    public void createPaymentTest(){
        
        Image aux = new Image();
        
        aux.setIdImage(1L);
        aux.setName("hola.jpg");
        aux.setType("image/jpeg");
        String string = "lala";
        byte[] data = string.getBytes();
        aux.setBytes(data);
    }
    
    public void findWithIdTest(){
        
    }
    
    public void findByNameTest(){
        
    }
    
    public void delete(){
        
    }*/
}