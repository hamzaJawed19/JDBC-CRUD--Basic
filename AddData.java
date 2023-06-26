import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddData
{

    private Connection status;
   private String uname,pass,fulln,email;
    public AddData(Connection conn) throws SQLException
    {
       this.status = conn;

    }
    public void Create() throws SQLException {
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);

        //Running SQL Query
        String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = status.prepareStatement(sql);

        System.out.println("Enter Username: ");
        this.uname = in.next();
        System.out.println("Enter Password: ");
        this.pass = in.next();
        System.out.println("Enter Full Name: ");
        this.fulln = in2.nextLine();
        System.out.println("Enter Email: ");
        this.email = in.next();

        statement.setString(1, this.uname);
        statement.setString(2, this.pass);
        statement.setString(3, this.fulln);
        statement.setString(4, this.email);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0)
        {
            System.out.println("-------------------------------------");
            System.out.println("A new user was inserted successfully!");
            System.out.println("-------------------------------------");

        }

    }
}
