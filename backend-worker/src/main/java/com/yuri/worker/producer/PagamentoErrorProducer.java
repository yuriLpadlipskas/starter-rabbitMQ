package com.yuri.worker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class PagamentoErrorProducer {

    private final AmqpTemplate amqpTemplate;

    public PagamentoErrorProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }
    public void gerarResposta(String mensagem){
        amqpTemplate.convertAndSend(
                "pagamento-response-erro-exchange",
                "pagamento-response-erro-route-key",
                mensagem
        );
    }
}
