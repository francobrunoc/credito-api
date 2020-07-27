package com.calcard.credito.control;

import com.calcard.credito.model.Credito;
import com.calcard.credito.model.CreditoViewModel;
import com.calcard.credito.service.CreditoService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/credito")
public class CreditoController {

    private final CreditoService creditoService;

    public CreditoController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @PostMapping("/consult")
    public Credito consult(@RequestBody CreditoViewModel model) {
        return this.creditoService.consult(model.getCpf());
    }
}
