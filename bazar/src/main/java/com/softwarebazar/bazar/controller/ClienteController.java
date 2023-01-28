
package com.softwarebazar.bazar.controller;
import com.softwarebazar.bazar.model.Cliente;
import com.softwarebazar.bazar.service.IClienteService;
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
public class ClienteController {
    
    @Autowired
    private IClienteService cliServ;
    
    @GetMapping("clientes")
    public List<Cliente> getClientes(){        
        return cliServ.getClientes();        
    }
    
    @PostMapping("clientes/crear")
    public String saveCliente(@RequestBody Cliente cli){
        cliServ.saveCliente(cli);
        return "El cliente se guardó con éxito";
    }
    
    @DeleteMapping("clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        cliServ.deleteCliente(id_cliente);
        return "El cliente fue borrado con éxito";    
    }    
    
    @GetMapping("clientes/{id_cliente}")
    public Cliente findCliente(@PathVariable Long id_cliente){
        return cliServ.findCliente(id_cliente);
    }
    
    @PutMapping("clientes/editar/{id_cliente}")
    public Cliente editCliente(@PathVariable Long id_cliente,
                               @RequestParam(required = false, name="nombre") String nombreNuevo,
                               @RequestParam(required = false, name="apellido") String apellidoNuevo,
                               @RequestParam(required = false, name="dni") String nuevoDni){
        //Se edita en la BD
        cliServ.editCliente(id_cliente, nombreNuevo, apellidoNuevo, nuevoDni);
        
        Cliente cliEdit = this.findCliente(id_cliente);
        return cliEdit;        
    }
    
}
