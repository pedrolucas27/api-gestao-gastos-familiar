package br.ufrn.imd.gestaogastosfamiliar.model;

import br.ufrn.imd.gestaogastosfamiliar.repository.DespesaRepository;
import br.ufrn.imd.gestaogastosfamiliar.repository.FamiliaRepository;
import br.ufrn.imd.gestaogastosfamiliar.repository.MembroRepository;
import lombok.AllArgsConstructor;

import java.util.Objects;
import java.util.UUID;

/**
 * Classe que representa um responsável na gestão de gastos familiar.
 */

@AllArgsConstructor
public class Responsavel extends Membro implements IResponsavel {

    private final FamiliaRepository repository;
    private final MembroRepository membroRepository;
    private final DespesaRepository despesaRepository;

    /**
     * Adiciona um membro à família.
     *
     * @param membro  O membro a ser adicionado.
     * @param familia A família à qual o membro será adicionado.
     * @return true se o membro foi adicionado com sucesso, false caso contrário.
     */
    @Override
    public boolean adicionarMembro(Membro membro, Familia familia) {
        validarCampos(membro);
        validarFamilia(familia);

        familia.getMembros().add(membro);
        repository.save(familia);

        return true;
    }

    /**
     * Remove um membro da família pelo seu ID.
     *
     * @param id O ID do membro a ser removido.
     * @return true se o membro foi removido com sucesso, false caso contrário.
     */
    @Override
    public boolean removerMembro(UUID id) {
        if(Objects.isNull(id)) throw new IllegalArgumentException("Não pode ser removido, pois o ID informado está nulo.");

        membroRepository.deleteById(id);

        return true;
    }

    /**
     * Adiciona uma despesa ao responsável.
     *
     * @param despesa A despesa a ser adicionada.
     * @return true se a despesa foi adicionada com sucesso, false caso contrário.
     */
    @Override
    public boolean adicionarDespesa(Despesa despesa) {
        validarCamposDespesa(despesa);

        despesaRepository.save(despesa);

        return true;
    }

    /**
     * Edita uma despesa existente do responsável.
     *
     * @param despesa A despesa a ser editada.
     * @return true se a despesa foi editada com sucesso, false caso contrário.
     * @throws IllegalArgumentException Se a despesa ou o ID da despesa forem nulos.
     */
    @Override
    public boolean editarDespesa(Despesa despesa) throws IllegalArgumentException {
        validarCamposDespesa(despesa);
        
        if(Objects.isNull(despesa.getId())) throw new IllegalArgumentException("Não pode ser editada, pois o ID informado está nulo.");
        
        return true;
    }

    /**
     * Remove uma despesa do responsável pelo seu ID.
     *
     * @param id O ID da despesa a ser removida.
     * @return true se a despesa foi removida com sucesso, false caso contrário.
     * @throws IllegalArgumentException Se o ID for nulo.
     */
    @Override
    public boolean removerDespesa(UUID id) throws IllegalArgumentException {
        if(Objects.isNull(id)) throw new IllegalArgumentException("Id nulo, despesa não pode ser removida!");

        repository.deleteById(id);

        return true;
    }

    private void validarCamposDespesa(Despesa despesa) {
        if (Objects.isNull(despesa)) throw new IllegalArgumentException("A despesa é nula");
        if (Objects.isNull(despesa.getDescricao())) throw new IllegalArgumentException("A descrição da despesa é nula");
        if (Objects.isNull(despesa.getValor())) throw new IllegalArgumentException("O valor da despesa é nulo");
        if (Objects.isNull(despesa.getVisibilidade())) throw new IllegalArgumentException("A visibilidade da despesa é nula");
        if (Objects.isNull(despesa.getDataVencimento())) throw new IllegalArgumentException("A data de vencimento da despesa é nula");
    }

    private void validarFamilia(Familia familia) {
        if (Objects.nonNull(familia.getId())) {
            if (!repository.existsById(familia.getId())) {
                throw new IllegalArgumentException("A família fornecida não é válida");
            }
        } else {
            if (Objects.isNull(familia.getSobrenome())) {
                throw new IllegalArgumentException("A família fornecida não é válida");
            }
        }
    }

    public void validarCampos(Membro membro) {
        if (Objects.isNull(membro.getNome()) || membro.getNome().isEmpty()) throw new IllegalArgumentException("O nome é nulo ou vazio");
        if (Objects.isNull(membro.getEmail()) || membro.getEmail().isEmpty()) throw new IllegalArgumentException("O email é nulo ou vazio");
        if (Objects.isNull(membro.getDataNascimento())) throw new IllegalArgumentException("A data de nascimento é nula");
        if (Objects.isNull(membro.getSenha()) || membro.getSenha().isEmpty()) throw new IllegalArgumentException("A senha é nula ou vazia");
        if (Objects.isNull(membro.getPerfil())) throw new IllegalArgumentException("O perfil é nulo");
    }



}
