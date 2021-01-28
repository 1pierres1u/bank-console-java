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
 void executeUpdate(String query)
 {
   try
   { stmt.executeUpdate(query); 
   }
   catch(Exception e)
   { 
     System.out.println(e);
   }
 }
 String insert(String[] data,String table)
 { String query="insert into ";
   query += table+"(";
   int L = data.length/2;
   int i=1;
   query += data[0];
   for(; i<L; i++)
   { query += ","+data[i];
   }
   query += ")values('"+ data[i];
   i++;
   for(;i<data.length; i++)
   {query+="','"+data[i];
   }
   query += "')";
   return query;
 }
}

class Form
{
 Form(){}
 String[] read(String[] format)
 { String[] values = new String[format.length*2];
   int i=0;
   for(String v:format)
   { values[i]=to_snake_case(v);
     i++;
   }
   i=format.length;
   System.out.println("PLZ ENTER");
   Scanner scanner = new Scanner(System.in);
   for(String v:format)
   { System.out.print(format[i-format.length]+":");
     values[i] = scanner.nextLine();
     i=i+1;
   }
   return values;
 }
 String to_snake_case(String s)
 { return s.trim().toLowerCase().replaceAll("\\s+","_");
 }
}

public class BankDatabaseExample
{
  void example_1()
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
  public static void example_2()
  {  try
     {
     BankDatabase bd = new BankDatabase();
     bd.create_connection();
     Form F = new Form();
     String[] data = {"state","city","town","street","apartment no","zipcode"};
     String query = bd.insert(F.read(data),"address");
     System.out.println(query);
     bd.executeUpdate(query);
     }
     catch(Exception e)
     { 
       System.out.println(e);
     }
  }
  public static void main(String[] args)
  { example_2();
  }
}


