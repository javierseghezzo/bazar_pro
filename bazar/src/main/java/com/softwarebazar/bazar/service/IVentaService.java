
package com.softwarebazar.bazar.service;


import com.softwarebazar.bazar.model.Cliente;
import com.softwarebazar.bazar.model.Producto;
import com.softwarebazar.bazar.model.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
    public List<Venta> getVentas();
    
    public void saveVenta(Venta ven);
    
    public void deleteVenta(Long id);
    
    public Venta findVenta(Long id);    
       
    public void editVenta(Long codigo_venta, LocalDate fecha_venta, Double total, Cliente nuevoCliente, List<Producto> nuevoListaProducto);   
     
    
}
