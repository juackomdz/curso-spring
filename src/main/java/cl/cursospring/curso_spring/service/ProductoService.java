package cl.cursospring.curso_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.cursospring.curso_spring.model.ProductosModel;
import cl.cursospring.curso_spring.repository.IProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private IProductoRepository repository;

    public List<ProductosModel> listarProductos(){
        return this.repository.findAll();
    }
}
