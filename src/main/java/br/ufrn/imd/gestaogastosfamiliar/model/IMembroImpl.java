package br.ufrn.imd.gestaogastosfamiliar.model;

import br.ufrn.imd.gestaogastosfamiliar.repository.DespesaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementação da interface IMembro.
 */
@Service
@AllArgsConstructor
public class IMembroImpl implements IMembro {

    private final DespesaRepository despesaRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean adicionarDespesa(Despesa despesa) {
        validarCamposDespesa(despesa);
        despesaRepository.save(despesa);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean editarDespesa(Despesa despesa) throws IllegalArgumentException {
        validarCamposDespesa(despesa);
        if (Objects.isNull(despesa.getId())) throw new IllegalArgumentException("Não pode ser editada, pois o ID informado está nulo.");
        despesaRepository.save(despesa);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removerDespesa(UUID id) throws IllegalArgumentException {
        if (Objects.isNull(id)) throw new IllegalArgumentException("Id nulo, despesa não pode ser removida!");
        despesaRepository.deleteById(id);
        return true;
    }

    /**
     * Valida os campos da despesa antes de adicioná-la.
     *
     * @param despesa A despesa a ser validada.
     * @throws IllegalArgumentException Se algum campo da despesa for inválido.
     */
    private void validarCamposDespesa(Despesa despesa) {
        if (Objects.isNull(despesa)) throw new IllegalArgumentException("A despesa é nula");
        if (Objects.isNull(despesa.getDescricao())) throw new IllegalArgumentException("A descrição da despesa é nula");
        if (Objects.isNull(despesa.getValor())) throw new IllegalArgumentException("O valor da despesa é nulo");
        if (Objects.isNull(despesa.getVisibilidade())) throw new IllegalArgumentException("A visibilidade da despesa é nula");
        if (Objects.isNull(despesa.getDataVencimento())) throw new IllegalArgumentException("A data de vencimento da despesa é nula");
    }
}
