package br.ufrn.imd.gestaogastosfamiliar.model;

/**
 * Interface para operações relacionadas a despesas.
 */
public interface IDespesa {

    /**
     * Edita o valor da despesa.
     *
     * @param despesaAlterada A despesa com suas devidas alterações.
     * @return true se o valor da despesa foi editado com sucesso, false caso contrário.
     */
    boolean editar(Despesa despesaAlterada);
}
