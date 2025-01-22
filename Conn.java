
package staycation.tourism;

import java.sql.*;
public class Conn {
    
    Connection c;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///staycationtourism", "root","sahajsahaj");
            s = c.createStatement();
                    }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
