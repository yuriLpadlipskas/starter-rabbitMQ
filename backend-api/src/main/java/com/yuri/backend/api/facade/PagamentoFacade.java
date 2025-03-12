package com.yuri.backend.api.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yuri.backend.api.dto.PagamentoDTO;
import com.yuri.backend.api.producer.PagamentoRequestoProducer;
import org.springframework.stereotype.Service;

@Service
public class PagamentoFacade {

    private final PagamentoRequestoProducer producer;

    public PagamentoFacade(PagamentoRequestoProducer producer) {
        this.producer = producer;
    }

    public String solicitaPagamento(PagamentoDTO request) {
        try {
            producer.integrar(request);
        } catch (JsonProcessingException e) {
            return "Ocorreu um erro ao solicitar o pagamento: " + e.getMessage();
        }

        return "Pagamento aguardando confirmação...";
    }

    public void erroPagamento(String payload) {
        System.err.println("=========== RESPOSTA ERRO =========== " + payload);
    }

    public void sucessoPagamento(String payload) {
        System.out.println("=========== RESPOSTA SUCESSO =========== " + payload);
    }
}
