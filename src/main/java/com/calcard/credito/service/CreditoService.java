package com.calcard.credito.service;

import com.calcard.credito.model.Cliente;
import com.calcard.credito.model.Credito;
import com.calcard.credito.model.EstadoCivil;
import com.calcard.credito.repo.CreditoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditoService {

    private final CreditoRepository creditoRepository;

    public CreditoService(CreditoRepository creditoRepository) {
        this.creditoRepository = creditoRepository;
    }

    public Credito consult(String cpf) {
        return creditoRepository.findByCliente_Cpf(cpf);
    }

    public void evaluate(Cliente cliente) {
        double faixaRisco;

        if (cliente.getRenda() >= 8000) faixaRisco = 1;
        else if (cliente.getRenda() >= 5000 && cliente.getRenda() < 8000) faixaRisco = 2;
        else if (cliente.getRenda() < 5000 && cliente.getRenda() >= 3000) faixaRisco = 3;
        else if (cliente.getRenda() < 3000 && cliente.getRenda() > 1000) faixaRisco = 4;
        else faixaRisco = 5;

        // Aplica peso para faixa de idade de risco
        if (cliente.getIdade() <= 20 || cliente.getIdade() >= 80) faixaRisco *= 1.5;

        boolean aprovado = false;
        String motivo = "";
        double limiteMaximo = Math.round(cliente.getRenda() / faixaRisco);

        // Aplica peso para quantidade de dependentes
        if (cliente.getDependentes() >= 1) limiteMaximo /= (cliente.getDependentes() + 0.5);
        // Aplica peso para homem divorciado
        if (cliente.getEstadoCivil() == EstadoCivil.DIVORCIADO && cliente.getSexo() == "M") limiteMaximo /= 1.3;

        double limiteMinimo = Math.round(100 + (limiteMaximo - 500));

        if (faixaRisco > 4 && faixaRisco < 5) {
            limiteMaximo = 0;
            limiteMinimo = 0;
            motivo = "Reprovado pela política de crédito";
        } else if (faixaRisco >= 5) {
            limiteMaximo = 0;
            limiteMinimo = 0;
            motivo = "Renda baixa";
        } else if (faixaRisco <= 4 && faixaRisco > 1) {
            aprovado = true;
            motivo = "Entre " + limiteMinimo + " - " + limiteMaximo;
        } else if (faixaRisco == 1) {
            aprovado = true;
            motivo = "Superior a " + limiteMinimo;
        }
        creditoRepository.save(new Credito(cliente, limiteMaximo, limiteMinimo, motivo, aprovado));
    }

    @Transactional
    public void deleteByClienteId(Long id) {
        this.creditoRepository.deleteByCliente_Id(id);
    }
}
