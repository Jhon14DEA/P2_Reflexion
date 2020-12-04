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

    //private List<E> listaGenerica;
    
   
    @Override
    public boolean  validar(Usuario obj){
        if (obj.getCedula().length() == 10) {
            return true;
        }
        return false;
    }
    /*
     public Controlador() {
        listaGenerica = new ArrayList<>();
    }
     */
   
    public Usuario login(String correo, String contrasena) {

        for (Usuario usuario : (List<Usuario>)getListado()) {

            if (usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }
/*    
    @Overrideq
    public List<Usuario> findAll() {
       return getListado();
    }
  */  
}
