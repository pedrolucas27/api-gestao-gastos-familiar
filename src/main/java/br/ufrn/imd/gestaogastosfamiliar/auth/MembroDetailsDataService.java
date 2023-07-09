package br.ufrn.imd.gestaogastosfamiliar.auth;

import br.ufrn.imd.gestaogastosfamiliar.model.Membro;
import br.ufrn.imd.gestaogastosfamiliar.repository.MembroRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class MembroDetailsDataService implements UserDetailsService {

    private final MembroRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Membro membro;

        try {
            membro = repository.findByEmail(email);
        } catch (Exception exception){
            throw new UsernameNotFoundException(exception.getMessage());
        }
        return new MembroDetailsData(membro);
    }
}