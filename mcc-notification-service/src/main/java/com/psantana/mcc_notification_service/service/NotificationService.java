package com.psantana.mcc_notification_service.service;

import com.psantana.mcc_notification_service.event.CreditDisbursementEvent;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class NotificationService {

    private JavaMailSender mailSender;

    public void sendNotification(CreditDisbursementEvent creditDisbursementEvent) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom("piero.santtana@mail.com");
            mimeMessageHelper.setTo(creditDisbursementEvent.getEmail());
            mimeMessageHelper.setSubject("Notification Service");
            mimeMessageHelper.setText("Dear Customer, your credit disbursement of S/ "
                    + creditDisbursementEvent.getAmount() + " has been submitted.");
            log.info("Sending notification credit disbursement event");
        };
            try{
                mailSender.send(messagePreparator);
            }catch(Exception e){
                log.error("Error while sending notification", e);
                throw  new RuntimeException(e);
            }

    }

}
