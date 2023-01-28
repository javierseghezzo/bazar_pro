
package com.softwarebazar.bazar.service;
import com.softwarebazar.bazar.model.Producto;
import java.util.List;


public interface IProductoService {
    
    public List<Producto> getProductos();
    
    //alta (parámetro con objeto producto + guardado)
    public void saveProducto(Producto produc); 
    
    public void deleteProducto(Long id);
    
    //va a devolver un Producto
    public Producto findProducto(Long id);
    
    public void editProducto(Long codigo_producto, String nombreNuevo, String marcaNueva, Double costoNuevo, Double nuevaCantidad);
    
    public List <Producto> faltaStock();
    
}
