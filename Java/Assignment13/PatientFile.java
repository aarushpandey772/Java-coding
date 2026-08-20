package Practical.Assignment13;

import java.io.*;

public class PatientFile {
    public static void main(String[] args) {
        try {
            // Writing patient details to file
            FileWriter fw = new FileWriter("patient.txt");
            fw.write("Patient ID: P101\n");
            fw.write("Name: Rahul\n");
            fw.write("Age: 25\n");
            fw.write("Diagnosis: Fever\n");
            fw.close();

            System.out.println("Patient details written successfully.\n");

            // Reading patient details from file
            FileReader fr = new FileReader("patient.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("Patient Details:");
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