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
     * @param idMembro O ID do membro ao qual a despesa será associada.
     * @return true se a despesa foi adicionada com sucesso, false caso contrário.
     */
    boolean adicionarDespesa(Despesa despesa, UUID idMembro);

    /**
     * Remove uma despesa do membro pelo seu ID.
     *
     * @param id O ID da despesa a ser removida.
     * @return true se a despesa foi removida com sucesso, false caso contrário.
     * @throws IllegalArgumentException Se o ID for nulo.
     */
    boolean removerDespesa(UUID id) throws IllegalArgumentException;
}
