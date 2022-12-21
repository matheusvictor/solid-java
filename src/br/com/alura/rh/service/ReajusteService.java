package br.com.alura.rh.service;

import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.interfaces.ValidacaoReajuste;

import java.util.List;
import java.math.BigDecimal;

public class ReajusteService {

    private List<ValidacaoReajuste> validacoes;

    public ReajusteService(List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalarioFuncionario(Funcionario funcionario, BigDecimal aumento) {

        this.validacoes.forEach(validacao -> validacao.validar(funcionario, aumento));

        BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
        funcionario.atualizarSalario(salarioReajustado);
    }
}
