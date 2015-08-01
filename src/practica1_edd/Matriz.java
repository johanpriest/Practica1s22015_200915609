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
public class Matriz {
    /** Clase interna que representa un nodo o "celda" en la matriz*/
    class Nodo{
        /**Informacion a guardar en la matriz*/
        private Objeto_juego info; 
        /** Identificador de fila */
        protected int row = 0;
        /** Identificador de Columna */
        protected int col = 0;
        /**Puntero a siguiente dato en la columna*/
        protected Nodo siguienteCol = null; 
        /**Puntero a siguiente dato en la fila*/
        protected Nodo siguienteRow = null; 
        /**Puntero a anterior dato en la columna*/
        protected Nodo anteriorCol = null; 
        /**Puntero a anterior dato en la fila*/
        protected Nodo anteriorRow = null; 
        /**Asigna numero de fila*/
        public int getRow(){return this.row;}; 
        /**Asigna numero de columna*/
        public int getCol(){return this.col;}; 
         /**@return Numero de Fila*/
        public void setRow(int value){this.row = value;};
        /**@return Numero de Columna*/
        public void setCol(int value){this.col = value;};
        /**Actualiza dato*/
        public void setDato(Objeto_juego d){
            info.setNombre(d.getNombre());
            info.seturl(d.geturl());
        }
          /**Devuelve puntero a siguiente nodo en la Columna (siguiente fila)*/
        public Nodo getSiguienteCol(){return this.siguienteCol;};
        /**Devuelve puntero a siguiente nodo en la Fila (siguiente columna)*/
        public  Nodo getSiguienteRow(){return this.siguienteRow;};    
        /**Devuelve puntero a anterior nodo en la Columna (siguiente fila)*/
        public Nodo getAnteriorCol(){return this.anteriorCol;};
        /**Devuelve puntero a anterior nodo en la Fila (siguiente columna)*/
        public  Nodo getAnteriorRow(){return this.anteriorRow;};    
        /**Asigna puntero a siguiente nodo en la Columna (siguiente fila)*/
        public void setSiguienteCol(Nodo n){this.siguienteCol = n;};
        /**Asigna puntero a siguiente nodo en la Fila (siguiente columna)*/
        public  void setSiguienteRow(Nodo n){this.siguienteRow = n;};    
        /**Asigna puntero a anterior nodo en la Columna (siguiente fila)*/
        public void setAnteriorCol(Nodo n){this.anteriorCol = n;};
        /**Asigna puntero a anterior nodo en la Fila (siguiente columna)*/
        public  void setAnteriorRow(Nodo n){this.anteriorRow = n;};    
         /**Constructor para Nodos Indice
         @param r Indice de fila
         @param c Indice de columna
         */
        public Nodo(int r, int c, Nodo sigRow, Nodo sigCol){
            // Asigna dato
            // Asigna indices
            setRow(r);
            setCol(c);        
            //Asigna punteros
            this.siguienteCol = sigCol;
            this.siguienteRow = sigRow;
        }
        /**Constructor para Nodos con dato
         @param input datos de entrada
         @param r Indice de fila
         @param c Indice de columna
         @param sigRow Apuntador a siguiente dato en la fila
         @param sigCol Apuntador a siguiente dato en la columna
         @param mat Matriz a la que pertenecera el dato*/
        public Nodo(Objeto_juego input, int r, int c, Nodo sigRow, Nodo sigCol, Nodo antRow, Nodo antCol, Matriz mat){
            // Asigna dato
            this.info = new Objeto_juego(input.nombre,input.Url);   
            // Asigna indices
            setRow(r);
            setCol(c);        
            //Asigna punteros
            this.siguienteCol = sigCol;
            this.siguienteRow = sigRow;
            this.anteriorCol = antCol;
            this.anteriorRow = antRow;
        }
    }
    
    
    
}
