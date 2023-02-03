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
//    private double valorContacao;
//    private double valorTotal;
    private String numeroAgencia;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTipoMoeda() {
        return tipoMoeda;
    }

    public void setTipoMoeda(String tipoMoeda) {
        this.tipoMoeda = tipoMoeda;
    }

    public double getValorMoedaEstrangeira() {
        return valorMoedaEstrangeira;
    }

    public void setValorMoedaEstrangeira(double valorMoedaEstrangeira) {
        this.valorMoedaEstrangeira = valorMoedaEstrangeira;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }
}
