/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_edd;

/**
 *
 * @author Gary ortiz
 */
public class Objeto_juego {
    String nombre;
    String Url;

    public Objeto_juego(String nombre, String url) {
        this.nombre=nombre;
        this.Url=url;
    }
    
    
    
    public String getNombre(){
    return this.nombre;
    }
      public String geturl(){
    return this.Url;
    }
        public void setNombre(String nombre){
     this.nombre=nombre;
    }
      public void seturl(String  url){
     this.Url=url;
    }
}
