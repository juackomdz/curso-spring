package cl.cursospring.curso_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.cursospring.curso_spring.model.CategoriaMongoModel;
import cl.cursospring.curso_spring.repository.ICategoriaMongoRepository;

@Service
public class CategoriaMongoService {

    @Autowired
    private ICategoriaMongoRepository categoriaMongoRepository;

    public List<CategoriaMongoModel> listar() {
        return categoriaMongoRepository.findAll();
    }

    public void guardar(CategoriaMongoModel categoria){
        categoriaMongoRepository.save(categoria);
    }

    public CategoriaMongoModel buscarPorNombre(String nombre){
        Optional<CategoriaMongoModel> opt = categoriaMongoRepository.findByNombre(nombre);
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    public void eliminar(String nombre){
        categoriaMongoRepository.deleteByNombre(nombre);
    }
}
