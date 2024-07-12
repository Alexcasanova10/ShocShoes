 
package shocshoes;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

 
public class ShocShoes {
 
    public static void main(String[] args) {
    
    /*arrProductos arregloProd = new arrProductos(3,3);
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
 
    
    arregloProd.imprimirProductos();
    //así se agergan productos usando ARREGLO BIDIMENSIONAL // ya tiene que esta rprecargado
    almacenShocShoes.insert_inicio(arregloProd.obtenerProducto(0, 0));
    almacenShocShoes.recorrerLista();
    almacenShocShoes.reporteProducto(1001);*/
        mostrarMenu();
   }  
    /*MENU SHOC SHOES*/
    
    
    public static void mostrarMenu(){
        
        JOptionPane.showMessageDialog(null, "**BIENVENIDO A SHOC SHOES**");
        
        //Opciones Menu Inicio
        String[] opcionesMenu = {"Productos", "Almacen Stock", "Compras", "Salir"};
        
        //Opciones Menu Productos
        String[] opcionesProductos = {"Agregar Productos", "Información de Producto", "Listado de Items", "Volver a menú principal"};
        //Opciones Menu Almacen
        String[] opcionesAlmacen = {"Ver Stock Completo", "Reporte de producto", "Insertar Producto en Stock", "Insertar Producto en posición deseada","Insertar al final","Editar información de producto", "Eliminar producto de Stock", "Eliminar ultimo producto","Volver a menú principal"};
        
        
        JComboBox<String> comboBox = new JComboBox<>(opcionesAlmacen);

        
        
        //Opciones Menu Compras
        String[] opcionesCompras = {"Comprar Producto", "Ver Ticket de Compra", "Volver a menú principal"};
         
        int userOpcion;
        int userOpProd;
        int userOpAlma; //9 opciones 0 a 8 array elementos
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
                                "Menu Productos", 
                                JOptionPane.DEFAULT_OPTION, 
                                JOptionPane.INFORMATION_MESSAGE, 
                                null, 
                                opcionesProductos, opcionesProductos[0]);
                        switch(userOpProd){
                            case 0:
                                JOptionPane.showMessageDialog(null, "Opción: Agregar Producto");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(null, "Opción: x");
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Opción: x");
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Redirección a Menú Principal");
                                break;
                        }
                    }while (userOpProd != 3);
                     
                    break;
                case 1:
                    /*do {
                        userOpAlma = JOptionPane.showOptionDialog(
                                    null, 
                                    "Elige una acción", 
                                    "Menu Almacen", 
                                    JOptionPane.DEFAULT_OPTION, 
                                    JOptionPane.INFORMATION_MESSAGE, 
                                    null, 
                                    opcionesAlmacen, opcionesAlmacen[0]);
                        switch(userOpAlma){
                            case 0:
                                JOptionPane.showMessageDialog(null, "Opción x");
                            break;
                            case 1:
                                JOptionPane.showMessageDialog(null, "Opción x");
                            break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Opción x");
                            break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Opción x");
                            break;
                            case 4:
                                JOptionPane.showMessageDialog(null, "Opción x");
                            break;
                            case 5:
                                JOptionPane.showMessageDialog(null, "Opción x");
                            break;
                            case 6:
                                JOptionPane.showMessageDialog(null, "Opción x");
                            break;
                            case 7:
                                JOptionPane.showMessageDialog(null, "Opción x");
                            break;
                            case 8:
                                JOptionPane.showMessageDialog(null, "Redirección a Menú Principal");
                            break;   
                        }
                    } while (userOpAlma != 8);*/
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
                                break;
                            case "Reporte de producto":
                                JOptionPane.showMessageDialog(null, "Opción: Reporte de producto");
                                break;
                            case "Insertar Producto en Stock":
                                JOptionPane.showMessageDialog(null, "Opción: Insertar Producto en Stock");
                                break;
                            case "Insertar Producto en posición deseada":
                                JOptionPane.showMessageDialog(null, "Opción: Insertar Producto en posición                                      deseada");
                                break;
                            case "Insertar al final":
                                JOptionPane.showMessageDialog(null, "Opción: Insertar al final");
                                break;
                            case "Editar información de producto":
                                JOptionPane.showMessageDialog(null, "Opción: Editar información de producto");
                                break;
                            case "Eliminar producto de Stock":
                                JOptionPane.showMessageDialog(null, "Opción: Eliminar producto de Stock");
                                break;
                            case "Eliminar ultimo producto":
                                JOptionPane.showMessageDialog(null, "Opción: Eliminar último producto");
                                break;
                            case "Volver a menú principal":
                                JOptionPane.showMessageDialog(null, "Redirección a Menú Principal");
                                break;  
                        }
                    }
                    break;
                case 2:
                    do {
                        userOpCompras = JOptionPane.showOptionDialog(
                                null, 
                                "Elige una acción", 
                                "Menu Compras", 
                                JOptionPane.DEFAULT_OPTION, 
                                JOptionPane.INFORMATION_MESSAGE, 
                                null, 
                                opcionesCompras, opcionesCompras[0]);
                        switch(userOpCompras){
                            case 0:
                                JOptionPane.showMessageDialog(null, "Opción x");
                            break;
                            
                            case 1:
                                JOptionPane.showMessageDialog(null, "Opción x");
                            break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Redirección a Menú Principal");
                            break;
                        }
                        
                    } while (userOpCompras != 2);
                    break;
                    
                    
                    
                case 3:
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar ShocShoes!");
                    break;
                default:
                    userOpcion = 3;
                    break;
            }
        }while (userOpcion != 3);
    }
    
    
 

    
}








