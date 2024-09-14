// NewJFrame.java (View)
package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class NewJFrame extends javax.swing.JFrame {

    public NewJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();  // ช่องกรอกชื่อ
        gpa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel(); // Label สำหรับแสดงผลลัพธ์

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel1.setText("Enter your name and GPA");

        jButton1.setText("Enter");

        // Layout ของหน้าต่าง
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(nameField)  // ช่องกรอกชื่อ
                    .addComponent(gpa)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)) // Result Label
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)  // ช่องกรอกชื่อ
                .addGap(18, 18, 18)
                .addComponent(gpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE) // Result Label
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }

    // Method สำหรับรับค่า GPA จาก TextField
    public String getGpaInput() {
        return gpa.getText();
    }

    // Method สำหรับรับชื่อจาก TextField
    public String getNameInput() {
        return nameField.getText();
    }

    // Method สำหรับแสดงผลลัพธ์ใน Label
    public void setResultText(String result) {
        resultLabel.setText(result);
    }

    // Method สำหรับเชื่อมต่อกับ Controller (ActionListener ของปุ่ม)
    public void addCalculateListener(ActionListener listener) {
        jButton1.addActionListener(listener);
    }

    // Variables declaration
    private javax.swing.JTextField nameField;  // ตัวแปรใหม่สำหรับช่องกรอกชื่อ
    private javax.swing.JTextField gpa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel resultLabel; // ตัวแปรใหม่สำหรับแสดงผลลัพธ์
    // End of variables declaration
}