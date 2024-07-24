 
package shocshoes;

 
public class arrProductos {
//usaremos este arreglo para definir los objetos productos y manipularlos    
/*
    
 //clase arrProductos nos despliega 
 *Observaciones:
 * modificar producto en la clase almacen 
 *reporte por producto de almacen // despleiga la cantidad de productos de x producto mediante su SKU, debemos poder devolver la cantidad por talla y modelo
    
*/  
    
    
//Los productos estarán definidos mediante una clase de Producto con sus respectivos atributos y métodos, así el inventario se organizará mediante arreglos bidimensionales, donde el primer elemento del índice (filas) define el modelo y el segundo (columna) la talla
    
    
    //array bdiimensional detipo objeto
    public Productos[][] modelosProducto;
    
    public arrProductos(int modelos, int talla){
        modelosProducto = new Productos[modelos][talla]; 
    }
    
     public void agregarProducto(int modeloIndex, int tallaIndex, Productos producto) {
        modelosProducto[modeloIndex][tallaIndex] = producto;
    }

     public Productos obtenerProducto(int modeloIndex, int tallaIndex) {
        return modelosProducto[modeloIndex][tallaIndex];
    }
    
    public String imprimirProductos(){
        StringBuilder productos = new StringBuilder();
        
         for (int i = 0; i < modelosProducto.length; i++) {
            for (int j = 0; j < modelosProducto[i].length; j++) {
                if (modelosProducto[i][j] != null) {
                    productos.append(modelosProducto[i][j]).append("\n");
                }
            }
        }

        if (productos.length() == 0) {
            productos.append("La lista de productos está vacía");
        }

        return productos.toString();
        
        
    }
    
   public int[] obtenerSiguienteIndiceDisponible() {
    for (int i = 0; i < modelosProducto.length; i++) {
        for (int j = 0; j < modelosProducto[i].length; j++) {
            if (modelosProducto[i][j] == null) {
                return new int[]{i, j};
            }
        }
    }
    return null;
}

    
        public int obtenerSiguienteSKU() {
        int maxSKU = 1000; 
        for (int i = 0; i < modelosProducto.length; i++) {
            for (int j = 0; j < modelosProducto[i].length; j++) {
                if (modelosProducto[i][j] != null && modelosProducto[i][j].getmodeloSKU() > maxSKU) {
                    maxSKU = modelosProducto[i][j].getmodeloSKU();
                }
            }
        }
        return maxSKU + 1;
    }
    
    
    
    
}
