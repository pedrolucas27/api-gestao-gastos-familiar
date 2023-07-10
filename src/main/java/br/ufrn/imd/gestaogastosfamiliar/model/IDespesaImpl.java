package br.ufrn.imd.gestaogastosfamiliar.model;

import br.ufrn.imd.gestaogastosfamiliar.repository.DespesaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Implementação da interface Despesa que representa a edição de despesas.
 */

@Service
@AllArgsConstructor
public class IDespesaImpl implements IDespesa {

    private final DespesaRepository despesaRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean editar(Despesa despesaAlterada) {
        Despesa despesaDb = despesaRepository
                .findById(despesaAlterada
                        .getId())
                .orElseThrow(() -> new EntityNotFoundException("Não existe despesa com este id no banco"));

        if(Objects.nonNull(despesaAlterada.getDescricao())){
            despesaDb.setDescricao(despesaAlterada.getDescricao());
        }

        if(Objects.nonNull(despesaAlterada.getDataVencimento())){
            despesaDb.setDataVencimento(despesaAlterada.getDataVencimento());
        }

        if (Objects.nonNull(despesaAlterada.getVisibilidade())) {
            despesaDb.setVisibilidade(despesaAlterada.getVisibilidade());
        }

        if (Objects.nonNull(despesaAlterada.getValor())) {
            despesaDb.setValor(despesaAlterada.getValor());
        }

        despesaRepository.save(despesaDb);
        return true;
    }
}