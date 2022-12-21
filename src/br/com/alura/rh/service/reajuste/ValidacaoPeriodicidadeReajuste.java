package br.com.alura.rh.service.reajuste;

import br.com.alura.rh.exceptions.ValidacaoException;
import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.interfaces.ValidacaoReajuste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeReajuste implements ValidacaoReajuste {

    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();

        long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);

        if (mesesDesdeUltimoReajuste < 6) {
            throw new ValidacaoException("Intervalo entre reajuste deve ser de, no mínimo, 6 meses!");
        }
    }
}
