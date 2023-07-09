package br.ufrn.imd.gestaogastosfamiliar.model;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Interface para operações relacionadas a despesas.
 */
@Service
public interface IDespesa {

    /**
     * Edita o valor da despesa.
     *
     * @param novoValor O novo valor da despesa.
     * @return true se o valor da despesa foi editado com sucesso, false caso contrário.
     */
    boolean editarValor(float novoValor);

    /**
     * Edita a visibilidade da despesa.
     *
     * @param visibilidade A nova visibilidade da despesa.
     * @return true se a visibilidade da despesa foi editada com sucesso, false caso contrário.
     */
    boolean editarVisibilidade(Visibilidade visibilidade);

    /**
     * Edita a data de vencimento da despesa.
     *
     * @param novaDataVencimento A nova data de vencimento da despesa.
     * @return true se a data de vencimento da despesa foi editada com sucesso, false caso contrário.
     */
    boolean editarVencimento(Date novaDataVencimento);
}
