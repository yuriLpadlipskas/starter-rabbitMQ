package com.yuri.backend.api.consumer;

import com.yuri.backend.api.facade.PagamentoFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PagamentoResponseSuccesConsumer {

    private final PagamentoFacade pagamentoFacade;

    public PagamentoResponseSuccesConsumer(PagamentoFacade pagamentoFacade) {
        this.pagamentoFacade = pagamentoFacade;
    }

    @RabbitListener(queues = {"pagamento-response-sucesso-queue"})
    public void receive(@Payload Message message){
        System.out.println("Message: " + message + " " + LocalDateTime.now());
        String payload = (String) message.getPayload();
        pagamentoFacade.sucessoPagamento(payload);
    }
}
