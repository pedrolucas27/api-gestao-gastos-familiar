package br.ufrn.imd.gestaogastosfamiliar.model;

import br.ufrn.imd.gestaogastosfamiliar.repository.DespesaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Implementação da interface IDespesa que permite a edição e listagem de despesas.
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


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Despesa> listarPorMembro(UUID idMembro) {
        if (Objects.isNull(idMembro)) throw new IllegalArgumentException("Id nulo, despesa não pode ser removida!");
        return despesaRepository.listarPorMembro(idMembro);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Despesa> listarPorFamilia(UUID idFamilia) {
        if (Objects.isNull(idFamilia)) throw new IllegalArgumentException("Id nulo, despesa não pode ser removida!");
        return despesaRepository.listarPorMembro(idFamilia);
    }
}

