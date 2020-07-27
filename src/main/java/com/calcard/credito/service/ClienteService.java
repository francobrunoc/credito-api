package com.calcard.credito.service;

import com.calcard.credito.model.Cliente;
import com.calcard.credito.repo.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    @Autowired
    private CreditoService creditoService;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Iterable<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente) {
        this.clienteRepository.save(cliente);
        this.creditoService.evaluate(cliente);
        return cliente;
    }

    public void deleteById(Long id) {
        this.creditoService.deleteByClienteId(id);
        this.clienteRepository.deleteById(id);
    }
}
