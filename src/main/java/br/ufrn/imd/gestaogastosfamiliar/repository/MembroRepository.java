package br.ufrn.imd.gestaogastosfamiliar.repository;

import br.ufrn.imd.gestaogastosfamiliar.model.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MembroRepository extends JpaRepository<Membro, UUID> {

    @Query("SELECT m FROM Membro m WHERE m.familia.id = :familiaId")
    List<Membro> findByFamiliaId(@Param("familiaId") UUID familiaId);
}
