
package com.softwarebazar.bazar.service;
import com.softwarebazar.bazar.model.Cliente;
import com.softwarebazar.bazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
    
    @Autowired
    private IClienteRepository cliRepo;

    @Override
    public List<Cliente> getClientes() {
        
        List<Cliente> listaClientes = cliRepo.findAll();
        return listaClientes;        
    }

    @Override
    public void saveCliente(Cliente cli) {
        cliRepo.save(cli);
        
    }

    @Override
    public void deleteCliente(Long id) {
        cliRepo.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {
        Cliente cli = cliRepo.findById(id).orElse(null);
        return cli;
    }

    @Override
    public void editCliente(Long id_cliente, String nombreNuevo,
            String apellidoNuevo, String nuevoDni) {
        
        Cliente cliEdit = this.findCliente(id_cliente);
        
        cliEdit.setNombre(nombreNuevo);
        cliEdit.setApellido(apellidoNuevo);
        cliEdit.setDni(nuevoDni);
        
        this.saveCliente(cliEdit);
    }
    
}
