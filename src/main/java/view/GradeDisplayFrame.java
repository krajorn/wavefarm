// GradeDisplayFrame.java (View)
package view;

import javax.swing.*;
import java.awt.*;

public class GradeDisplayFrame extends JFrame {

    private JLabel gradeLabel;

    public GradeDisplayFrame(String grade) {
        initComponents(grade);
    }

    private void initComponents(String grade) {
        // ตั้งค่า JFrame
        setTitle("Your Grade");

        // ดึงขนาดของหน้าจอ
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width / 2;  // กำหนดความกว้างเป็นครึ่งหนึ่งของจอ
        int height = screenSize.height / 2;  // กำหนดความสูงเป็นครึ่งหนึ่งของจอ
        setSize(width, height);  // ตั้งค่าขนาดของหน้าต่างเป็นครึ่งหนึ่งของหน้าจอ

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // สร้าง JLabel สำหรับแสดงเกรด
        gradeLabel = new JLabel("Your grade is: " + grade, SwingConstants.CENTER);
        gradeLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 48));  // ตั้งขนาดฟอนต์ใหญ่
        gradeLabel.setForeground(Color.PINK);                          // ตั้งสีเป็นสีชมพู

        // เพิ่ม JLabel ลงใน JFrame
        add(gradeLabel);

        // จัดหน้าต่างให้อยู่ตรงกลางของหน้าจอ
        setLocationRelativeTo(null);
    }
}