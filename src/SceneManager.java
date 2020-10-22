import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;

public class SceneManager {
    private JFrame jFrame;
    public SceneManager(JFrame jFrame){
        this.jFrame = jFrame;
    }

    public JFrame getScreen() {
        return jFrame;
    }

    public Component getCurrentComponent(){
        return jFrame.getComponents()[0];
    }

    public void setNewComponent(JComponent component) {

        jFrame.getContentPane().removeAll();
        jFrame.getContentPane().add(component);
        jFrame.revalidate();
        jFrame.repaint();
    }

    @Override
    public String toString() {
        return "SceneManager{" +
                "jFrame=" + jFrame +
                '}';
    }
}
