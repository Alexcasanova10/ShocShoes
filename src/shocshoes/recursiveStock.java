
package shocshoes;

public class recursiveStock {
//En este caso, a la hora de actualizar el stock de productos, se desarrollaran funciones específicas mediante el uso de recursividad a la hora de que se compra un producto en el sitio web.

    public int actualizarStock(int cantPiezas, int modeloSKU, double talla, listAlmacen almacen){
      if (cantPiezas <= 0) {
            return 0;
        }

        Nodo nodoActual = almacen.inicio;
        while (nodoActual != null) {
            Productos producto = nodoActual.getDataProducto();
            if (producto.getmodeloSKU() == modeloSKU && producto.getTalla() == talla) {
                almacen.eliminarNodo(nodoActual);
                //System.out.println(": " + producto);
                return 1 + actualizarStock(cantPiezas - 1, modeloSKU, talla, almacen);
            }
            nodoActual = nodoActual.getSiguiente();
        }

        System.out.println("No se encontraron suficientes productos para eliminar.");
        return cantPiezas; 
    }
    
}
