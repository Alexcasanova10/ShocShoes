/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shocshoes;

/**
 *
 * @author ALEX
 */
public class Nodo {
    public Productos dataProducto;
    public Nodo siguiente;
    public Nodo anterior;

    public Nodo(Productos dataProducto) {
        this.dataProducto = dataProducto;
        this.siguiente = null;
        this.anterior = null;
    }
    
    
    public Productos getDataProducto() {
        return dataProducto;
    }

    public void setDataProducto(Productos dataProducto) {
        this.dataProducto = dataProducto;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    
     @Override
    public String toString() {
        return "" +  dataProducto ;
    }
    

    
    
    
    
    
    
    
    
    
}
