/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shocshoes;
 
public class listAlmacen {
    //CADA PRODUCTO ES UN NODO (OSEA CADA PRODCUTO CON TALLA es un nodo, si tnemeos dos productos iguales (mismo modelo,talla y sku, entonces tenemos dos nodos)
//Básicamente, hacer el stock y almacén, vincular nodo a arreglos bidimensionales de productos
//llenar el almacen en la clase main
/* crear metodos: 
    insert_incio // done
    insert_final // done
    insertar_x(nodo anterior, nodo siguietne) // done
    
    eliminar_inicio // done
    eliminar_final // done
    eliminar_x(nodo anterior, nodo siguietne) // done
    
    actualizarNodo(int posicion) //actualiza la data de un nodo // done
    recorreLista // done
    buscarNodo(nodo en posicion que encontrar x y devuelve su info) // done
    
    verificarVacia // done
    size //devuelve la cantidad de elementos en el stock // done
    borrarLista(borra toda la lista) // done
 
*crud : agregar,mostrar, actualizar, borrar

*/
    public Nodo inicio;
    public Nodo fin;
    
    public listAlmacen(){
        this.inicio = null;
        this.fin = null;
        
    }
     public void insert_inicio(Productos producto){
        Nodo nodoNuevo = new Nodo(producto);
        if (inicio == null) {
            inicio = nodoNuevo;
            fin = nodoNuevo;
        } else {
            nodoNuevo.setSiguiente(inicio);
            inicio.setAnterior(nodoNuevo);
            inicio = nodoNuevo;
        }
    }
     

    public void insertar_siguiente(Productos producto) {
    Nodo nodoNuevo = new Nodo(producto);

     if (inicio == null) {
        inicio = nodoNuevo;
        fin = nodoNuevo;
    } else {
        Nodo nodoSiguiente = inicio.getSiguiente();

         nodoNuevo.setSiguiente(nodoSiguiente);
        nodoNuevo.setAnterior(inicio);

        inicio.setSiguiente(nodoNuevo);
        
         if (nodoSiguiente != null) {
            nodoSiguiente.setAnterior(nodoNuevo);
        } else {
             fin = nodoNuevo;
        }
    }
}

    
    
    public void insert_posx(int pos, Productos producto){
 Nodo nodoNuevo = new Nodo(producto);

     if (inicio == null) {
        inicio = nodoNuevo;
        fin = nodoNuevo;
    } else {
         if (pos == 1) {
            nodoNuevo.setSiguiente(inicio);
            inicio.setAnterior(nodoNuevo);
            inicio = nodoNuevo;
        } else {
            Nodo nodoActual = inicio;
            int contador = 1;

             while (nodoActual != null && contador < pos - 1) {
                nodoActual = nodoActual.getSiguiente();
                contador++;
            }

             if (nodoActual != null) {
                Nodo nodoPosterior = nodoActual.getSiguiente();

                nodoNuevo.setSiguiente(nodoPosterior);
                nodoNuevo.setAnterior(nodoActual);
                nodoActual.setSiguiente(nodoNuevo);

                if (nodoPosterior != null) {
                    nodoPosterior.setAnterior(nodoNuevo);
                } else {
                     fin = nodoNuevo;
                }
            } else {
                System.out.println("Posición no válida");
            }
        }
    }        
        
          
    }
    
    public void insert_final(Productos producto){
        Nodo nodoNuevo = new Nodo(producto);
        if(inicio == null){
            inicio = nodoNuevo;
            fin = nodoNuevo;
        }else {
             fin.setSiguiente(nodoNuevo);
             nodoNuevo.setAnterior(fin);
             fin = nodoNuevo;
        }
        
    }
    

    public void editar_Producto(int pos, Productos infoNueva){
       //obtener= info de nodo con la posicion, que dions, (getData), setter para poner la nueva data siendo info nueva
       if(inicio == null){
           System.out.println("Lista vacía ");
           return;
       }
        if(pos <= 0) {
            System.out.println("Posición no válida. Debe ser mayor que 0.");
            return;
        }
        Nodo nodoObtenido = buscarNodo(pos);
        
        if (nodoObtenido != null) {
            nodoObtenido.setDataProducto(infoNueva);
            System.out.println("Producto actualizado en la posicion " + pos);
        }else{
            System.out.println("No se encontró la posición indicada");
        }
       
        
    }
    
    
    public void eliminar_inicio(){
        if(inicio == null){
            System.out.println("Lista vacía");
            return;
        }
        inicio = inicio.getSiguiente();
        if (inicio != null) {
            inicio.setAnterior(null);
        }else{
            fin = null;
        }          
    }
    
    
     public void eliminar_x(int pos){
        if (inicio == null) {
            System.out.println("La lista está vacía");
            return;
        }
        
        Nodo nodoActual = inicio;
        int posicion = 1;
        while(nodoActual != null && posicion != pos){
            nodoActual = nodoActual.getSiguiente();
            posicion++;
        }
        
        if (nodoActual != null) {
            Nodo nodoAnterior = nodoActual.getAnterior();
            Nodo nodoSiguiente = nodoActual.getSiguiente();
            
            if (nodoAnterior != null) {
                nodoAnterior.setSiguiente(nodoSiguiente);
            }else{
                inicio = nodoSiguiente;
            }
            
            
            if (nodoSiguiente != null) {
                nodoSiguiente.setAnterior(nodoAnterior);
            }else{
                fin = nodoAnterior;
            }
            
        }else{
            System.out.println("No se encontró nodo en la posición indicada");
        }
        
    }
    
    
    
    public void eliminar_final(){
        if (fin == null) {
            System.out.println("Lista vacía");
            return;
        }
        fin = fin.getAnterior();
        
        if (fin != null) {
            fin.setSiguiente(null);
        }else{
            inicio = null;
        }
    }
    
    public void recorrerLista(){
        if (inicio == null) {
            System.out.println("Almacen vacía");
            return;
        }
        Nodo temp = inicio;
        while(temp != null){
            System.out.println(temp.getDataProducto() + " ->");
            temp = temp.getSiguiente();
        }
         
    }
    
    public Nodo buscarNodo(int lugar){
        if (inicio == null) {
            System.out.println("La lista está vacía");
            return null;
        }
        int contador = 1;
        Nodo nodoActual = inicio;
        
        while(nodoActual != null && contador != lugar){
           nodoActual = nodoActual.getSiguiente();
           contador++;
        }
        
        if (contador == lugar && nodoActual != null) {
            return nodoActual;
            
            
        }
        
        System.out.println("No se encontró un producto en la posición indicada");
        return null;
    }
    
    public void verificarVacia(){
        if(inicio == null){
            System.out.println("El almancen de productos está vacío");
        }else{
            System.out.println("El almacen contiene " + tamanioLista() + " productos");
        }
    }
    
    
     public int tamanioLista(){
        int tamanio = 0;
        Nodo temp = inicio;
        
        while(temp != null){
            tamanio++;
            temp = temp.getSiguiente();
        }
        return tamanio;
    }
  
    
    public void borrarLista(){
        inicio = null;
        fin = null;
    } 
    
    
    
    public void reporteProducto(int modeloSKU){
        int cont = 0;
        Productos producto = null;
        Nodo temp = inicio;
        
        if (inicio == null) {
            System.out.println("Almacén vacío");
            return;
        }
        
        while(temp != null){
            if (temp.getDataProducto().modeloSKU == modeloSKU) {
                cont++;
                producto = temp.getDataProducto();
            }
            
            temp = temp.getSiguiente();
        }
        
        if (cont > 0 && producto != null) {
            System.out.println("REPORTE DE BÚSQUEDA: Modelo " + producto.getModelo() + ", SKU: " + modeloSKU + ", Cantidad: " +             cont);
        }else{
            System.out.println("No se encontraron productos con el SKU: " + modeloSKU);
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
