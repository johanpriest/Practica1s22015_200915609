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
           /**obtenemos el dato del nodo especifico*/
        public String getdato(){
         return info.nombre;
        
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
    
   /**Puntero al indice*/
    private Nodo inicio = null;
    /**Puntero a nodo actual*/
    private Nodo actual = null;
    /**Workplace al que pertenece la matriz*/

    /** Crea una nueva instancia de Matriz */
    public Matriz() {
        inicio = new Nodo(0,0,null,null);// Inicializa el nodo indice (0,0)
        actual = inicio;
    }
    /** Evalua si la matriz esta vacia*/
    public boolean estaVacia(){
        return ((inicio.getSiguienteCol()==null) && (inicio.getSiguienteRow())==null);
    }
    /**Va al inicio de la matriz*/
    public void irAlInicio(){
        actual = inicio;
    }
    /**Busca e inserta un nodo indice en la matriz*/
    public void insertarNodoIndice(char eje, int numIndice){
        actual = inicio;
        Nodo tmp;
        boolean encontrado = false;
        if(eje == 'x'){
            while(actual.getSiguienteCol()!=null && !encontrado){
                if(actual.getSiguienteCol().getCol() > numIndice){
                    encontrado = true;
                }
                actual = actual.getSiguienteCol();
            }
            if (encontrado){ // inserta entre nodos
                tmp = actual.getSiguienteCol();
                actual.setSiguienteCol(new Nodo(0,numIndice,null,null));
                actual.getSiguienteCol().setAnteriorCol(actual);
                actual.getSiguienteCol().setSiguienteCol(tmp);
            }
            else{ //inserta al final
                actual.setSiguienteCol(new Nodo(0,numIndice,null,null));
                actual.getSiguienteCol().setAnteriorCol(actual);
            }                
        }
        else if(eje == 'y'){
            while(actual.getSiguienteRow()!=null && !encontrado){
                if(actual.getSiguienteRow().getRow() > numIndice){
                    encontrado = true;
                }
                actual = actual.getSiguienteRow();
            }
            if (encontrado){ // inserta entre nodos
                tmp = actual.getSiguienteRow();
                actual.setSiguienteRow(new Nodo(numIndice,0,null,null));
                actual.getSiguienteRow().setAnteriorRow(actual);
                actual.getSiguienteRow().setSiguienteRow(tmp);
            }
            else{ //inserta al final
                actual.setSiguienteRow(new Nodo(numIndice,0,null,null));
                actual.getSiguienteRow().setAnteriorRow(actual);
            }
        }
    }
    /**Inserta o actualiza un dato en la fila y columna especificada
     @param d Dato a insertar
     @param x Columna donde va el dato
     @param y Fila donde va el dato*/
    public void insertar(Objeto_juego d,int x,int y){
        Nodo nuevo = null;
        Nodo indiceEnX,indiceEnY,tmp = null;
    
        if((x>0) && (y>0)){
            //Si tenemos una matriz virgen
            if(this.estaVacia()){
                nuevo = new Nodo(d,y,x,null,null,null,null,this);
                insertarNodoIndice('x',x);
                insertarNodoIndice('y',y);
                indiceEnX = irAlNodo(x,0);
                indiceEnX.setSiguienteRow(nuevo);
                nuevo.setAnteriorRow(actual);
                indiceEnY = irAlNodo(0,y);
                indiceEnY.setSiguienteCol(nuevo);
                nuevo.setAnteriorCol(actual);

            }
            else{
                if ((tmp = irAlNodo(x,y)) == null){
                    nuevo = new Nodo(d,y,x,null,null,null,null,this);
                    //Busca si existe indice en x y en y
                    indiceEnX = irAlNodo(x,0);
                    indiceEnY = irAlNodo(0,y);
                    if(indiceEnX == null){
                        insertarNodoIndice('x',x);
                        indiceEnX = irAlNodo(x,0);
                    }
                    if(indiceEnY == null){
                        insertarNodoIndice('y',y);
                        indiceEnY = irAlNodo(0,y);
                    }
                    //conexion entre el nuevo nodo y sus columnas colindantes 
                    tmp = buscarColumnaAnterior(x,y); // busca nodo anterior recorriendo la columna
                    nuevo.setAnteriorCol(tmp);
                    nuevo.setSiguienteCol(tmp.siguienteCol);
                    tmp.setSiguienteCol(nuevo);
                    if ( nuevo.getSiguienteCol()!=null) //enlaza con siguiente de la lista
                        nuevo.getSiguienteCol().setAnteriorCol(nuevo);
                    //conexion entre el nuevo nodo y sus filas colindantes
                    tmp = buscarFilaAnterior(x,y); // busca nodo anterior recorriendo la columna
                    nuevo.setAnteriorRow(tmp);
                    nuevo.setSiguienteRow(tmp.siguienteRow);
                    tmp.setSiguienteRow(nuevo);
                    if ( nuevo.getSiguienteRow()!=null)
                        nuevo.getSiguienteRow().setAnteriorRow(nuevo);
                }
                else{
                    tmp.setDato(d);
                }
            }
        }
    }
    /**Va al nodo especificado
     *@param x Coordenada x
     *@param y coordenada
     *@return Nodo direccionado con coordenadas*/
    protected Nodo irAlNodo(int x, int y){
        boolean encontrado = false;
        this.irAlInicio();
        if (x>0){
            while (actual/*.getSiguienteCol()*/!=null && !encontrado){
                if(actual.getCol()==x){
                    while(actual/*.getSiguienteRow()*/!= null && !encontrado){
                        if (actual.getRow()==y)
                            encontrado = true;
                        else
                            actual = actual.getSiguienteRow();
                    }
                }
                else
                    actual = actual.getSiguienteCol();
            }
        }
        else{
            while (actual/*.getSiguienteRow()*/!=null && !encontrado){
                if (actual.getRow() == y){
                    while(actual/*.getSiguienteCol()*/!=null && !encontrado){
                        if (actual.getCol() == x)
                            encontrado = true;
                        else
                            actual = actual.getSiguienteCol();
                    }
                }
                else
                    actual = actual.getSiguienteRow();
            }
        }
        if (encontrado)
            return actual;
        return null;
    }

    /**Busca Fila anterior al especificado en parametros, siguiente la coordenada dada
     * @param x coordenada del nodo objetivo
     * @param y coordenada del nodo objetivo
     * @return Puntero a nodo anterior segun se haya especificado,
     * */
    protected Nodo buscarFilaAnterior(int x, int y){

        actual = irAlNodo(x,0);
        //if (actual.getSiguienteRow()!=null)
            while(actual.getSiguienteRow()!=null && (actual.getSiguienteRow().getRow() < y))
                actual = actual.getSiguienteRow();
        
        return actual;
    }
    /**Busca Columna anterior al especificado en parametros, siguiente la coordenada dada
     * @param x coordenada del nodo objetivo
     * @param y coordenada del nodo objetivo
     * @return Puntero a nodo anterior segun se haya especificado,
     * */
    protected Nodo buscarColumnaAnterior(int x, int y){

        actual = irAlNodo(0,y);
        //if (actual.getSiguienteCol()!=null)
            while( actual.getSiguienteCol()!=null && (actual.getSiguienteCol().getCol() < x))
                actual = actual.getSiguienteCol();

    return actual;
    }
    /**borra a un nodo
     @param x Coordenada en x
     @param y Coordenada en y
     @return True si fue satisfactoria la eliminacion*/
    public boolean borrar(int x, int y){
        Nodo tmp;
        tmp = irAlNodo(x,y);
        if (tmp == null)
            return false;
        // borramos todas las referencias al nodo
        if (tmp.getAnteriorCol() != null)
            tmp.getAnteriorCol().setSiguienteCol(tmp.getSiguienteCol());
        if (tmp.getAnteriorRow() != null)
            tmp.getAnteriorRow().setSiguienteRow(tmp.getSiguienteRow());
        if (tmp.getSiguienteCol() != null)
            tmp.getSiguienteCol().setAnteriorCol(tmp.getAnteriorCol());
        if (tmp.getSiguienteRow() != null)
            tmp.getSiguienteRow().setAnteriorRow(tmp.getAnteriorRow());
        return true;
    }
    /**Obtiene el dato actual*/
    public Objeto_juego datoActual(){
        if (this.actual != null)
            return this.actual.info;
        else
            return null;
    }
    /**Retorna la expresion evaluada*/
    public String stringActual() {
        return this.actual.info.toString();
    }
    /**Va hacia el nodo especificado en parametros*/
    public void irA(int col, int row){
        actual = irAlNodo(col,row);
    }
    /**Vacia la matriz*/
    public void vaciar(){
        inicio.setSiguienteCol(null);
        inicio.setSiguienteRow(null);
    }
    
    
}
