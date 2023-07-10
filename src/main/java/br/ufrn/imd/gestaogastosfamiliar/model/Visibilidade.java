package br.ufrn.imd.gestaogastosfamiliar.model;

/**
 * Enumeração que representa as opções de visibilidade para uma despesa.
 */
public enum Visibilidade {

    PUBLICO("Público"),
    PRIVADO("Privado");

    private String descricao;

    /**
     * Construtor do enum Visibilidade.
     *
     * @param descricao A descrição da visibilidade.
     */
    Visibilidade(String descricao){
        this.descricao = descricao;
    }

    /**
     * Obtém a descrição da visibilidade.
     *
     * @return A descrição da visibilidade.
     */
    public String getDescricao(){
        return descricao;
    }
}
