import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData
{
    private Connection status;
    public ReadData(Connection conn) throws SQLException
    {
         this.status=conn;
    }
    public void Read() throws SQLException
    {
        String sql = "SELECT * FROM Users";   //Running SQL Query

        Statement statement = status.createStatement();
        ResultSet result = statement.executeQuery(sql);

        int count = 0;

        while (result.next())
        {
            String name = result.getString(2);
            String pass = result.getString(3);
            String fullname = result.getString("fullname");
            String email = result.getString("email");

            String output = "User #%d: %s - %s - %s - %s";
            System.out.println(String.format(output, ++count, name, pass, fullname, email));
            System.out.println("______________________________________________________________________________");
        }
    }

}


