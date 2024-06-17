package cl.cursospring.curso_spring.service;

import java.util.List;

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
}
