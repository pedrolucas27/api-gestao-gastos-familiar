package br.ufrn.imd.gestaogastosfamiliar.model.usuario;

public enum Perfil {
    RESPONSAVEL("Responsável"),
    DEPENDENTE("Dependente");

    private String descricao;

    Perfil(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
