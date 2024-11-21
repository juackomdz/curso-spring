package cl.cursospring.curso_spring.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import cl.cursospring.curso_spring.model.CategoriaMongoModel;


public interface ICategoriaMongoRepository extends MongoRepository<CategoriaMongoModel, String> {

    public Optional<CategoriaMongoModel> findByNombre(String nombre);
    public void deleteByNombre(String nombre);
}
