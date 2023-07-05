package br.ufrn.imd.gestaogastosfamiliar.model.usuario;

import br.ufrn.imd.gestaogastosfamiliar.model.despesa.Despesa;

public interface IUsuario {

    Boolean addDespesa(Despesa despesa);
    Boolean editDespesa(Despesa despesa);
    Boolean removerDespesa(Despesa despesa);

}
