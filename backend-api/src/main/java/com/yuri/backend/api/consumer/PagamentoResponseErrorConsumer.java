package com.yuri.backend.api.consumer;

import com.yuri.backend.api.facade.PagamentoFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PagamentoResponseErrorConsumer {

    private final PagamentoFacade pagamentoFacade;

    public PagamentoResponseErrorConsumer(PagamentoFacade pagamentoFacade) {
        this.pagamentoFacade = pagamentoFacade;
    }

    @RabbitListener(queues = {"pagamento-response-erro-queue"})
    public void receive(@Payload Message message){
        System.out.println("Message: " + message + " " + LocalDateTime.now());
        String payload = (String) message.getPayload();
        pagamentoFacade.erroPagamento(payload);
    }
}
