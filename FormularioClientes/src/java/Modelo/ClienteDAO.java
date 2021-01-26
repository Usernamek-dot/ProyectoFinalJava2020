/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

//import static java.lang.Character.UnicodeBlock.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import Dto.ClienteDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karol
 *
 * capa
 */
public class ClienteDAO {
    //CAPA PARA GUARDAR EN LA BD DESPUES DEL CTRL

    String url = "jdbc:derby://localhost:1527/BDproyecto;create=true;user=karol;password=karol";

    //crear variable conexion
    Connection cnn;

    public boolean conectarBD() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            cnn = DriverManager.getConnection(url);
            return true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
            return false;
        }
    }

    public boolean saveCliente(ClienteDTO clienteDTO1) {
        try {
            //traer la conexion
            conectarBD();

            //IR A LA BD   la var conexion crea una sentencia
            Statement st = cnn.createStatement();
            st.executeUpdate("INSERT INTO TBLCLIENTE VALUES ("
                    + "'" + clienteDTO1.getDocumento() + "',"
                    + "'" + clienteDTO1.getNombres() + "',"
                    + "'" + clienteDTO1.getApellidos() + "',"
                    + "'" + clienteDTO1.getTelefono() + "',"
                    + "'" + clienteDTO1.getCorreo() + "',"
                    + "'" + clienteDTO1.getDireccion() + "',"
                    + "'" + clienteDTO1.getDepartamento() + "',"
                    + "'" + clienteDTO1.getMunicipio() + "')");
//                    
//                    
            st.close();
            return true;
        } catch (SQLException ex) {

            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("ERROR" + ex.toString());

        }
        return false;

    }

    public List<ClienteDTO> getClienteDTO() {
        int count = 0;
        ClienteDTO p = new ClienteDTO();
        ClienteDTO[] vp = new ClienteDTO[100];
        List<ClienteDTO> lp = new ArrayList<ClienteDTO>();

        try {
            conectarBD();
            Statement st = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs1 = st.executeQuery("SELECT * FROM TBLCLIENTE");
            rs1.beforeFirst();
            while (rs1.next()) {
                vp[count] = new ClienteDTO();

                vp[count].setDocumento(rs1.getString("DOCUMENTO"));
                vp[count].setNombres(rs1.getString("NOMBRES"));
                vp[count].setApellidos(rs1.getString("APELLIDOS"));
                vp[count].setTelefono(rs1.getString("TELEFONO"));
                vp[count].setCorreo(rs1.getString("CORREO"));
                vp[count].setDireccion(rs1.getString("DIRECCION"));
                vp[count].setDepartamento(rs1.getString("DEPARTAMENTO"));
                vp[count].setMunicipio(rs1.getString("MUNICIPIO"));
                lp.add(vp[count]);
                count++;

            }
            return lp;
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            return null;

        }
    }

    public boolean eliminarCliente(ClienteDTO clienteDTO1) {
        try {
            //traer la conexion
            conectarBD();

            //IR A LA BD   la var conexion crea una sentencia 
            Statement st = cnn.createStatement();

            st.execute("DELETE FROM TBLCLIENTE WHERE  documento='" + clienteDTO1.getDocumento() + "' ");

            st.close();
            return true;
        } catch (SQLException ex) {

            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ClienteDTO getClienteDTO(String documento) {

        try {
            conectarBD();
            ClienteDTO clienteDTO1 = new ClienteDTO();

            try (
                    Statement st = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
                ResultSet rs = st.executeQuery("SELECT * FROM TBLCLIENTE WHERE documento='" + documento + "'");
                rs.last();
                clienteDTO1.setDocumento(rs.getString("documento"));
                clienteDTO1.setNombres(rs.getString("nombres"));
                clienteDTO1.setApellidos(rs.getString("apellidos"));
                clienteDTO1.setTelefono(rs.getString("telefono"));
                clienteDTO1.setCorreo(rs.getString("correo"));
                clienteDTO1.setDireccion(rs.getString("direccion"));
                clienteDTO1.setDepartamento(rs.getString("departamento"));
                clienteDTO1.setMunicipio(rs.getString("municipio"));

                st.close();
            }
            return clienteDTO1;

        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
    }

    public boolean actualizarCliente(ClienteDTO clienteDTO1) {
        try {
            //traer la conexion
            conectarBD();

            //IR A LA BD   la var conexion crea una sentencia 
            Statement st = cnn.createStatement();

            st.executeUpdate("UPDATE TBLCLIENTE SET documento='" + clienteDTO1.getDocumento() + "' ,"
                    + "nombres='" + clienteDTO1.getNombres() + "', "
                    + "apellidos='" + clienteDTO1.getApellidos() + "' , "
                    + "telefono ='" + clienteDTO1.getTelefono() + "' , "
                    + "correo='" + clienteDTO1.getCorreo() + "' , "
                    + "direccion='" + clienteDTO1.getDireccion() + "' ,"
                    + " municipio='" + clienteDTO1.getMunicipio() + "' ,"
                    + "departamento='" + clienteDTO1.getDepartamento() + "' "
                    + "WHERE documento='" + clienteDTO1.getDocumento() + "'");

            st.close();
            return true;
        } catch (SQLException ex) {

            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
