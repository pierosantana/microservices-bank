package com.psantana.mcc_notification_service.config;

import com.azure.messaging.servicebus.ServiceBusErrorContext;
import com.azure.messaging.servicebus.ServiceBusReceivedMessage;
import com.azure.messaging.servicebus.ServiceBusReceivedMessageContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.psantana.mcc_notification_service.event.CreditDisbursementEvent;
import com.psantana.mcc_notification_service.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@AllArgsConstructor
@Service
public class SubsMessageService {

    private NotificationService notificationService;
    private ObjectMapper objectMapper;

    
    public void processMessage(ServiceBusReceivedMessageContext messageContext) {
        ServiceBusReceivedMessage message = messageContext.getMessage();
        try {
            String payload = message.getBody().toString();
            CreditDisbursementEvent event = objectMapper.readValue(payload, CreditDisbursementEvent.class);
            log.info("Received credit disbursement event: {}", event);
            notificationService.sendNotification(event);
        }catch (Exception e){
            log.error("Error while processing event", e);
        }
    }

    public void processError(ServiceBusErrorContext context) {
        log.error("Error while processing event");
    }
}
