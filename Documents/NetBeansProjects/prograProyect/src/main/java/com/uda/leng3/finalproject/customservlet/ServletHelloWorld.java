
package com.uda.leng3.finalproject.customservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.jms.*;


public class ServletHelloWorld extends HttpServlet {
    
    
        @Resource(lookup = "java:jboss/jms/ExampleQueueConnectionFactory")
        ConnectionFactory connectionFactory;

        @Resource(lookup = "java:jboss/jms/ExampleQueue")
        Destination destination;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletHelloWorld</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletHelloWorld at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        PrintWriter writer = response.getWriter();

        try {
            //Authentication info can be omitted if we are using in-vm
            QueueConnection connection = (QueueConnection)
              connectionFactory.createConnection();

            try {
                QueueSession session =
                  connection.createQueueSession(
                    false,
                    Session.AUTO_ACKNOWLEDGE
                  );

                try {
                    MessageProducer producer =
                      session.createProducer(destination);

                    try {
                        TextMessage message =
                          session.createTextMessage(
                            "Hello, world! ^__^"
                          );

                        producer.send(message);

                        writer.println(
                          "Message sent! ^__^"
                        );
                    } finally {
                        producer.close();
                    }
                } finally {
                    session.close();
                }

            } finally {
                connection.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace(writer);
        }


        response.setContentType("text/plain");
        response.getWriter().println("Please use the form to POST to this url");
//        processRequest(request, response);
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
        String name = request.getParameter("name");
        response.setContentType("text/plain");
        if (name == null) {
            response.getWriter().println("Please enter a name");
        }
        response.getWriter().println("Hello Leng III Student " + name);
//        processRequest(request, response);
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
