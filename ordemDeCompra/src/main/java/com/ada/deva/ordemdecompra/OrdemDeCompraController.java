package com.ada.deva.ordemdecompra;

import com.ada.deva.comum.EntidadeDuplicadaException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ordemDeCompra")
public class OrdemDeCompraController {
    private final OrdemDeCompraService service;

    @GetMapping("{id}")
    public ResponseEntity<OrdemDeCompraDTO> getById(@PathVariable String id) {
        if (id == null || id.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um ID!");
        }

        OrdemDeCompra entity = service.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizada uma mesa com o ID informado!"));
        return ResponseEntity.ok(OrdemDeCompraDTO.of(entity));
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody OrdemDeCompraDTO ordemDeCompra) {
        if (ordemDeCompra == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma ordem de compra válida");
        }
        if (ordemDeCompra.getCpf() == null || ordemDeCompra.getCpf().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um CPF válido");
        }
        if (ordemDeCompra.getId() == null || ordemDeCompra.getId().isBlank()) {
            ordemDeCompra.setId(UUID.randomUUID().toString());
        }
        try {
            service.add(ordemDeCompra.toEntity());
        } catch (EntidadeDuplicadaException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe uma compra com o ID informado");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro desconhecido");
        }
        return ResponseEntity.created(URI.create("/api/ordemDeCompra/" + ordemDeCompra.getId())).build();
    }
}
