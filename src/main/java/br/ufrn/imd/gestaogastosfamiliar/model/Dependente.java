package br.ufrn.imd.gestaogastosfamiliar.model;

import java.util.Date;
import java.util.UUID;

/**
 * Classe que representa um dependente na gestão de gastos familiar.
 */
public class Dependente extends Membro {

    /**
     * Construtor da classe Dependente.
     *
     * @param nome           O nome do dependente.
     * @param email          O email do dependente.
     * @param dataNascimento A data de nascimento do dependente.
     * @param senha          A senha do dependente.
     */
    public Dependente(String nome, String email, Date dataNascimento, String senha) {
        super(nome, email, dataNascimento, senha, Perfil.DEPENDENTE);
    }

    /**
     * Construtor vazio da classe Dependente.
     */
    public Dependente() {
    }

    /**
     * Adiciona uma despesa ao dependente.
     *
     * @param despesa A despesa a ser adicionada.
     * @return true se a despesa foi adicionada com sucesso, false caso contrário.
     */
    @Override
    public boolean adicionarDespesa(Despesa despesa) {
        return false;
    }

    /**
     * Edita uma despesa existente do dependente.
     *
     * @param despesa A despesa a ser editada.
     * @return true se a despesa foi editada com sucesso, false caso contrário.
     * @throws IllegalArgumentException Se a despesa ou o ID da despesa forem nulos.
     */
    @Override
    public boolean editarDespesa(Despesa despesa) throws IllegalArgumentException {
        return false;
    }

    /**
     * Remove uma despesa do dependente pelo seu ID.
     *
     * @param id O ID da despesa a ser removida.
     * @return true se a despesa foi removida com sucesso, false caso contrário.
     * @throws IllegalArgumentException Se o ID for nulo.
     */
    @Override
    public boolean removerDespesa(UUID id) throws IllegalArgumentException {
        return false;
    }
}
