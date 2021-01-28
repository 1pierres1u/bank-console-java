import java.util.Scanner;

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
