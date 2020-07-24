package com.calcard.credito.control;

import com.calcard.credito.model.Cliente;
import com.calcard.credito.service.ClienteService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/list")
    public Iterable<Cliente> list() {
        return clienteService.findAll();
    }

    @PostMapping("/save")
    public Cliente save(@RequestBody Cliente cliente) {
        return this.clienteService.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteService.deleteById(id);
    }
}
