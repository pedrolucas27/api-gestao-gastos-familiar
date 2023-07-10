package br.ufrn.imd.gestaogastosfamiliar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Classe que representa um membro genérico.
 */
@Entity
@Table(name = "membro")
public class Membro implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "perfil", nullable = false)
    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @OneToMany(mappedBy = "membro", cascade = CascadeType.ALL)
    private List<Despesa> despesas;

    @ManyToOne
    @JoinColumn(name = "id_familia")
    @JsonIgnore
    private Familia familia;

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

    public Perfil getPerfil() {
        return perfil;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }


}
