/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dto.ClienteDTO;
import Modelo.ClienteDAO;
import java.util.List;



/**
 *
 * @author karol
 */
public class ClienteCTRL {

    //CAPA PARA ANALIZAR LA INFO ANTES DE ENTRAR EN LA BD
    //instaciar capa DAO
    ClienteDAO clienteDAO1 = new ClienteDAO(); //

    public boolean saveCliente(ClienteDTO clienteDTO1 ) {

        return clienteDAO1.saveCliente(clienteDTO1);

    }
    
    public boolean  eliminarCliente(ClienteDTO clienteDTO1 ){
    return clienteDAO1.eliminarCliente(clienteDTO1);
    
            }
    
    public boolean actualizarCliente(ClienteDTO clienteDTO1 ){
    return clienteDAO1.actualizarCliente(clienteDTO1);
    
            }
    
    public ClienteDTO  getClienteDTO(String Documento ){
    return clienteDAO1.getClienteDTO(Documento);
            }
    
    public  List<ClienteDTO> getClienteDTO() {
    return clienteDAO1.getClienteDTO();
    }
}
