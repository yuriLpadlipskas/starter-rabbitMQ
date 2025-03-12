package com.yuri.worker.consumer;

import com.yuri.worker.producer.PagamentoErrorProducer;
import com.yuri.worker.producer.PagamentoSuccessProducer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PagamentoRequestConsumer {

    private final PagamentoSuccessProducer successProducer;
    private final PagamentoErrorProducer errorProducer;

    public PagamentoRequestConsumer(PagamentoSuccessProducer successProducer, PagamentoErrorProducer errorProducer) {
        this.successProducer = successProducer;
        this.errorProducer = errorProducer;
    }

    @RabbitListener(queues = {"pagamento-request-queue"})
    public void receberMensagem(@Payload Message message) {
        System.out.println(message);
        boolean random = new Random().nextBoolean();
        System.out.println("Random: " + random);
        if(random){
            successProducer.gerarResposta("Mensagem de sucesso do Pagamento.... "+message);
            return;
        }
        errorProducer.gerarResposta("Mensagem de erro do Pagamento... "+message);
    }
}
