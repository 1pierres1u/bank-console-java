import java.util.*;
import java.util.Scanner;

class Form
{
 Form(){}
 String[] read(String[] format)
 { String[] values = new String[format.length*2];
   Scanner scanner = new Scanner(System.in);
   int i=0;
   for(String v:format)
   { values[i]=v;
     i++;
   }
   i=0;
   int N = format.length;
   System.out.println("PLZ ENTER");
   for(String v:format)
   { System.out.print(format[i]+": ");
     values[N+i] = scanner.nextLine();
     i=i+1;
   }
   return values;
 }
}
public class FormExample
{
 public static void main(String[] args)
 { Form ReadUser = new Form();
   String[] userInfo = {"first name","middle name","last name"};
   
   ReadUser.read(userInfo);
 }
}
