package br.ufrn.imd.gestaogastosfamiliar.repository;

import br.ufrn.imd.gestaogastosfamiliar.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, UUID> {
}
