import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateData
{
    private Connection status;
    private  String uname,pass,fulln,email;
    public UpdateData(Connection conn) throws SQLException
    {
        this.status = conn;
    }
    public void Update() throws SQLException
    {
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        //Updating Data

        String sql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";  //Running SQL Query

        System.out.println("Enter Username  that you want to update: ");
        this.uname = in.next();
        System.out.println("Enter New Password: ");
        this.pass = in.next();
        System.out.println("Enter New Full Name: ");
        this.fulln = in2.nextLine();
        System.out.println("Enter New Email: ");
        this.email = in.next();

        PreparedStatement statement = status.prepareStatement(sql);
        statement.setString(1, this.pass);
        statement.setString(2, this.fulln);
        statement.setString(3, this.email);
        statement.setString(4, this.uname);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0)
        {
            System.out.println("------------------------------------------");
            System.out.println("An existing user was updated successfully!");
            System.out.println("------------------------------------------");
        }
    }
}


