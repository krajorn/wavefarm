// GradeController.java (Controller)
package controller;

import model.GradeCalculator;
import view.GradeDisplayFrame;
import view.NewJFrame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class GradeController {

    private GradeCalculator gradeCalculator;
    private NewJFrame view;

    public GradeController(GradeCalculator gradeCalculator, NewJFrame view) {
        this.gradeCalculator = gradeCalculator;
        this.view = view;
        this.view.addCalculateListener(evt -> calculateGrade());
    }

    public void calculateGrade() {
        try {
            // รับข้อมูลจาก View
            String name = view.getNameInput();
            double gpaValue = Double.parseDouble(view.getGpaInput());
            String grade = gradeCalculator.calculateGrade(gpaValue);
            
            // สร้าง ID ใหม่โดยใช้ UUID
            String id = UUID.randomUUID().toString();
            
            // แสดงผลลัพธ์ในหน้าต่างใหม่
            GradeDisplayFrame gradeFrame = new GradeDisplayFrame(grade);
            gradeFrame.setVisible(true);

            // บันทึกข้อมูลลงในไฟล์ CSV
            saveToCSV(id, name, gpaValue, grade);

        } catch (NumberFormatException e) {
            view.setResultText("Invalid input. Please enter a valid GPA.");
        }
    }

    private void saveToCSV(String id, String name, double gpa, String grade) {
        // ดึงเส้นทางโฟลเดอร์ที่โปรแกรมรันอยู่ (โฟลเดอร์โปรเจกต์)
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current directory: " + currentDir); // พิมพ์เส้นทางปัจจุบันลงใน console

        // สร้างเส้นทางสำหรับโฟลเดอร์ "data" ภายในโปรเจกต์
        String directoryPath = currentDir + "/data";

        // ตรวจสอบและสร้างโฟลเดอร์ "data" ในเส้นทางปัจจุบัน
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            boolean dirCreated = directory.mkdir();  // สร้างโฟลเดอร์ "data"
            if (dirCreated) {
                System.out.println("Directory 'data' created successfully.");
            } else {
                System.out.println("Failed to create directory 'data'.");
            }
        }

        // บันทึกไฟล์ในโฟลเดอร์ "data" ในเส้นทางปัจจุบัน
        try (FileWriter fileWriter = new FileWriter(directoryPath + "/grades.csv", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            // เขียนข้อมูลลงในไฟล์ CSV
            printWriter.printf("%s,%s,%.2f,%s%n", id, name, gpa, grade);
            System.out.println("Data saved to grades.csv");

        } catch (IOException e) {
            System.out.println("Failed to write data to grades.csv");
            e.printStackTrace();
        }
    }
}