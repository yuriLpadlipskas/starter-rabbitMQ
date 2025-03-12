package com.yuri.worker.producer;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class PagamentoSuccessProducer {

    private final AmqpTemplate amqpTemplate;

    public PagamentoSuccessProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }
    public void gerarResposta(String mensagem){
        amqpTemplate.convertAndSend(
                "pagamento-response-sucesso-exchange",
                "pagamento-response-sucesso-route-key",
                mensagem
        );
    }
}
