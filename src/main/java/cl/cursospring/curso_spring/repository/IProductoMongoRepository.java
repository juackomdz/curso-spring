package cl.cursospring.curso_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cl.cursospring.curso_spring.model.ProductoMongoModel;

public interface IProductoMongoRepository extends MongoRepository<ProductoMongoModel, String>{

}
