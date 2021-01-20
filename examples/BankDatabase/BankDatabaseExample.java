import java.io.Console;
import java.sql.*;
import java.util.Scanner;

class BankDatabase
{
 Connection con;
 Statement  stmt;
 
 BankDatabase(){}
 void create_connection()
 {
   String c = "jdbc:mysql://";
   Scanner scanner = new Scanner(System.in);
   String port,dbName,username,ipHost;
   System.out.println("CONNECTING TO THE DATABASE");
   System.out.println("ENTER");
   System.out.print("ip host: ");
   ipHost = scanner.nextLine();
   System.out.print("port no: ");
   port=scanner.nextLine();
   System.out.print("database name: ");
   dbName=scanner.nextLine();
   System.out.print("username: ");
   username=scanner.nextLine();
   System.out.print("password: ");
   char[] password=System.console().readPassword();
   c = c + ipHost + ":" + port + "/" + dbName+"?useSSL=true";
   try
   {
   Class.forName("com.mysql.jdbc.Driver");
   con = DriverManager.getConnection(c,username,new String(password)); 
   stmt = con.createStatement();
   }
   catch(Exception e)
   { System.out.println(e);
   }
 }
 ResultSet execute(String query)
 { ResultSet rs = null;
   try
   { rs = stmt.executeQuery(query); 
   }
   catch(Exception e)
   { 
     System.out.println(e);
   }
   return rs;
 }
}

public class BankDatabaseExample
{
  public static void main(String[] args)
  {  try
     {
     BankDatabase bd = new BankDatabase();
     bd.create_connection();
     ResultSet rs = bd.execute("select count(*) from t1");
     while(rs.next())
      System.out.println("Number of records: " + rs.getInt(1));
     }
     catch(Exception e)
     { 
       System.out.println(e);
     }
  }
}


