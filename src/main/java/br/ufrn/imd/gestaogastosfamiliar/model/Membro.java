package br.ufrn.imd.gestaogastosfamiliar.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Classe abstrata que representa um membro genérico.
 */
@Entity
@Table(name = "membro")
public abstract class Membro implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    protected UUID id;

    @Column(name = "nome", nullable = false)
    protected String nome;

    @Column(name = "email", nullable = false)
    protected String email;

    @Column(name = "data_nascimento", nullable = false)
    protected Date dataNascimento;

    @Column(name = "senha", nullable = false)
    protected String senha;

    @Column(name = "perfil", nullable = false)
    @Enumerated(EnumType.STRING)
    protected Perfil perfil;

    @OneToMany
    @JoinColumn(name = "id_membro")
    protected List<Despesa> despesas;

    /**
     * Construtor da classe Membro.
     *
     * @param nome           O nome do membro.
     * @param email          O email do membro.
     * @param dataNascimento A data de nascimento do membro.
     * @param senha          A senha do membro.
     * @param perfil         O perfil do membro.
     */
    public Membro(String nome, String email, Date dataNascimento, String senha, Perfil perfil) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        this.perfil = perfil;
    }

    /**
     * Construtor vazio da classe Membro.
     */
    public Membro() {
    }

    /**
     * Adiciona uma despesa ao membro.
     *
     * @param despesa A despesa a ser adicionada.
     * @return true se a despesa foi adicionada com sucesso, false caso contrário.
     */
    abstract boolean adicionarDespesa(Despesa despesa);

    /**
     * Edita uma despesa existente do membro.
     *
     * @param despesa A despesa a ser editada.
     * @return true se a despesa foi editada com sucesso, false caso contrário.
     * @throws IllegalArgumentException Se a despesa ou o ID da despesa forem nulos.
     */
    abstract boolean editarDespesa(Despesa despesa) throws IllegalArgumentException;

    /**
     * Remove uma despesa do membro pelo seu ID.
     *
     * @param id O ID da despesa a ser removida.
     * @return true se a despesa foi removida com sucesso, false caso contrário.
     * @throws IllegalArgumentException Se o ID for nulo.
     */
    abstract boolean removerDespesa(UUID id) throws IllegalArgumentException;

    // Getters e setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    public void addDespesa(Despesa despesa) {
        this.despesas.add(despesa);
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
