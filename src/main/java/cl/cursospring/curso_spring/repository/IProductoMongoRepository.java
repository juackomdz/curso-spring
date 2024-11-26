package cl.cursospring.curso_spring.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import cl.cursospring.curso_spring.model.ProductoMongoModel;

public interface IProductoMongoRepository extends MongoRepository<ProductoMongoModel, String>{

    public void deleteByNombre(String nombre);
    public Optional<ProductoMongoModel> findByNombre(String nombre);
}
