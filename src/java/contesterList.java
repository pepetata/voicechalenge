// Import required java libraries

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

// Extend HttpServlet class
public class contesterList extends HttpServlet {

    // Method to handle GET method request.
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
//	  String title = "Using GET Method to Read Form Data";
//      String docType =
//      "<!doctype html public \"-//w3c//dtd html 4.0 " +
//      "transitional//en\">\n";
        out.println("<table id=\"listTable\" class=\"table table-striped\">\n"
                + "                    <thead><tr>\n"
                + "                        <th>#</th>\n"
                + "                        <th>Nome</th> \n"
                + "                        <th>Empresa</th>\n"
                + "                        <th>Tempo</th>\n"
                + "                    </tr>\n"
                + "</thead>"
                + "<tr>\n");

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=VLDemo";
            Connection conn = DriverManager.getConnection(url, "sa", "sa");
            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT * FROM movimat");
            int i=1;
            while (rs.next()) {
                out.println("<tr>\n"
                        + "<td width=\"5%\">" + i + "</td>\n"
                        + "<td width=\"45%\">" + rs.getString("name") + "</td>\n"
                        + "<td width=\"45%\">" + rs.getString("company") + "</td> \n"
                        + "<td width=\"5%\">" + rs.getString("ptime") + "</td>\n"
                        + "</tr>\n");
                i++;
            }
            out.println("</table>\n");
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            System.err.println(e.toString());
        }

    }
    // Method to handle POST method request.

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
