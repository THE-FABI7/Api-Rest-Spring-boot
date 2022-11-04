package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.usuarioModel;

@Repository
public interface usuarioRepository extends CrudRepository<usuarioModel, Long> {

   /**
    * Devuelve una ArrayList de objetos de modelo de usuario.
    * 
    * @param prioridad El valor del campo a buscar.
    * @return ArrayList<usuarioModel>
    */
    public abstract ArrayList<usuarioModel> findByPrioridad(Integer prioridad);

    
}
