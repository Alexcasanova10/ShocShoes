
package shocshoes;

public class recursiveStock {
//En este caso, a la hora de actualizar el stock de productos, se desarrollaran funciones específicas mediante el uso de recursividad a la hora de que se compra un producto en el sitio web.

    public int actualizarStock(int cantPiezas, int modeloSKU, int talla){
     int stock = 0;
    //cantidad de stock obtenida de listAlmacen, o sea de los nodos,pendiente modificar eso
     //Antes de invocsr el metodo recursivo,verificar stock
       if(cantPiezas == 0){
           return 0;
       }else{
           while(cantPiezas > 0){
               stock -= cantPiezas;
               //actualizarStock(cantPiezas -1);
           }
       }
        System.out.println("Cantidad de piezas disponibles en almacen : ");
        return stock;
    }
    
}
