/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Control.ClienteCTRL;
import Dto.ClienteDTO;
import Modelo.ClienteDAO;

/**
 *
 * @author karol
 */
public class guardarTEST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ClienteDAO clienteDAO1 = new ClienteDAO();
        ClienteDTO clienteDTO1 = new ClienteDTO();
         ClienteCTRL  ClienteCTRL1 = new ClienteCTRL(); //

        clienteDTO1.setDocumento("123");
        clienteDTO1.setNombres("neuvo");
        clienteDTO1.setApellidos("Karol");
        clienteDTO1.setTelefono("045806");
        clienteDTO1.setCorreo("melany@hotmail.com");
        clienteDTO1.setDireccion("dklkjl");
        clienteDTO1.setDepartamento("depart");
        clienteDTO1.setMunicipio("1");
        
          ClienteCTRL1.saveCliente(clienteDTO1);
        

    }

}
