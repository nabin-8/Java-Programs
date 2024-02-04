package scannerandbufferreaderinputbw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ScannerAndBufferReaderInputBW {
    
    static void scannerInput()
    {
        Scanner input = new Scanner(System.in);
        int roll;
        String name;
        int age;
        //Input
        System.out.println("Enter the roll number: ");
        roll = Integer.parseInt(input.nextLine());
        //input.nextLine(); //Put in middle of int and string input
        System.out.println("Enter the name: ");
        name = input.nextLine();
        System.out.println("Enter the age: ");
        age = input.nextInt();
        //Output
        System.out.println("Roll no: "+roll);
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
    }
    
    static void bufferedReaderInput() throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int roll;
        String name;
        int age;
        System.out.println("Calling BufferedReader to input.....");
        //Input
        System.out.println("Enter the roll number: ");
        roll = Integer.parseInt(input.readLine());
        //input.nextLine(); //Put in middle of int and string input
        System.out.println("Enter the name: ");
        name = input.readLine();
        System.out.println("Enter the age: ");
        age = Integer.parseInt(input.readLine());
        //Output
        System.out.println("Roll no: "+roll);
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
    }
    
    public static void main(String[] args) {
        //scannerInput();
        try {
            bufferedReaderInput();
        } catch (IOException e) {
            System.out.println(e);
        }
        
    } 
}
