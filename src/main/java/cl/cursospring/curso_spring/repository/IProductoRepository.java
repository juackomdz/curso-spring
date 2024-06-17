package cl.cursospring.curso_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.cursospring.curso_spring.model.ProductosModel;

public interface IProductoRepository extends JpaRepository<ProductosModel, Integer>{

}
