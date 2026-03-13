/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario1.controllers;

import inventario1.models.InventarioModel;
import java.util.Date;

/**
 *
 * @author celad
 */
public class InventarioController {
    public static InventarioModel[] datosRopa = new InventarioModel[100];
    
    public void AgregarRopa(int id, String nombre, int cantidad, String categoria, double precio){
        
        for (int i = 0; i<datosRopa.length; i++){
            if (datosRopa[i] == null){
            InventarioModel ropa = new InventarioModel();
            
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
    
    public static InventarioModel BorrarRopa(int id){
         for (int i = 0; i<datosRopa.length; i++){
             if (datosRopa[i]!= null && datosRopa[i].getId()== id){
                 InventarioModel CopiaFinal = datosRopa[i];
                datosRopa[i]=null;
             return CopiaFinal;
           }
        }
        return null;
    }

    public static InventarioModel BuscarRopa (int id, String nombre, String categoria){
        for (int i = 0; i<datosRopa.length; i++){
            if (datosRopa[i] != null){
                boolean idBuscar = (id != -1 && datosRopa[i].getId() == id);
                boolean nombreBuscar = (nombre != null && !nombre.isEmpty() && datosRopa[i].getNombre().equalsIgnoreCase(nombre));
                boolean categoriaBuscar = (categoria != null && !categoria.isEmpty() && datosRopa[i].getCategoria().equalsIgnoreCase(categoria));
                
                if (idBuscar || nombreBuscar || categoriaBuscar){
                    return datosRopa[i];
                }
            }     
        }  
    return null;
    }
    
    public static InventarioModel VenderRopa (int id, int CantidadVendida){
         for (int i = 0; i<datosRopa.length; i++){
            if (datosRopa[i]!= null && datosRopa[i].getId() == id){
                if (datosRopa[i].getCantidad()>= CantidadVendida){
                    int RopaVendida = datosRopa[i].getCantidad() - CantidadVendida;
                    datosRopa[i].setCantidad(RopaVendida);
                    
                    InventarioModel venta = new InventarioModel();
                    venta.setNombre(datosRopa[i].getNombre());
                    venta.setPrecio(datosRopa[i].getPrecio());
                    
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
    
 
    
    
    
}
