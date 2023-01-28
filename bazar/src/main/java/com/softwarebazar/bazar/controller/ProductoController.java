
package com.softwarebazar.bazar.controller;
import com.softwarebazar.bazar.model.Producto;
import com.softwarebazar.bazar.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService produServ;
    
    @GetMapping("productos")
    public List<Producto> getProductos(){
        return produServ.getProductos();
        
    }
    @PostMapping("productos/crear")
    public String saveProducto(@RequestBody Producto produc){
        produServ.saveProducto(produc);
        return "El producto se creó correctamente.";
    }
    
    @DeleteMapping("productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        produServ.deleteProducto(codigo_producto);
        return "El producto fue borrado con éxito";
    }
    
    @GetMapping("productos/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto){
        return produServ.findProducto(codigo_producto);
    }
    
    @PutMapping("productos/editar/{codigo_producto}")
    //Se establecen los nuevos atributos mediante los parámetros. El required=false sirve para
    //establecer la no obligatoriedad del parámetro.
    public Producto editProducto (@PathVariable Long codigo_producto,
            @RequestParam(required = false, name="nombre") String nombreNuevo,
            @RequestParam(required = false, name="marca") String marcaNueva,
            @RequestParam(required = false, name="costo") Double costoNuevo, 
            @RequestParam(required = false, name="cantidad_disponible") Double nuevaCantidad){
            
            //va a llamar al método editProducto y lo guarda en la BD
            produServ.editProducto(codigo_producto, nombreNuevo, marcaNueva, costoNuevo, nuevaCantidad);
            //instancio un nuevo objeto al que se le asignan los valores del producto ya editado.
            Producto produEditado = produServ.findProducto(codigo_producto);
            
            //devuelve el producto editado
            return produEditado;
    }
    
    @GetMapping("productos/falta_stock")
    public List<Producto> faltaStock(){
        return produServ.faltaStock();
    }
    
}
