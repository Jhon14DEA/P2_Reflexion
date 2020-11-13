/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.ec.Controlador;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 * @param <E>
 */
public abstract class ControladorGenerico<E>{
    private List<E> listado;
    

    public ControladorGenerico(){
    listado = new ArrayList<>();
    }

    public boolean create(E obj){
      return listado.add(obj);
    }
    
    public boolean eliminar(E obj){
        E objEliminar = buscar(obj);
        return (objEliminar != null)? listado.remove(obj):false;
    }
    
    public E buscar(E comparacion){
        return listado.stream().filter(obj -> obj.equals(comparacion)).findFirst().get();
    }
    public int buscarPosicion(E comparacion) {
        for (int i = 0; i < listado.size(); i++) {
            E obj = listado.get(i);
            if (obj.equals(comparacion)) {
                return i;
            }
        }
        return -1;        
    }
    
     public boolean actualizar(E obj, E nuevoObjeto){
    
         int index = buscarPosicion(obj);
         if(index >0){
             listado.set(index, obj);
         }
         return  (index >0);
     }
    
     public List<E> findAll(){
     return listado;
     }
    public abstract boolean validar(E obj);

    public List<E> getListado() {
        return listado;
    }
    
    public int cargarCodigo() {
        if (findAll().size() > 0) {
            return findAll().size() + 1;
        } else {
            return 1;

        }
    }
    public void setListado(List<E> listado) {
        this.listado = listado;
    }

    
    
}
