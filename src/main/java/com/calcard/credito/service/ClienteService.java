package com.calcard.credito.service;

import com.calcard.credito.model.Cliente;
import com.calcard.credito.repo.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Iterable<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    public void deleteById(Long id) {
        this.clienteRepository.deleteById(id);
    }
}
