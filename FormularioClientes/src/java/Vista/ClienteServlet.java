/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ClienteCTRL;
import Dto.ClienteDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author karol
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            System.out.println(request.getParameter("documento"));
            System.out.println(request.getParameter("nombres"));
            System.out.println(request.getParameter("apellidos"));
            System.out.println(request.getParameter("telefono"));
            System.out.println(request.getParameter("correo"));
            System.out.println(request.getParameter("direccion"));
            System.out.println(request.getParameter("departamento"));
            System.out.println(request.getParameter("municipio"));
            System.out.println(request.getParameter("boton"));

            boolean estado = false;

            ClienteDTO clienteDTO1 = new ClienteDTO(); //
            ClienteCTRL ClienteCTRL1 = new ClienteCTRL(); //

            String boton = request.getParameter("boton");

            clienteDTO1.setDocumento(request.getParameter("documento"));
            clienteDTO1.setNombres(request.getParameter("nombres"));
            clienteDTO1.setApellidos(request.getParameter("apellidos"));
            clienteDTO1.setTelefono(request.getParameter("telefono"));
            clienteDTO1.setCorreo(request.getParameter("correo"));
            clienteDTO1.setDireccion(request.getParameter("direccion"));
            clienteDTO1.setDepartamento(request.getParameter("departamento"));
            clienteDTO1.setMunicipio(request.getParameter("municipio"));

            if (boton.equals("guardar")) {
                estado = ClienteCTRL1.saveCliente(clienteDTO1);

                clienteDTO1 = ClienteCTRL1.getClienteDTO(request.getParameter("documento"));

                out.println("<table boder='1' id='tabla' class='table table-hover table-success' > ");
                out.println("<tr class='bg-light'>"
                        + "<th>Documento</th>"
                        + "<th>Nombres</th>"
                        + "<th>Apellidos</th>"
                        + "<th>Telefono</th>"
                        + "<th>Correo</th>"
                        + "<th>Direccion</th>"
                        + "<th>Departamento</th>"
                        + "<th>Municipio</th>"
                        + "</tr>");

                out.println("<tr>"
                        + "<td>" + clienteDTO1.getDocumento() + "</td>"
                        + "<td>" + clienteDTO1.getNombres() + "</td>"
                        + "<td>" + clienteDTO1.getApellidos() + "</td>"
                        + "<td>" + clienteDTO1.getTelefono() + "</td>"
                        + "<td>" + clienteDTO1.getCorreo() + "</td>"
                        + "<td>" + clienteDTO1.getDireccion() + "</td>"
                        + "<td>" + clienteDTO1.getDepartamento() + "</td>"
                        + "<td>" + clienteDTO1.getMunicipio() + "</td>"
                        + "<tr>");

                out.println("</table>");

            } else if (boton.equals("eliminar")) {
                estado = ClienteCTRL1.eliminarCliente(clienteDTO1);//

            }else if (boton.equals("actualizar")) {
                estado = ClienteCTRL1.actualizarCliente(clienteDTO1);

            } else if (boton.equals("mostrar")) {
                clienteDTO1 = ClienteCTRL1.getClienteDTO(request.getParameter("documento"));

                out.println("<table boder='1' id='tabla' class='table table-hover table-success' > ");
                out.println("<tr class='bg-light'>"
                        + "<th>Documento</th>"
                        + "<th>Nombres</th>"
                        + "<th>Apellidos</th>"
                        + "<th>Telefono</th>"
                        + "<th>Correo</th>"
                        + "<th>Direccion</th>"
                        + "<th>Departamento</th>"
                        + "<th>Municipio</th>"
                        + "</tr>");

                out.println("<tr>"
                        + "<td>" + clienteDTO1.getDocumento() + "</td>"
                        + "<td>" + clienteDTO1.getNombres() + "</td>"
                        + "<td>" + clienteDTO1.getApellidos() + "</td>"
                        + "<td>" + clienteDTO1.getTelefono() + "</td>"
                        + "<td>" + clienteDTO1.getCorreo() + "</td>"
                        + "<td>" + clienteDTO1.getDireccion() + "</td>"
                        + "<td>" + clienteDTO1.getDepartamento() + "</td>"
                        + "<td>" + clienteDTO1.getMunicipio() + "</td>"
                        + "<tr>");

                out.println("</table>");
                estado = true;
            } else if (boton.equals("mostrarTODO")) {
                try {
                    List<ClienteDTO> ListaClienteDTO1 = ClienteCTRL1.getClienteDTO();

                    out.println("<table boder='1' id='tabla' class='table table-hover table-success' > ");
                    out.println("<tr class='bg-light'>"
                            + "<th>Documento</th>"
                            + "<th>Nombres</th>"
                            + "<th>Apellidos</th>"
                            + "<th>Telefono</th>"
                            + "<th>Correo</th>"
                            + "<th>Direccion</th>"
                            + "<th>Departamento</th>"
                            + "<th>Municipio</th>"
                            + "</tr>");
                    for (int i = 0; i < ListaClienteDTO1.size(); i++) {
                        out.println("<tr>"
                                + "<td>" + ListaClienteDTO1.get(i).getDocumento() + "</td>"
                                + "<td>" + ListaClienteDTO1.get(i).getNombres() + "</td>"
                                + "<td>" + ListaClienteDTO1.get(i).getApellidos() + "</td>"
                                + "<td>" + ListaClienteDTO1.get(i).getTelefono() + "</td>"
                                + "<td>" + ListaClienteDTO1.get(i).getCorreo() + "</td>"
                                + "<td>" + ListaClienteDTO1.get(i).getDireccion() + "</td>"
                                + "<td>" + ListaClienteDTO1.get(i).getDepartamento() + "</td>"
                                + "<td>" + ListaClienteDTO1.get(i).getMunicipio() + "</td>"
                                + "<tr>"
                        );
                    }
                    out.println("</table>");

                } catch (Exception ex) {

                    System.out.println("Error:" + ex.toString());

                }

            }

            estado = true;

            if (estado) {

                out.println("<h1>Operacion realizada ! </h1>");

            } else {

                out.println("<h1>Problema de conexión</h1>");

            }

        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
