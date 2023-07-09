package br.ufrn.imd.gestaogastosfamiliar.model;

public enum Visibilidade {

    PUBLICO("Público"),
    PRIVADO("Privado");

    private String descricao;

    Visibilidade(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
