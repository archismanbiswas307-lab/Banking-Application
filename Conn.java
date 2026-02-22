import java.sql.*;


public class Conn {
    Connection c;
    Statement s;

    public Conn(){
        try {
            // Create Connection
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Archis123@#");//Don't do for real world situation 
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
