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
public class NodoL {
    public Objeto_juego objeto;
    public NodoL siguiente;
    public NodoL anterior;
    public NodoL(Objeto_juego obj, NodoL siguiente, NodoL anterior){
      this.objeto=obj;
      this.siguiente=siguiente;
      this.anterior=anterior;
    }
  public Objeto_juego getinfo(){
  
  return objeto;
  }  
  public void setinfo(Objeto_juego obj){
  this.objeto=obj;
  }
  public NodoL getanterior(){
  return anterior;
  }
  public void setanterior(NodoL anterior){
  this.anterior=anterior;
  }
  public NodoL getsiguiente(){
  return siguiente;
  }
  public void setsiguiente(NodoL siguiente){
  this.siguiente=siguiente;
  
  }
}
