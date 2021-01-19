package game;

import javax.swing.*;

public class Screen extends JFrame {

    public static void main(String[] args) {

        new Screen();
    }

    public Screen(){
        SceneManager sceneManager = new SceneManager(this);
        setTitle("Nonograms by. Jakub Klimek");

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(300, 400);
        setVisible(true);
        getContentPane().add(new MenuScreen(sceneManager));
    }
}