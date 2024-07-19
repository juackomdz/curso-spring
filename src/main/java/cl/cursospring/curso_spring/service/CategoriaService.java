package cl.cursospring.curso_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.cursospring.curso_spring.model.CategoriaModel;
import cl.cursospring.curso_spring.repository.ICategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private ICategoriaRepository repository;

    public List<CategoriaModel> listar(){

        return this.repository.findAll();
    }

    public void guardar(CategoriaModel categoria){
        this.repository.save(categoria);
    }

    public CategoriaModel buscarId(Integer id){
        Optional<CategoriaModel> opt = this.repository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }
        return null;
    }

    public void eliminar(Integer id){
        this.repository.deleteById(id);
    }
}
