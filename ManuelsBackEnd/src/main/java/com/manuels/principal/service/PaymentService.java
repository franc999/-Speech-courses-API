package com.manuels.principal.service;

import com.manuels.principal.dao.IPaymentDao;
import com.manuels.principal.models.Payment;
import com.manuels.principal.models.Image;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService implements IPaymentService{
    
    @Autowired
    private IPaymentDao paymentDao;
    
    @Autowired
    private ImageService imageService;
    
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private LessonService lessonService;
    
    @Override
    @Transactional(readOnly = true)
    public List<Payment> listPayments() {

        List<Payment> payments = paymentDao.findAll();
        
        payments.forEach(p -> {
            p.getImage().setBytes(imageService.decompressBytes(p.getImage().getBytes()));
        });
        
        return payments;
    }

    @Override
    public Payment create(Payment payment) {

        Image image = imageService.create(payment.getImage());
        payment.setImage(image);
        
        lessonService.lessQuota(payment.getLesson().getIdLesson());
        
        try {
            emailService.sendMail(
                    payment.getEmail(),
                    "fnsoftdevmailer@gmail.com",
                    "\nPago de clase \n" ,
                    payment.getName() + " " +
                            payment.getLastname() + "\n\nPago tu clase, por favor verifica en el panel de control para confirmar el pago\n\n"
                                    + "O podes seguir mediante el siguiente enlace de manera mas sencilla : \n\n");
        } catch (MessagingException ex) {
            Logger.getLogger(PaymentService.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return paymentDao.save(payment);
    }

    @Override
    public void delete(Long idPayment) {
        paymentDao.deleteById(idPayment);
    }

    @Override
    public Payment update(Payment payment) {
        
        Payment existingPayment = paymentDao.findById(payment.getIdPayment()).orElse(null);
        
        existingPayment.setDate(LocalDate.now());
        existingPayment.setImage(payment.getImage());
        existingPayment.setName(payment.getName());
        existingPayment.setPayment(payment.getPayment());

        return existingPayment;
    }

    @Override
    @Transactional(readOnly = true)
    public Payment findWithId(Long idPayment) {
        return paymentDao.findById(idPayment).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Payment> findByName(String name) {

        List<Payment> payments = paymentDao.findByName(name);
        
        payments.forEach(p -> {
            p.getImage().setBytes(imageService.decompressBytes(p.getImage().getBytes()));
        });
        
        return payments;
    }

    @Override
    public Payment setTrue (Long idPayment){
        Payment existingPayment = paymentDao.findById(idPayment).orElse(null);

        existingPayment.setPayment(true);

        return paymentDao.save(existingPayment);
    }
    
    @Override
    public void setFalse (Long idPayment){
        Payment existingPayment = paymentDao.findById(idPayment).orElse(null);
        if(existingPayment!=null)
            lessonService.moreQuota(existingPayment.getLesson().getIdLesson());
    }
}