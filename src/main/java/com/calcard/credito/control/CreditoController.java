package com.calcard.credito.control;

import com.calcard.credito.model.Credito;
import com.calcard.credito.service.CreditoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/credito")
public class CreditoController {

    private final CreditoService creditoService;

    public CreditoController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @GetMapping("/enquiry")
    public Credito consult(String cpf) {
        return this.creditoService.enquiry(cpf);
    }
}
