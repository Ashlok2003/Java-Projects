import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    GamePanel panel;

    GameFrame() {
        panel = new GamePanel();
        this.add(panel);
        this.setLayout(new FlowLayout());
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.pack();
    }
}
