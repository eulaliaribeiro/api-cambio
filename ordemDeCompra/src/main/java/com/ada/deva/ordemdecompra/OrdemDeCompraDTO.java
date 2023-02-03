package com.ada.deva.ordemdecompra;

import lombok.Data;

import java.time.LocalDate;
@Data
public class OrdemDeCompraDTO {
    private String id;
    private String cpf;
    private LocalDate data;
    private String tipoMoeda;
    private Double valorMoedaEstrangeira;
    private Double valorCotacao;
    private Double valorTotal;
    private String numeroAgencia;

    public static OrdemDeCompraDTO of(OrdemDeCompra ordemDeCompra){
        OrdemDeCompraDTO dto = new OrdemDeCompraDTO();
        dto.setId(ordemDeCompra.getId());
        dto.setCpf(ordemDeCompra.getCPF());
        dto.setData(ordemDeCompra.getData());
        dto.setTipoMoeda(ordemDeCompra.getTipoMoeda());
        dto.setValorMoedaEstrangeira(ordemDeCompra.getValorMoedaEstrangeira());


        dto.setNumeroAgencia(ordemDeCompra.getNumeroAgencia());
        return dto;
    }

    public OrdemDeCompra toEntity(){
        OrdemDeCompra ordemDeCompra = new OrdemDeCompra();
        ordemDeCompra.setId(id);
        ordemDeCompra.setCPF(cpf);
        ordemDeCompra.setData(data);
        ordemDeCompra.setTipoMoeda(tipoMoeda);
        ordemDeCompra.setValorMoedaEstrangeira(valorMoedaEstrangeira);
        ordemDeCompra.setNumeroAgencia(numeroAgencia);
        return ordemDeCompra;
    }

}
