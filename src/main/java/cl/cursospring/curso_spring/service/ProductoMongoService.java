package cl.cursospring.curso_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.cursospring.curso_spring.model.ProductoMongoModel;
import cl.cursospring.curso_spring.repository.IProductoMongoRepository;

@Service
public class ProductoMongoService {

    @Autowired
    private IProductoMongoRepository repository;

    public List<ProductoMongoModel> listar(){
        return repository.findAll();
    }
}
