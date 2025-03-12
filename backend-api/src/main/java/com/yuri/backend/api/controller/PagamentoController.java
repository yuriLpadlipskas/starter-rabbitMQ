package com.yuri.backend.api.controller;

import com.yuri.backend.api.dto.PagamentoDTO;
import com.yuri.backend.api.facade.PagamentoFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoFacade pagamentoFacade;

    public PagamentoController(PagamentoFacade pagamentoFacade) {
        this.pagamentoFacade = pagamentoFacade;
    }

    @PostMapping()
    public ResponseEntity<?> processar(@RequestBody PagamentoDTO request){
        return ResponseEntity.ok(pagamentoFacade.solicitaPagamento(request));
    }

}
