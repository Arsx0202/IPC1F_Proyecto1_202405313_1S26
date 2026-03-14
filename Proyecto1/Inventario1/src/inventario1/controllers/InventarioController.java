/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario1.controllers;

import inventario1.models.InventarioModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author celad
 */
public class InventarioController {
    public static InventarioModel[] datosRopa = new InventarioModel[100];
    
    //metodo para agregar la ropa
    public void AgregarRopa(int id, String nombre, int cantidad, String categoria, double precio){
        
        for (int i = 0; i<datosRopa.length; i++){
            //Si id,cantidad y precio son negativos o iguales a 0, son "filtrados"
            if(id<=0){
                return;
            }
            if (cantidad<0){
                return;
            }
            if (precio<0){
                return;
                
            }
            //Si no se "filtran" entraran aqui
            if (datosRopa[i] == null){
            InventarioModel ropa = new InventarioModel();
            //"guardamos"  nustros productos
            ropa.setId(id);
            ropa.setNombre(nombre);
            ropa.setCantidad(cantidad);
            ropa.setCategoria(categoria);
            ropa.setPrecio(precio);
        
            
            datosRopa[i]=ropa;
                System.out.println("Se agrego el id"+id+"");
            return;  
           }
        }
    }
    //metodo para borrar y copiar
    public static InventarioModel BorrarRopa(int id){
         for (int i = 0; i<datosRopa.length; i++){
             if (datosRopa[i]!= null && datosRopa[i].getId()== id){
                 //guardamos una copia antes de borrar
                 InventarioModel CopiaFinal = datosRopa[i];
                 //remplazamos la posicion i con un null, dejando la posicion libre
                datosRopa[i]=null;
             return CopiaFinal; //Retornamos la copia
           }
        }
        return null;
    }
    //metodo para buscar
    public static InventarioModel BuscarRopa (int id, String nombre, String categoria){
        for (int i = 0; i<datosRopa.length; i++){
            if (datosRopa[i] != null){
                //Condiciones para buscar
                //Solo se necesita cumplir 1 condicion de las 3
                boolean idBuscar = (id != -1 && datosRopa[i].getId() == id);
                boolean nombreBuscar = (nombre != null && !nombre.isEmpty() && datosRopa[i].getNombre().equalsIgnoreCase(nombre));
                boolean categoriaBuscar = (categoria != null && !categoria.isEmpty() && datosRopa[i].getCategoria().equalsIgnoreCase(categoria));
                //Verificacion sobre si se cumnple o no alugna condicion
                if (idBuscar || nombreBuscar || categoriaBuscar){
                    return datosRopa[i];
                }
            }     
        }  
    return null;
    }
    //metodo para vender
    public static InventarioModel VenderRopa (int id, int CantidadVendida){
         for (int i = 0; i<datosRopa.length; i++){
            if (datosRopa[i]!= null && datosRopa[i].getId() == id){
                //Si cantidad a vender es mayor a cantidad en stock, no entra
                //Resta de la cantidad vendida
                if (datosRopa[i].getCantidad()>= CantidadVendida){
                    int RopaVendida = datosRopa[i].getCantidad() - CantidadVendida;
                    datosRopa[i].setCantidad(RopaVendida);
                    //Fecha y formato de la fecha
                    //tanto fecha como hora es la del sistema 
                    LocalDateTime Actual = LocalDateTime.now();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm:ss");
                    String fechaFormateada = Actual.format(formato);

                    InventarioModel venta = new InventarioModel();
                    venta.setNombre(datosRopa[i].getNombre());
                    venta.setPrecio(datosRopa[i].getPrecio());
                    venta.setFecha(Actual.format(formato));
                    //Total de la venta (precio de producto * cantidad del producto vendido)
                    double Total = datosRopa[i].getPrecio()*CantidadVendida;
                    
                    return venta;
                }
                else {
                    return null;
                }
            }
         }
         return null;
    }
    
 
 public static String Reporte() {
    StringBuilder html = new StringBuilder();
    
    
    html.append("<html><head><title>Reporte de Inventario</title>");
    html.append("<style>");
    html.append("body { font-family: Arial; margin: 40px; }");
    html.append("table { width: 100%; border-collapse: collapse; margin-bottom: 30px; }");
    html.append("th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }");
    html.append("th { background-color: #4CAF50; color: white; }");
    html.append("h2 { color: #333; }");
    html.append("</style></head><body>");
    
    html.append("<h1>Reporte General de Inventario</h1>");
    

   
    html.append("<h2>Productos en Stock</h2>");
    html.append("<table><tr><th>ID</th><th>Nombre</th><th>Categoría</th><th>Cantidad</th><th>Precio Unitario</th></tr>");
    
    for (int i = 0; i < datosRopa.length; i++) {
        if (datosRopa[i] != null) {
            html.append("<tr>")
                .append("<td>").append(datosRopa[i].getId()).append("</td>")
                .append("<td>").append(datosRopa[i].getNombre()).append("</td>")
                .append("<td>").append(datosRopa[i].getCategoria()).append("</td>")
                .append("<td>").append(datosRopa[i].getCantidad()).append("</td>")
                .append("<td>$").append(datosRopa[i].getPrecio()).append("</td>")
                .append("</tr>");
        }
    }
    html.append("</table>");
    
    html.append("</body></html>");
    return html.toString();
 }
    
    
}
