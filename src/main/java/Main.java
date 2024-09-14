// Main.java
import controller.GradeController;
import model.GradeCalculator;
import view.NewJFrame;

public class Main {
    public static void main(String[] args) {
        // สร้าง View และ Model
        NewJFrame view = new NewJFrame();
        GradeCalculator model = new GradeCalculator();

        // สร้าง Controller และเชื่อม Model กับ View
        GradeController controller = new GradeController(model, view);

        // แสดง UI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                view.setVisible(true);
            }
        });
    }
}