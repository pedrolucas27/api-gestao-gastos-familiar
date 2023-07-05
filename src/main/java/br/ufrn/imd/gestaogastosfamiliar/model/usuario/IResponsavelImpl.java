package br.ufrn.imd.gestaogastosfamiliar.model.usuario;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class IResponsavelImpl extends IUsuarioImpl implements IResponsavel {

    private final EntityManager entityManager;

    public IResponsavelImpl(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Boolean addUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public Boolean removerUsuario(Usuario usuario) {
        return null;
    }
}
