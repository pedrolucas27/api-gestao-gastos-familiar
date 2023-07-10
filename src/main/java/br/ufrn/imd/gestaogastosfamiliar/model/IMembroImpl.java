package br.ufrn.imd.gestaogastosfamiliar.model;

import br.ufrn.imd.gestaogastosfamiliar.repository.DespesaRepository;
import br.ufrn.imd.gestaogastosfamiliar.repository.MembroRepository;
import jakarta.persistence.EntityNotFoundException;
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
    private final MembroRepository membroRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean adicionarDespesa(Despesa despesa, UUID idMembro) {
        validarCamposDespesa(despesa);

        Membro membro = membroRepository.findById(idMembro).orElseThrow(() -> new EntityNotFoundException("Não existe membro com esse ID"));

        despesa.setMembro(membro);
        despesa = despesaRepository.save(despesa);

        membro.getDespesas().add(despesa);
        membroRepository.save(membro);

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
