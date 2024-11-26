package cl.cursospring.curso_spring.service;

import java.util.List;
import java.util.Optional;

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

    public void guardar(ProductoMongoModel producto){
        repository.save(producto);
    }

    public void eliminar(String nombre){
        repository.deleteByNombre(nombre);
    }

    public ProductoMongoModel buscarPorNombre(String nombre){
        Optional<ProductoMongoModel> opt = repository.findByNombre(nombre);
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }
}
