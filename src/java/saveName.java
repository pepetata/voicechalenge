// Import required java libraries

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

// Extend HttpServlet class
public class saveName extends HttpServlet {

    // Method to handle GET method request.
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String company = request.getParameter("company");
        String phone = request.getParameter("phone");
        PrintWriter out = response.getWriter();

        // Set response content type
        response.setContentType("text/html");
        out.println(name);

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=VLDemo";
            Connection conn = DriverManager.getConnection(url, "sa", "sa");
            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("select TOP 1 * from sel_containers where (name is null OR name = '') AND flag is null");
            if (! rs.next()) {
                out.println("no");
            } else {
                String containerId = rs.getString("containerId");
                String sql = "UPDATE sel_containers SET name = ?, company = ?, phone = ? WHERE containerId = ?";
            System.err.println("container id = " + containerId + " name =" + name + " company= "+company );

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.setString(2, company);
                pstmt.setString(3, phone);
                pstmt.setString(4, containerId);
                pstmt.executeUpdate();
                out.println("yes");
            }
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
