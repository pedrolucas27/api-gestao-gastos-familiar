package br.ufrn.imd.gestaogastosfamiliar.repository;

import br.ufrn.imd.gestaogastosfamiliar.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, UUID> {

    @Query("select d from Despesa d where d.membro.id = ?1")
    List<Despesa> listarPorMembro(UUID id);

    @Query("select d from Despesa d where d.membro.familia.id = ?1")
    List<Despesa> listarPorFamilia(UUID id);



}
