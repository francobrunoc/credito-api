package com.calcard.credito.repo;

import com.calcard.credito.model.Credito;
import org.springframework.data.repository.CrudRepository;

public interface CreditoRepository extends CrudRepository<Credito, Long> {
    Credito findByCliente_Cpf(String cpf);
    void deleteByCliente_Id(Long id);
}
