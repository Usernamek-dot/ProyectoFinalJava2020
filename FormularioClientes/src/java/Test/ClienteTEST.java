/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Dto.ClienteDTO;
import Modelo.ClienteDAO;
import java.util.Scanner;

/**
 *
 * @author karol
 */
public class ClienteTEST {
    
    public static void main(String[] args) {
        
        ClienteDTO clienteDTO1 = new ClienteDTO();        
        ClienteDAO clienteDAO1 = new ClienteDAO();
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor ingrese el Documento");
        clienteDTO1.setDocumento(sc.nextLine());
        System.out.println("Por favor ingrese el nombre");
        clienteDTO1.setNombres(sc.nextLine());
        clienteDAO1.saveCliente(clienteDTO1);
    }    
    
}
