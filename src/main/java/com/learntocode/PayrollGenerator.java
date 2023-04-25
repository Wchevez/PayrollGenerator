package com.learntocode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PayrollGenerator {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Usage: java PayrollGenerator <output_file>");
            System.exit(1);
        }

        String outputFile = args[0];
        String inputFileName = "employee_data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
             PrintWriter pw = new PrintWriter(new FileWriter(outputFile))) {

            pw.println("Payroll Report");

            br.readLine();

            String line; 

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\|");

                int employeeId = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                pw.println("Employee ID: " + employee.getEmployeeId());
                pw.println("Name: " + employee.getName());
                pw.println("Gross pay: $" + employee.getGrossPay());
                pw.println();
            }

            pw.flush();
        }
    }
}












