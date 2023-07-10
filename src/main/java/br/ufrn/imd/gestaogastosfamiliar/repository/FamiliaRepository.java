package br.ufrn.imd.gestaogastosfamiliar.repository;

import br.ufrn.imd.gestaogastosfamiliar.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, UUID> {
}

