import javax.swing.*;
import java.awt.*;

public class SceneManager {
    private JFrame jFrame;
    public SceneManager(JFrame jFrame){
        this.jFrame = jFrame;
    }

    public JFrame getScreen() {
        return jFrame;
    }

    public Component[] getCurrentComponent(){
        return jFrame.getComponents();
    }

    @Override
    public String toString() {
        return "SceneManager{" +
                "jFrame=" + jFrame +
                '}';
    }
}
