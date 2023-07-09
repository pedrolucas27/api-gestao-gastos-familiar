package br.ufrn.imd.gestaogastosfamiliar.auth;

import br.ufrn.imd.gestaogastosfamiliar.model.Membro;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@RequiredArgsConstructor
@Data
public class MembroDetailsData implements UserDetails {
    private final Membro membro;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        if(Objects.nonNull(membro))
            return membro.getSenha();
        return "";
    }

    @Override
    public String getUsername() {
        return membro.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
