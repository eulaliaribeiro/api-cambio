package com.ada.deva.ordemdecompra;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemDeCompraRepository extends PagingAndSortingRepository<OrdemDeCompra, String> {
}
