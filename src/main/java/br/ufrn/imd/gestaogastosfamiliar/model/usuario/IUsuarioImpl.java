package br.ufrn.imd.gestaogastosfamiliar.model.usuario;

import br.ufrn.imd.gestaogastosfamiliar.model.despesa.Despesa;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class IUsuarioImpl implements IUsuario{

    private final EntityManager entityManager;

    public IUsuarioImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Boolean addDespesa(Despesa despesa) {
        if(Objects.isNull(despesa)) throw new NullPointerException("A despesa está vazia!");

        if(Objects.isNull(despesa.getUsuario())) throw new IllegalArgumentException("Não foi registrado usuário para esta conta.");

        entityManager.persist(despesa);

        return Boolean.TRUE;
    }

    @Override
    public Boolean editDespesa(Despesa despesa) {
        return null;
    }

    @Override
    public Boolean removerDespesa(Despesa despesa) {
        return null;
    }
}
