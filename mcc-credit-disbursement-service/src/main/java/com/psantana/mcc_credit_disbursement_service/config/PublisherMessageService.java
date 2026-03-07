package com.psantana.mcc_credit_disbursement_service.config;

import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.psantana.mcc_credit_disbursement_service.event.CreditDisbursementEvent;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@AllArgsConstructor
public class PublisherMessageService {

    private ServiceBusSenderClient senderClient;
    private ObjectMapper objectMapper;

    public void sendCreditDisbursementEvent(CreditDisbursementEvent creditDisbursementEvent) {
        try {
            String payload = objectMapper.writeValueAsString(creditDisbursementEvent);
            ServiceBusMessage serviceBusMessage = new ServiceBusMessage(payload);
            senderClient.sendMessage(serviceBusMessage);
            log.info("Message sent");
        }catch (Exception ex){
            log.error("Error while sending credit disbursement event", ex);
        }
    }

}
