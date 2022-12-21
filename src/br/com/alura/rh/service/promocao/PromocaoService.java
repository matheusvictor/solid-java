package br.com.alura.rh.service.promocao;

import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

import br.com.alura.rh.exceptions.ValidacaoException;

public class PromocaoService {

    public void promover(Funcionario funcionario, boolean metaAtingida) {
        Cargo cargoAtual = funcionario.getCargo();

        if (cargoAtual.equals(Cargo.GERENTE)) {
            throw new ValidacaoException("Gerentes não podem ser promovidos!");
        }

        if (metaAtingida) {
            Cargo novoCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novoCargo);
        } else {
            throw new ValidacaoException("Funcionário não bateu a meta!");
        }
    }
}
