package com.ada.deva.ordemdecompra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public ResponseEntity<Void> add(@RequestBody OrdemDeCompraDTO mesa) {
        if (OrdemDeCompra == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma ordem de compra válida");
        }
        if (OrdemDeCompra == null || mesa.getSala().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma mesa com uma sala válida");
        }
        if (mesa.getCapacidade() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma mesa com uma capacidade válida");
        }
        if (mesa.getId() == null || mesa.getId().isBlank()) {
            mesa.setId(UUID.randomUUID().toString());
        }
        try {
            service.add(mesa.toEntity());
        } catch (EntidadeDuplicadaException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe uma mesa com o ID informado");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro desconhecido");
        }
        return ResponseEntity.created(URI.create("/api/mesa/" + mesa.getId())).build();
    }
}
