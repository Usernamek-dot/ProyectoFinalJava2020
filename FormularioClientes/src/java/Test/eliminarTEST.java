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
public class eliminarTEST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
           ClienteDAO clienteDAO1 = new ClienteDAO();
        ClienteDTO clienteDTO1 = new ClienteDTO();
         ClienteCTRL  ClienteCTRL1 = new ClienteCTRL(); //

        clienteDTO1.setDocumento("109080");

        
          System.out.println(ClienteCTRL1.eliminarCliente(clienteDTO1));
        // TODO code application logic here
    }
    
}
