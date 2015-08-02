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
public class Lista_objetos {
    private NodoL pnodo;
    private NodoL unodo;
    
    public Lista_objetos(){
    super();
    this.pnodo=null;
    this.unodo=null;
    }
    //metodo para la insercion al inicio de la lista doble
    public void insertarAlInicio(Objeto_juego obj){
    if(this.pnodo==null){
        this.pnodo=new NodoL(obj, null, null);
        this.unodo=this.pnodo;
    }else{
           NodoL nnodo =new NodoL(obj, null, this.pnodo);
         this.unodo.siguiente=nnodo;
         nnodo.anterior=unodo;
         unodo=nnodo;
         
                   
    }
    }
    //funcion para la insercion alfinal de la lista doble
    public void insertaralfinal(Objeto_juego obj){
           if(this.pnodo==null){
        this.unodo=new NodoL(obj, null, null);
        this.pnodo=this.unodo;
    }else{
           NodoL nnodo =new NodoL(obj, null, this.pnodo);
           this.unodo.setanterior(nnodo);
           this.unodo=nnodo;
                   
    }
    
    }
    //extraccion del elemento al principio de la lista
    public Objeto_juego extraeralinicio(){
    try{
      Objeto_juego obj=this.pnodo.getinfo();
      this.pnodo=this.pnodo.getsiguiente();
      if(this.pnodo!=null){
          this.pnodo.setanterior(null);
      
      }else{
      this.unodo=null;
      }
    return obj;
    }catch(Exception e){
    return null;
    
    }
    }
     //extraccion del elemento alfinal de la lista
    public Objeto_juego extraeralfinal(){
    try{
      Objeto_juego obj=this.unodo.getinfo();
      this.unodo=this.unodo.getanterior();
      if(this.unodo!=null){
          this.unodo.setsiguiente(null);
      
      }else{
      this.pnodo=null;
      }
    return obj;
    }catch(Exception e){
    return null;
    
    }
    }
    
    public void imprimirlista(){
    NodoL aux= this.pnodo;
    while(aux!=null){
    System.out.println(aux.getinfo().nombre);
    aux=aux.getsiguiente();
    }
    }
    public boolean buscar(Objeto_juego obj){
        NodoL aux=this.pnodo;
        while(aux!=null){
        if(aux.getinfo().equals(obj)){
            return true;
        }
        aux=aux.getsiguiente();
        }
    return false;
    }
}
