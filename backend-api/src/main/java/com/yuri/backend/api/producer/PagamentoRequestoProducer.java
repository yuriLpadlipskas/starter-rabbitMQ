package com.yuri.backend.api.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuri.backend.api.dto.PagamentoDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class PagamentoRequestoProducer {

    private final AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper;

    public PagamentoRequestoProducer(AmqpTemplate amqpTemplate, ObjectMapper objectMapper) {
        this.amqpTemplate = amqpTemplate;
        this.objectMapper = objectMapper;
    }

    public void integrar(PagamentoDTO pagamento) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "pagamento-request-exchange",
                "pagamento-request-route-key",
                objectMapper.writeValueAsString(pagamento)
        );
    }
}
