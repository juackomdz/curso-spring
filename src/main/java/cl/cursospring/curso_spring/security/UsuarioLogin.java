package cl.cursospring.curso_spring.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cl.cursospring.curso_spring.model.UsuarioModel;
import cl.cursospring.curso_spring.service.UsuarioService;

@Component
public class UsuarioLogin implements UserDetailsService{

    @Autowired
    private UsuarioService service;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UsuarioModel modelo = service.buscarUsuario(username);
        if(modelo == null){
            throw new UsernameNotFoundException("usuario "+username+" no existe");
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        return new User(modelo.getUsername(), modelo.getPass(), true, true, true, true, authorities);
    }


}
