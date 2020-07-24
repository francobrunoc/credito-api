package com.calcard.credito.service;

import com.calcard.credito.model.Cliente;
import com.calcard.credito.model.Credito;
import com.calcard.credito.repo.CreditoRepository;
import org.springframework.stereotype.Service;

@Service
public class CreditoService {

    private final CreditoRepository creditoRepository;

    public CreditoService(CreditoRepository creditoRepository) {
        this.creditoRepository = creditoRepository;
    }

    public Credito enquiry(String cpf) {
        return creditoRepository.findByCliente_Cpf(cpf);
    }

    public void evaluate(Cliente cliente) {

    }
}
