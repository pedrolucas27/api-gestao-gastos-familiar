package br.ufrn.imd.gestaogastosfamiliar.repository;

import br.ufrn.imd.gestaogastosfamiliar.model.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface MembroRepository extends JpaRepository<Membro, UUID> {
    Membro findByEmail(String email);
}