package cl.cursospring.curso_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.cursospring.curso_spring.model.UsuarioModel;
import cl.cursospring.curso_spring.repository.IUsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository repositorio;

    public UsuarioModel buscarUsuario(String user) {
        return repositorio.findByUsername(user);
    }

    public void guardar(UsuarioModel usuario){
        repositorio.save(usuario);
    }
}
