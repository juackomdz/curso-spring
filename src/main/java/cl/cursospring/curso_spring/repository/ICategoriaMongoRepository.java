package cl.cursospring.curso_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cl.cursospring.curso_spring.model.CategoriaMongoModel;

public interface ICategoriaMongoRepository extends MongoRepository<CategoriaMongoModel, String> {

}
