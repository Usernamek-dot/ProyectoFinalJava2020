/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Control.ClienteCTRL;
import Dto.ClienteDTO;
import Modelo.ClienteDAO;
import java.util.List;

/**
 *
 * @author karol
 */
public class listaTEST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteDAO clienteDAO1 = new ClienteDAO();

        ClienteDTO clienteDTO1 = new ClienteDTO();
        ClienteCTRL ClienteCTRL1 = new ClienteCTRL(); //
        List<ClienteDTO> ListaClienteDTO1 = clienteDAO1.getClienteDTO();
        
        for(int i=0 ; i < ListaClienteDTO1.size() ; i++) 
        {
            System.out.println(ListaClienteDTO1.get(i).getDocumento()+" "
                    + ""+ ListaClienteDTO1.get(i).getNombres() + ""+ ListaClienteDTO1.get(i).getApellidos() +""+ ListaClienteDTO1.get(i).getTelefono() +"" + ListaClienteDTO1.get(i).getDireccion()+"" + ListaClienteDTO1.get(i).getDepartamento()+""+ListaClienteDTO1.get(i).getMunicipio());
        }
        
        

        
    }

}
