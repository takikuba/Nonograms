import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Screen extends JFrame {

    public static void main(String[] args) {
        new Screen();
    }

    public Screen(){
        SceneManager sceneManager = new SceneManager(this);
        setTitle("Nonogramy by. Jakub Klimek");

        getContentPane().add(new MenuScreen(sceneManager));

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(300, 400);
        setVisible(true);
    }
}