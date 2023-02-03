package com.ada.deva.ordemdecompra;

import com.ada.deva.comum.EntidadeDuplicadaException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrdemDeCompraService {
    private final CrudRepository<OrdemDeCompra, String> repository;

    public Optional<OrdemDeCompra> getById(String id){
        return repository.findById(id);
    }

    public void add(OrdemDeCompra entity) throws EntidadeDuplicadaException{
        if(repository.existsById(entity.getId())){
            throw new EntidadeDuplicadaException();
        }
        repository.save(entity);
    }
}
