package br.ufrn.imd.gestaogastosfamiliar.model;

import br.ufrn.imd.gestaogastosfamiliar.repository.FamiliaRepository;
import br.ufrn.imd.gestaogastosfamiliar.repository.MembroRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Implementação da interface IResponsavel que representa um responsável na gestão de gastos familiar.
 */
@Service
@AllArgsConstructor
public class IResponsavelImpl extends Membro implements IResponsavel {

    private final FamiliaRepository familiaRepository;
    private final MembroRepository membroRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean adicionarMembro(Membro membro, UUID idFamilia) {
        validarCampos(membro);

        Familia familia = familiaRepository.findById(idFamilia).orElseThrow(() -> new EntityNotFoundException("Não exite família com este ID."));

        membro.setFamilia(familia);
        membro = membroRepository.save(membro);

        familia.getMembros().add(membro);
        familiaRepository.save(familia);

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removerMembro(UUID id) throws IllegalArgumentException {
        if (Objects.isNull(id)) throw new IllegalArgumentException("Não pode ser removido, pois o ID informado está nulo.");

        membroRepository.deleteById(id);

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cadastroFamilia(String nome, Membro responsavel) {
        if (Objects.isNull(nome)) throw new IllegalArgumentException("A família fornecida não é válida");

        Familia familia = new Familia(nome, new ArrayList<>(List.of(responsavel)));
        familia = familiaRepository.save(familia);

        adicionarMembro(responsavel, familia.getId());

        return true;
    }

    @Override
    public List<Membro> listarMembros(UUID idFamilia) {
        return familiaRepository.findById(idFamilia)
                .orElseThrow(() -> new EntityNotFoundException("Não foi possível encontrar a familía."))
                .getMembros();
    }

    /**
     * Valida os campos do membro antes de adicioná-lo à família.
     *
     * @param membro O membro a ser validado.
     * @throws IllegalArgumentException Se algum campo do membro for inválido.
     */
    private void validarCampos(Membro membro) {
        if (Objects.isNull(membro.getNome()) || membro.getNome().isEmpty())
            throw new IllegalArgumentException("O nome é nulo ou vazio");
        if (Objects.isNull(membro.getEmail()) || membro.getEmail().isEmpty())
            throw new IllegalArgumentException("O email é nulo ou vazio");
        if (Objects.isNull(membro.getDataNascimento()))
            throw new IllegalArgumentException("A data de nascimento é nula");
        if (Objects.isNull(membro.getSenha()) || membro.getSenha().isEmpty())
            throw new IllegalArgumentException("A senha é nula ou vazia");
        if (Objects.isNull(membro.getPerfil()))
            throw new IllegalArgumentException("O perfil é nulo");
    }
}
