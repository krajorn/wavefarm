
package model;

public class GradeCalculator {
    
    public String calculateGrade(double gpa) {
        if (gpa >= 80) {
            return "A";
        } else if (gpa >= 70) {
            return "B";
        } else if (gpa >= 60) {
            return "C";
        } else if (gpa >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}