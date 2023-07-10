package br.ufrn.imd.gestaogastosfamiliar.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "despesa")
public class Despesa implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "data_vencimento", nullable = false)
    private Date dataVencimento;

    @Column(name = "visibilidade", nullable = false)
    private Visibilidade visibilidade;

    @ManyToOne
    @JoinColumn(name = "id_membro", nullable = false)
    private Membro membro;

    public Despesa(String descricao, Double valor, Date dataVencimento, Visibilidade visibilidade) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.visibilidade = visibilidade;
    }

    public Despesa(){
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Visibilidade getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(Visibilidade visibilidade) {
        this.visibilidade = visibilidade;
    }

    public Membro getMembro() { return membro; }

    public void setMembro(Membro membro) { this.membro = membro; }
}
