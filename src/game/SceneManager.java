package game;

import javax.swing.*;

public class SceneManager {

    private JFrame jFrame;

    public SceneManager(JFrame jFrame){
        this.jFrame = jFrame;
    }

    public JFrame getScreen() {
        return jFrame;
    }

    public void setNewComponent(JComponent component) {

        jFrame.getContentPane().removeAll();
        jFrame.getContentPane().add(component);
        jFrame.revalidate();
        jFrame.repaint();

    }

    @Override
    public String toString() {
        return "game.SceneManager{" +
                "jFrame=" + jFrame +
                '}';
    }
}
