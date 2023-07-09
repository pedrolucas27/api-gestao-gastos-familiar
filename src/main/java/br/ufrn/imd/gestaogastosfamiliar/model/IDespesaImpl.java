package br.ufrn.imd.gestaogastosfamiliar.model;

import java.util.Date;

/**
 * Implementação da interface {IDespesa} que representa a edição de despesas.
 */
public class IDespesaImpl implements IDespesa {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean editarValor(float novoValor) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean editarVisibilidade(Visibilidade visibilidade) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean editarVencimento(Date novaDataVencimento) {
        return false;
    }
}
