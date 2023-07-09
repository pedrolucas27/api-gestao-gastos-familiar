package br.ufrn.imd.gestaogastosfamiliar.model;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Interface para operações relacionadas a responsáveis de família.
 */
@Service
public interface IResponsavel {

    /**
     * Adiciona um membro à família. Caso a família não exista, ela será criada e inserida.
     *
     * @param membro   O membro a ser adicionado.
     * @param idFamilia O ID da família à qual o membro será adicionado.
     * @return true se o membro foi adicionado com sucesso à família, false caso contrário.
     */
    boolean adicionarMembro(Membro membro, UUID idFamilia);

    /**
     * Remove um membro da família pelo seu ID.
     *
     * @param id O ID do membro a ser removido.
     * @return true se o membro foi removido com sucesso da família, false caso contrário.
     * @throws IllegalArgumentException Se o ID for nulo.
     */
    boolean removerMembro(UUID id) throws IllegalArgumentException;

    /**
     * Realiza o cadastro de uma nova família.
     *
     * @param sobrenome      O nome da família.
     * @param responsavel O membro responsável pela família.
     * @return true se o cadastro da família foi realizado com sucesso, false caso contrário.
     */
    boolean cadastroFamilia(String sobrenome, Membro responsavel);


    List<Membro> listarMembros(UUID idFamilia);
}
