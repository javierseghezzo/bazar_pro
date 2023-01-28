
package com.softwarebazar.bazar.service;
import com.softwarebazar.bazar.model.Producto;
import com.softwarebazar.bazar.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private IProductoRepository prodRepo;

    @Override
    public List<Producto> getProductos() {
        //                              Inyección al Repositorio.
        List<Producto> listaProductos = prodRepo.findAll();
        return listaProductos;
    }

    @Override
    public void saveProducto(Producto prod) {
        prodRepo.save(prod);
    }

    @Override
    public void deleteProducto(Long id) {
        prodRepo.deleteById(id);
    }

    @Override
    public Producto findProducto(Long id) {
        //se va a crear un objeto Producto porque es lo que va a retornar
        Producto prod = prodRepo.findById(id).orElse(null);
        return prod;
    }

    @Override
    public void editProducto(Long codigo_producto, String nombreNuevo, String marcaNueva,
            Double costoNuevo, Double nuevaCantidad) {
        Producto prod = this.findProducto(codigo_producto);
        
        prod.setNombre(nombreNuevo);
        prod.setMarca(marcaNueva);
        prod.setCosto(costoNuevo);
        prod.setCantidad_disponible(nuevaCantidad);
        
        //hay que pasarlo con el método save para que no haya objetos repetidos
        this.saveProducto(prod);
    
    }

    @Override
    public List <Producto> faltaStock() {
        final Double CINCO=5.0;
        List <Producto> listaStock = prodRepo.findAll();
        List <Producto> listaFaltante = new ArrayList<>();
        
        for(Producto pro:listaStock){
            pro.getCantidad_disponible();
                        
            if(pro.getCantidad_disponible() < CINCO){
                listaFaltante.add(pro);
            }           
        }
        return listaFaltante;
    }  
    
    
}
