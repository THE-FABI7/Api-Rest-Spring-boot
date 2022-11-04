package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.usuarioModel;
import com.example.demo.servicies.usuarioServicie;

@RestController
@RequestMapping("/usuario")
public class usuarioController {

    @Autowired
    usuarioServicie usuarioServicie;

    /**
     * Devuelve una lista de usuarios.
     * 
     * @return Una ArrayList de objetos de modelo de usuario.
     */
    @GetMapping()
    public ArrayList<usuarioModel> obtenerUsuarios() {

        return usuarioServicie.obtenerUsuarios();
    }

    /**
     * Guarda al usuario en la base de datos.
     * 
     * @param usuario El objeto que se enviará al servidor.
     * @return El método está devolviendo al usuario que se guardó.
     */
    @PostMapping()
    public usuarioModel guardarUsuario(@RequestBody usuarioModel usuario) {
        return this.usuarioServicie.guardarusuario(usuario);

    }

    /**
     * Devuelve el usuario por id.
     * 
     * @param id El id del usuario a recuperar.
     * @return Opcional<modelousuario>
     */
    @GetMapping(path = "/{id}")
    public Optional<usuarioModel> obtenerUsuarioPorId(@PathVariable("id") long id) {
        return this.usuarioServicie.optenerporId(id);

    }

    /**
     * Devuelve una lista de usuarios con la misma prioridad.
     * 
     * @param prioridad La prioridad del usuario.
     * @return Una ArrayList de modelo de usuario
     */
    @GetMapping(path = "/query")
    public ArrayList<usuarioModel> obtenerPorprioridad(@RequestParam("prioridad") Integer prioridad) {
        return this.usuarioServicie.obtenerPorPrioridad(prioridad);
    }

    /**
     * *|CURSOR_MARCADOR|*
     * 
     * @param id El id del usuario a eliminar.
     */
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") long id) {
        boolean ok = this.usuarioServicie.eliminarUsuario(id);

        try {
            if (ok) {
                return "se a eliminado el usuario con id: " + id;
            } else {
                return "error";
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return "error";
        }
    }

}
