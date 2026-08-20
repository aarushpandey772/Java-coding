package Practical.Assignment13;

import java.io.*;

public class EmployeeFile {
    public static void main(String[] args) {
        try {
            // Writing employee details to file
            FileWriter fw = new FileWriter("employee.txt");
            fw.write("Employee ID: 101\n");
            fw.write("Name: Aarush\n");
            fw.write("Department: IT\n");
            fw.write("Salary: 50000\n");
            fw.close();

            System.out.println("Employee details written successfully.\n");

            // Reading employee details from file
            FileReader fr = new FileReader("employee.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("Employee Details:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
