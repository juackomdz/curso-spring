package cl.cursospring.curso_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.cursospring.curso_spring.model.CategoriaModel;

public interface ICategoriaRepository extends JpaRepository<CategoriaModel, Integer>{

    
}
