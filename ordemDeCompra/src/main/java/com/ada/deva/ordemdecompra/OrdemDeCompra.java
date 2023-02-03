package com.ada.deva.ordemdecompra;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class OrdemDeCompra {
    @Id
    private String id;
    private String CPF;
    private LocalDate data;
    private String tipoMoeda;
    private double valorMoedaEstrangeira;
    private double valorContacao;
    private double valorTotal;
    private String numeroAgencia;

}
