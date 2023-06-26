import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData
{
   private Connection status;
   private String uname;
    public DeleteData(Connection conn) throws SQLException
    {
        this.status=conn;

    }

    public void Delete() throws SQLException
    {
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        //Deleting Data
        String sql = "DELETE FROM Users WHERE username=?";   //Running SQL Query

        PreparedStatement statement = status.prepareStatement(sql);
        System.out.println("Enter User Name you want to delete: ");
        this.uname = in2.nextLine();

        statement.setString(1, this.uname);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0)
        {
            System.out.println("--------------------------------");
            System.out.println("A user was deleted successfully!");
            System.out.println("--------------------------------");
        }
    }
}
