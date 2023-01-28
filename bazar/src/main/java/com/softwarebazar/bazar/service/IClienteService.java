
package com.softwarebazar.bazar.service;
import com.softwarebazar.bazar.model.Cliente;
import java.util.List;


public interface IClienteService {
    
    public List<Cliente> getClientes();
    
    //alta (parámetro con objeto cliente + guardado)
    public void saveCliente(Cliente cli); 
    
    public void deleteCliente(Long id);
    
    //va a devolver un Cliente
    public Cliente findCliente(Long id);
    
    public void editCliente(Long id_cliente, String nombreNuevo,
                            String apellidoNuevo, String nuevoDni);
}
