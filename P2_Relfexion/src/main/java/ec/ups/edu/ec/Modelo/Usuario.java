/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.ec.Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Usuario {
    
    private String cedula;
    private String nombre;
    private String apellido;
    private int codigo;
    private String correo;
    private String contraseña;
    //Metodos de agregacion
    private List<Telefono>ListaTelefonos;
    
    public Usuario(String cedula) {
       this.cedula =  cedula;
    }

    public Usuario(String cedula, String nombre, String apellido,int codigo, String correo,
            String contraseña) {
       this.cedula = cedula;
       this.nombre = nombre;
       this.apellido = apellido;
       this.correo = correo;
       this.contraseña = contraseña;
       this.codigo = codigo;
       
       ListaTelefonos = new ArrayList<>();
    }

    public Usuario(String cedula, String nombre, String apellido, int codigo, String correo, String contraseña, List<Telefono> ListaTelefonos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.correo = correo;
        this.contraseña = contraseña;
        this.ListaTelefonos = ListaTelefonos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public Usuario(List<Telefono> listaTelefonos){
        this.ListaTelefonos = listaTelefonos;
    }

    public void setListaTelefonos(List<Telefono> ListaTelefonos) {
        this.ListaTelefonos = ListaTelefonos;
    }

    //métodos de la agregación
    public void agregarTelefono(Telefono telefono) {
        this.ListaTelefonos.add(telefono);
    }

    public void actualizarTelefono(Telefono telefono) {
        var telefonoActualizar= ListaTelefonos.stream().filter(e -> e.getCodigo() == telefono.getCodigo()).findFirst().get();
        int index = ListaTelefonos.indexOf(telefonoActualizar);
        ListaTelefonos.remove(telefonoActualizar);
        ListaTelefonos.add(index, telefono);
        
    }

    public List<Telefono> getListaTelefonos() {
        return ListaTelefonos;
    }
/*
    public void eliminarTelefono (int codigo){

        var eliminarT = ListaTelefonos.stream().filter(telefono -> telefono.getCodigo() == codigo).findFirst().get();
        ListaTelefonos.remove(eliminarT);
                
    }
  */        
    public Telefono buscarTelefono(String numero) {
        return this.ListaTelefonos.stream().filter(e->e.getNumero().equals(numero)).findFirst().get();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.cedula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", codigo=" + codigo + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + ", ListaTelefonos=" + ListaTelefonos + '}';
    }
    
}
