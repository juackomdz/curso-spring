package cl.cursospring.curso_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.cursospring.curso_spring.model.UsuarioModel;


@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Integer>{

    public UsuarioModel findByUsername(String username);
}
