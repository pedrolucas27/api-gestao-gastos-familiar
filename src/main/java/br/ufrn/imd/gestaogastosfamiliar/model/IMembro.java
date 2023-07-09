package br.ufrn.imd.gestaogastosfamiliar.model;

import java.util.UUID;

/**
 * Interface para operações relacionadas a despesas de um membro.
 */
public interface IMembro {

    /**
     * Adiciona uma despesa ao membro.
     *
     * @param despesa A despesa a ser adicionada.
     * @return true se a despesa foi adicionada com sucesso, false caso contrário.
     */
    boolean adicionarDespesa(Despesa despesa);

    /**
     * Edita uma despesa existente do membro.
     *
     * @param despesa A despesa a ser editada.
     * @return true se a despesa foi editada com sucesso, false caso contrário.
     * @throws IllegalArgumentException Se a despesa ou o ID da despesa forem nulos.
     */
    boolean editarDespesa(Despesa despesa) throws IllegalArgumentException;

    /**
     * Remove uma despesa do membro pelo seu ID.
     *
     * @param id O ID da despesa a ser removida.
     * @return true se a despesa foi removida com sucesso, false caso contrário.
     * @throws IllegalArgumentException Se o ID for nulo.
     */
    boolean removerDespesa(UUID id) throws IllegalArgumentException;
}
