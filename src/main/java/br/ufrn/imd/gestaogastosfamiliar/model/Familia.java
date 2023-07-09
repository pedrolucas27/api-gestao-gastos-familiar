package br.ufrn.imd.gestaogastosfamiliar.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "familia")
public class Familia implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String sobrenome;

    @OneToMany
    @JoinColumn(name = "id_familia")
    private List<Membro> membros;


    public Familia(String sobrenome, List<Membro> responsaveis) {
        this.sobrenome = sobrenome;
        this.membros = responsaveis;
    }

    public Familia() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public List<Membro> getMembros() {
        return membros;
    }

    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }
}
