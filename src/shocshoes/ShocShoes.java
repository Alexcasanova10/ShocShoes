package shocshoes;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

 
public class ShocShoes {
 
    public static void main(String[] args) {
 
    mostrarMenu();
   
}
    
     
    
public static void mostrarMenu(){
     arrProductos arregloProd = new arrProductos(4,4);
    listAlmacen almacenShocShoes = new listAlmacen();
    
    arregloProd.agregarProducto(0, 0, new Productos("Forum Adidas",28.0,1001));
    arregloProd.agregarProducto(0, 1, new Productos("Forum Adidas",26.0,1001));
    arregloProd.agregarProducto(0, 2, new Productos("Forum Adidas",27.0,1001));
         
    arregloProd.agregarProducto(1, 0, new Productos("Air Jordan ",28.0,1002));
    arregloProd.agregarProducto(1, 1, new Productos("Air Jordan ",27.0,1002));
    arregloProd.agregarProducto(1, 2, new Productos("Air Jordan ",26.0,1002));
    
    arregloProd.agregarProducto(2, 0, new Productos("Reebook Chidos",28.0,1003));
    arregloProd.agregarProducto(2, 1, new Productos("Reebook Chidos",27.0,1003));
    arregloProd.agregarProducto(2, 2, new Productos("Reebook Chidos",26.0,1003));
    
    arregloProd.agregarProducto(3, 0, new Productos("Puma Mamalones",26.0,1004));
    arregloProd.agregarProducto(3, 1, new Productos("Puma Mamalones",29.0,1004));
    arregloProd.agregarProducto(3, 2, new Productos("Puma Mamalones",24.0,1004));
    
    almacenShocShoes.insert_inicio(arregloProd.obtenerProducto(0, 0));
    almacenShocShoes.insertar_siguiente(arregloProd.obtenerProducto(0, 1));
    almacenShocShoes.insertar_siguiente(arregloProd.obtenerProducto(0, 2));

    almacenShocShoes.insertar_siguiente(arregloProd.obtenerProducto(1, 0));
    almacenShocShoes.insertar_siguiente(arregloProd.obtenerProducto(1, 1));
    almacenShocShoes.insertar_siguiente(arregloProd.obtenerProducto(1, 2));
    
    
    
    JOptionPane.showMessageDialog(null, "**BIENVENIDO A SHOC SHOES**");

    // Opciones Menú Inicio
    String[] opcionesMenu = {"Productos", "Almacen Stock", "Compras", "Salir"};

    // Opciones Menú Productos
    String[] opcionesProductos = {"Agregar Productos", "Información de Producto", "Listado de Items", "Volver a menú principal"};

    // Opciones Menú Almacen
    String[] opcionesAlmacen = {"Ver Stock Completo", "Buscar producto","Reporte de producto", "Insertar Producto en Stock", "Insertar Producto en posición deseada", "Insertar al final", "Editar información de producto", "Eliminar producto de Stock", "Eliminar ultimo producto", "Volver a menú principal"};

    JComboBox<String> comboBox = new JComboBox<>(opcionesAlmacen);

    // Opciones Menú Compras
    String[] opcionesCompras = {"Comprar Producto", "Volver a menú principal"};

    int userOpcion;
    int userOpProd;
    int userOpAlma; // 9 opciones 0 a 8 array elementos
    int userOpCompras;

    do {
        userOpcion = JOptionPane.showOptionDialog(
                null, 
                "Selecciona una opción:", 
                "Menú de Opciones", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                opcionesMenu, 
                opcionesMenu[0]
        );

        switch (userOpcion) {
            case 0:
                do {
                    userOpProd = JOptionPane.showOptionDialog(
                            null, 
                            "Elige una acción", 
                            "Menú Productos", 
                            JOptionPane.DEFAULT_OPTION, 
                            JOptionPane.INFORMATION_MESSAGE, 
                            null, 
                            opcionesProductos, opcionesProductos[0]);
                    switch(userOpProd){
                        case 0: 
                                JOptionPane.showMessageDialog(null, "Opción: Agregar Producto");
                                String respuestaModelo = JOptionPane.showInputDialog("Nombre de modelo: ");
                                String respuestaTalla = JOptionPane.showInputDialog("Inserte la talla");
                                double respuestaTallaD = Double.parseDouble(respuestaTalla);

                                // Obtener el siguiente índice disponible y el siguiente SKU
                                int[] siguienteIndice = arregloProd.obtenerSiguienteIndiceDisponible();
                                if (siguienteIndice == null) {
                                    JOptionPane.showMessageDialog(null, "No hay espacio disponible para más productos.", "Error", JOptionPane.ERROR_MESSAGE);
                                    break;
                                }
                                int siguienteSKU = arregloProd.obtenerSiguienteSKU();

                                // Agregar el producto usando el siguiente índice disponible y el siguiente SKU
                                arregloProd.agregarProducto(siguienteIndice[0], siguienteIndice[1], new Productos(respuestaModelo, respuestaTallaD, siguienteSKU));
                                JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
                                break;
                        case 1:
                                JOptionPane.showMessageDialog(null, "Opción: Obtener Información de Producto");

                                try {
                                    // Pedir al usuario el índice del modelo
                                    String modeloIndexStr = JOptionPane.showInputDialog(null, "Ingrese el índice del modelo:");
                                    if (modeloIndexStr == null) break; // Si el usuario cancela
                                    int modeloIndex = Integer.parseInt(modeloIndexStr);

                                    // Pedir al usuario el índice de la talla
                                    String tallaIndexStr = JOptionPane.showInputDialog(null, "Ingrese el índice de la talla:");
                                    if (tallaIndexStr == null) break; // Si el usuario cancela
                                    int tallaIndex = Integer.parseInt(tallaIndexStr);

                                    // Obtener el producto usando los índices proporcionados
                                    Productos producto = arregloProd.obtenerProducto(modeloIndex, tallaIndex);

                                    // Mostrar la información del producto
                                    if (producto != null) {
                                        JOptionPane.showMessageDialog(null, producto.toString(), "Información del Producto", JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No hay producto en los índices especificados.", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Índices inválidos. Por favor, ingrese números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Opción: Listado de Productos");
                               String listaProductos = arregloProd.imprimirProductos();
                               JOptionPane.showMessageDialog(null, listaProductos, "Listado de Productos", JOptionPane.INFORMATION_MESSAGE);
                               break;                            
                        case 3:
                            JOptionPane.showMessageDialog(null, "Redirección a Menú Principal");
                            break;
                    }
                } while (userOpProd != 3);
                break;
            case 1:
                while (true) {
                    userOpAlma = JOptionPane.showConfirmDialog(
                        null, 
                        comboBox, 
                        "Menú Almacén", 
                        JOptionPane.OK_CANCEL_OPTION, 
                        JOptionPane.QUESTION_MESSAGE
                    );

                    if (userOpAlma == JOptionPane.CANCEL_OPTION || userOpAlma == JOptionPane.CLOSED_OPTION) {
                        break;
                    }

                    String opcionSeleccionada = (String) comboBox.getSelectedItem();

                    switch (opcionSeleccionada) {
                              case "Ver Stock Completo":
                            JOptionPane.showMessageDialog(null, "Opción: Ver Stock Completo");
                            String stockCompleto = almacenShocShoes.recorrerLista();
                            JOptionPane.showMessageDialog(null, stockCompleto, "Stock Completo", JOptionPane.INFORMATION_MESSAGE);
                            break;
                         
                              case "Buscar producto":
                            JOptionPane.showMessageDialog(null, "Opción: Buscar producto");
                            
                            String busqueda = JOptionPane.showInputDialog(null,"Ingresa la posición del producto a buscar");
                            
                            int busquedaInt = Integer.parseInt(busqueda);
                            almacenShocShoes.buscarNodo(userOpAlma);
                            
                              
                              break;
                         case "Reporte de producto":
                            JOptionPane.showMessageDialog(null, "Opción: Reporte de producto");
                            String respuestaSKU = JOptionPane.showInputDialog("Ingrese el SKU del producto:");
                            int sku = Integer.parseInt(respuestaSKU);
                            String reporte = almacenShocShoes.reporteProducto(sku);
                            JOptionPane.showMessageDialog(null, reporte, "Reporte de Producto", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Insertar Producto en Stock":
                            JOptionPane.showMessageDialog(null, "Opción: Insertar Producto en Stock");
                            String modelo = JOptionPane.showInputDialog("Nombre de modelo: ");
                            String talla = JOptionPane.showInputDialog("Inserte la talla");
                            double tallaD = Double.parseDouble(talla);
                            int[] siguienteIndice = arregloProd.obtenerSiguienteIndiceDisponible();
                            if (siguienteIndice == null) {
                                JOptionPane.showMessageDialog(null, "No hay espacio disponible para más productos.", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                            int siguienteSKU = arregloProd.obtenerSiguienteSKU();
                            Productos nuevoProducto = new Productos(modelo, tallaD, siguienteSKU);
                            arregloProd.agregarProducto(siguienteIndice[0], siguienteIndice[1], nuevoProducto);
                            almacenShocShoes.insert_final(nuevoProducto);
                            JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
                            break;
                            
                        case "Insertar Producto en posición deseada":
                            JOptionPane.showMessageDialog(null, "Opción: Insertar Producto en posición deseada");
                            String posProd = JOptionPane.showInputDialog("Inserte la posición donde insertar el producto");
                            int posProdInt = Integer.parseInt(posProd);
                            modelo = JOptionPane.showInputDialog("Nombre de modelo: ");
                            talla = JOptionPane.showInputDialog("Inserte la talla");
                            tallaD = Double.parseDouble(talla);
                            
                            
                            
                            arregloProd = almacenShocShoes.getArregloProductos(); 
                            int skuCons = arregloProd.obtenerSiguienteSKU();
                            
                            
                            Productos prodDes = new Productos(modelo,tallaD,skuCons);
                            
                            almacenShocShoes.insert_posx(posProdInt, prodDes);
                            JOptionPane.showMessageDialog(null, "Producto agregado al almacen  correctamente.");
                            
                            
                            break;
                        case "Insertar al final":
                            
                            JOptionPane.showMessageDialog(null, "Opción: Insertar al final");
                            modelo = JOptionPane.showInputDialog("Nombre de modelo: ");
                            talla = JOptionPane.showInputDialog("Inserte la talla");
                            tallaD = Double.parseDouble(talla);
                            skuCons = arregloProd.obtenerSiguienteSKU();

                            Productos productoFinal = new Productos(modelo,tallaD, skuCons);
                            
                            
                            almacenShocShoes.insert_final(productoFinal);
                            
                            JOptionPane.showMessageDialog(null, "Producto agregado al almacen correctamente.");
                            
                            
                            break;
                        case "Editar información de producto":
                            JOptionPane.showMessageDialog(null, "Opción: Editar información de producto");
                            String posEdiS = JOptionPane.showInputDialog("Inserte la posición de producto a editar");
                            int posEdi = Integer.parseInt(posEdiS);
                            
                            String modeloEdi = JOptionPane.showInputDialog("Inserte el nuevo modelo");
                            
                            String tallaEdi = JOptionPane.showInputDialog("Inserte la nueva talla");
                            
                            double tallaEdiD  = Double.parseDouble(tallaEdi);
                            
                            
                            Productos nuevaInfo = new Productos(modeloEdi,tallaEdiD);
                            almacenShocShoes.editar_Producto(posEdi, nuevaInfo);
                            
                            JOptionPane.showMessageDialog(null, "Información actualizada exitosamente");
                            
                            
                             
                            break;
                        case "Eliminar producto de Stock":
                            JOptionPane.showMessageDialog(null, "Opción: Eliminar producto de Stock");
                            String posX = JOptionPane.showInputDialog("Inserte la posición del elemento a eliminar");
                            
                            int posicion_elix = Integer.parseInt(posX);
                            
                            JOptionPane.showMessageDialog(null, ("Se eliminará el producto: " + almacenShocShoes.buscarNodo(posicion_elix)));
                            
                            almacenShocShoes.eliminar_x(posicion_elix);
                            JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente");
                            
                            
                            break;
                        case "Eliminar último producto":
                            JOptionPane.showMessageDialog(null, "Opción: Eliminar último producto");
                            
                            almacenShocShoes.eliminar_final();
                            
                            JOptionPane.showMessageDialog(null, "Se ha eliminado el ultimo producto del almacén.");
                            
                            break;
                        case "Volver a menú principal":
                            JOptionPane.showMessageDialog(null, "Redirección a Menú Principal");
                            break;
                    }
                    if ("Volver a menú principal".equals(opcionSeleccionada)) {
                        break;  
                    }
                }
                break;
            case 2:
                do {
                    userOpCompras = JOptionPane.showOptionDialog(
                            null, 
                            "Elige una acción", 
                            "Menú Compras", 
                            JOptionPane.DEFAULT_OPTION, 
                            JOptionPane.INFORMATION_MESSAGE, 
                            null, 
                            opcionesCompras, opcionesCompras[0]);
                    switch(userOpCompras){
                        case 0:
                            JOptionPane.showMessageDialog(null, "Comprar productos ");
                            
                            String cantPiezas = JOptionPane.showInputDialog(null,"Cantidad de piezas a adquirir");
                            int cantPiezasInt = Integer.parseInt(cantPiezas);
                            
                            String modeloSku = JOptionPane.showInputDialog("SKU de modelo: ");
                            int modeloSkuInt = Integer.parseInt(modeloSku);
                                    
                                    
                            String talla = JOptionPane.showInputDialog("Inserte la talla");
                            double tallaD = Double.parseDouble(talla);
                            
                            String skuCompra = JOptionPane.showInputDialog("SKU de producto a comprar");
                            
                            
                            int skuCons = Integer.parseInt(skuCompra);
                            
                            recursiveStock stockCompra = new  recursiveStock();
                            
                            stockCompra.actualizarStock(cantPiezasInt, modeloSkuInt, tallaD, almacenShocShoes);
                            
                            JOptionPane.showMessageDialog(null,"Compra realizada con éxito!");
                            
                            JOptionPane.showMessageDialog(null,("Almacen actualizado con compra " + almacenShocShoes.recorrerLista()));
                            
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null, "Redirección a Menú Principal");
                            break;
                    }
                } while (userOpCompras != 1);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "¡Gracias por usar ShocShoes!");
                break;
            default:
                userOpcion = 3;
                break;
        }
    } while (userOpcion != 3);
}

    
    
 

    
}