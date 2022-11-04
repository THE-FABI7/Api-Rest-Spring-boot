package com.example.demo.servicies;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.usuarioModel;
import com.example.demo.repositories.usuarioRepository;

@Service
public class usuarioServicie {

    @Autowired
    usuarioRepository usuarioRepository;

    /**
     * Devuelve todos los usuarios de la base de datos.
     * 
     * @return Una ArrayList de objetos de modelo de usuario.
     */
    public ArrayList<usuarioModel> obtenerUsuarios() {
        return (ArrayList<usuarioModel>) usuarioRepository.findAll();
    }

    /**
     * Guarda al usuario en la base de datos.
     * 
     * @param usuario El objeto que desea guardar.
     * @return El método está devolviendo el objeto usuarioModel.
     */
    public usuarioModel guardarusuario(usuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Devuelve al usuario con el id que se le pasa como parámetro.
     * 
     * @param id El id del usuario que se va a eliminar.
     * @return Opcional<modelousuario>
     */
    public Optional<usuarioModel> optenerporId(long id) {
        return usuarioRepository.findById(id);
    }

 /**
  * Devuelve una lista de usuarios con una prioridad determinada.
  * 
  * @param prioridad La prioridad del usuario.
  */
    public ArrayList<usuarioModel> obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);

    }

   /**
    * Elimina un usuario de la base de datos.
    * 
    * @param id El id del usuario que se va a eliminar.
    * @return Un valor booleano.
    */
    public boolean eliminarUsuario(long id) {

        try {
            usuarioRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

}
