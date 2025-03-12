package com.yuri.backend.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PagamentoDTO {

    private String numeroPedido;
    private BigDecimal valor;
    private String produto;

}
