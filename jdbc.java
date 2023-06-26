import java.sql.*;
import java.util.Scanner;

class jdbc
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        int choice,run=1;

        //Connecting to Database
        try
        {
            String username = "root";
            String password = "223344";
            String dbURL = "jdbc:mysql://localhost:3306/sampledb";
            try
            {
                Connection conn = DriverManager.getConnection(dbURL, username, password);
                AddData C = new AddData(conn);
                ReadData R = new ReadData(conn);
                UpdateData U = new UpdateData(conn);
                DeleteData D = new DeleteData(conn);
                if (conn != null)
                {
                    System.out.println("Connected Successfully");
                }
                do
                {
                    //Menu
                    System.out.println("[1] Add Data\n[2] Delete Data\n[3] Update Data\n[4] Read Data\n");
                    choice = in.nextInt();

                    if(choice==1)
                    {
                        C.Create();
                    }
                    else if(choice==2)
                    {
                        D.Delete();
                    }
                    else if(choice==3)
                    {
                        U.Update();
                    }
                    else if(choice==4)
                    {
                        R.Read();
                    }
                    else
                    {
                        System.out.println("--------------");
                        System.out.println("Invalid Option");
                        System.out.println("--------------");
                    }
                    System.out.println("[1] Return\n[2] Exit\n");
                    run = in.nextInt();
                } while(run!=2);

            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
