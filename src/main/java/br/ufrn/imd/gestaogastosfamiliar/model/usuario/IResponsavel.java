package br.ufrn.imd.gestaogastosfamiliar.model.usuario;

public interface IResponsavel extends IUsuario{

    Boolean addUsuario(Usuario usuario);

    Boolean removerUsuario(Usuario usuario);
}
