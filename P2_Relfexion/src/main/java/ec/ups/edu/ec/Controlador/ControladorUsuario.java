/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.ec.Controlador;

import ec.ups.edu.ec.Modelo.Usuario;

import java.util.List;

/**
 *
 * @author ASUS
 */
public class ControladorUsuario extends ControladorGenerico<Usuario>{

    @Override
    public boolean  validar(Usuario obj) throws Exception{
        if (obj.getCedula().length() == 10) {
            return true;
        }
        throw new Exception();
    }
    
    public Usuario login(String correo, String contrasena) {
        for (var usuario : (List<Usuario>) findAll()) {
            if (usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }
}
