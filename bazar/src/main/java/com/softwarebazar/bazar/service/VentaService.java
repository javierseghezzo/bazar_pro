
package com.softwarebazar.bazar.service;import com.softwarebazar.bazar.model.Cliente;
import com.softwarebazar.bazar.model.Producto;
import com.softwarebazar.bazar.model.Venta;
import com.softwarebazar.bazar.repository.IVentasRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {
    
    @Autowired
    private IVentasRepository venRepo;
    
    @Override
    public List<Venta> getVentas() {
        List <Venta> listaVentas = venRepo.findAll();        
        return listaVentas;        
    }

    @Override
    public void saveVenta(Venta ven) {
        venRepo.save(ven);
        
    }

    @Override
    public void deleteVenta(Long id) {
        venRepo.deleteById(id);
        
    }

    @Override
    public Venta findVenta(Long id) {
        Venta ven = venRepo.findById(id).orElse(null);        
        return ven;
        
    }

    @Override
    public void editVenta(Long codigo_venta, LocalDate nuevaFecha_venta, Double nuevoTotal, Cliente nuevoCliente, List<Producto> nuevoListaProducto) {
        Venta ven = this.findVenta(codigo_venta);
        
        ven.setFecha_venta(nuevaFecha_venta);
        ven.setTotal(nuevoTotal);
        ven.setListaProductos(nuevoListaProducto);
        ven.setUnCliente(nuevoCliente);
        
        this.saveVenta(ven);                
        
    }   
        
    
}
