
package com.softwarebazar.bazar.controller;
import com.softwarebazar.bazar.model.Cliente;
import com.softwarebazar.bazar.model.Producto;
import com.softwarebazar.bazar.model.Venta;
import com.softwarebazar.bazar.service.IVentaService;
import java.time.LocalDate;
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
public class VentaController{
    @Autowired
    private IVentaService venServ;
    
    @GetMapping("ventas")
    public List <Venta> getVentas(){
        return venServ.getVentas();    
    }
    
    @PostMapping("ventas/crear")
    public String saveVenta(@RequestBody Venta ven){
        venServ.saveVenta(ven);
        return "La venta se ha generado con éxito";
    }
    
    @DeleteMapping("ventas/eliminar/{codigo_venta}")
    public String saveVenta(@PathVariable Long codigo_venta){
        venServ.deleteVenta(codigo_venta);
        return "La venta ha sido eliminada";        
    }
    
    @GetMapping("ventas/{codigo_venta}")
    public Venta findVenta(@PathVariable Long codigo_venta){
        return venServ.findVenta(codigo_venta);        

    }
    
    @PutMapping("ventas/editar/{codigo_venta}")
    public Venta editVenta(@PathVariable Long codigo_venta,
            @RequestParam(required= false, name="fecha_venta") LocalDate nuevaFecha_venta,
            @RequestParam(required= false, name="total") Double nuevoTotal,
            @RequestParam(required= false, name="listaProductos") List<Producto> nuevoListaProducto, 
            @RequestParam(required= false, name="unCliente") Cliente nuevoCliente){
        
        venServ.editVenta(codigo_venta, nuevaFecha_venta, nuevoTotal, nuevoCliente, nuevoListaProducto);
        
        Venta ven = venServ.findVenta(codigo_venta);
        return ven;    
    } 
    
}
