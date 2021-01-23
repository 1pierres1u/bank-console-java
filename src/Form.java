import java.util.Scanner;

class Form
{
 Form(){}
 String read(String format)
 { String[] values = new String[format.length*2];
   int i=0;
   for(String v:format)
   { values[i]=v;
     i++;
   }
   i=format.length;
   System.out.println("PLZ ENTER");
   for(String v:format)
   { System.out.print(format[i]+":");
     values[i] = scanner.nextLine();
     i=i+1;
   }
   return values;
 }
}
