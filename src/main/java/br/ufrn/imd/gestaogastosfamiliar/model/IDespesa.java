package br.ufrn.imd.gestaogastosfamiliar.model;

import java.util.List;
import java.util.UUID;

/**
 * Interface para operações relacionadas a despesas.
 * */
public interface IDespesa {

    /**
     * Edita o valor da despesa.
     *
     * @param despesaAlterada A despesa com suas devidas alterações.
     * @return true se o valor da despesa foi editado com sucesso, false caso contrário.
     */
    boolean editar(Despesa despesaAlterada);

    /**
     * Lista as despesas por mempro.
     *
     * @param idMembro o id do membro.
     * @return lista despesas de um membrom em específico.
     */
    List<Despesa> listarPorMembro(UUID idMembro);

    /**
     * Lista as despesas por mempro.
     *
     * @param idFamilia o id do membro.
     * @return lista despesas de um membrom em específico.
     */
    List<Despesa> listarPorFamilia(UUID idFamilia);

}

