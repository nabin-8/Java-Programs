package file2021;

import java.io.*;
import java.util.Scanner;

public class File2021 {
    
    static void writeToFile()
    {
        Scanner scanner = new Scanner(System.in);
        try (FileWriter writer = new FileWriter("student.txt")) {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Enter details for student " + i + ":");
                System.out.print("Roll: ");
                int roll = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Address: ");
                String address = scanner.nextLine();
                System.out.print("College: ");
                String college = scanner.nextLine();

                writer.write(roll + "," + name + "," + address + "," + college + "\n");
            }

            System.out.println("Student information written to student.txt");
            scanner.close();
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        scanner.close();
    }
    
    static void readFromFile()
    {
        try {
            FileReader fr = new FileReader("student.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            System.out.println("Students from Jhapa:::: ");
            System.out.println("Roll \t Name \t Address \t College");
            while((line=br.readLine())!= null)
            {
                //System.out.println(line);
                String[] parts = line.split(",");
                //if(parts.length>=4)
                //{
                    int roll = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String address = parts[2];
                    String college = parts[3];
                    
                    if(address.equals("Jhapa"))
                    {
                        System.out.println(roll +"\t"+name+"\t"+address+"\t\t"+college); 
                    }
                
                //}
            } 
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
    }
    public static void main(String[] args) {
        
        readFromFile();
    }
}
