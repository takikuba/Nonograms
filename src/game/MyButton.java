package game;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MyButton extends JButton {

    private Color focusColor = Color.lightGray;

    public MyButton(String text) {
        super(text);
        setFont(new Font("Hobo Std", Font.BOLD, 25));
        setter();
    }

    public MyButton(String text, int size){
        super(text);
        setFont(new Font("Hobo Std", Font.BOLD, size));
        setter();
    }

    private void setter(){
        setForeground(Color.DARK_GRAY);
        setBorderPainted(false);
        setBorder(null);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        setBackground(new Color(1, 1, 1, 0));
        addMouseListener(new RolloverListener());
    }

    public void setFocusColor(Color focusColor) {
        this.focusColor = focusColor;
    }

    public Color getFocusColor() {
        return focusColor;
    }

    private final class RolloverListener extends MouseInputAdapter {

        private Color origColor;

        public void mouseEntered(MouseEvent e) {
            origColor = getForeground();
            setForeground(focusColor);
        }

        public void mouseExited(MouseEvent e) {
            if (getForeground() == focusColor) {
                setForeground(origColor);
            }
        }
    }
}

class ButtonBack extends JButton{
    public ButtonBack(SceneManager sceneManager){
        super(new ImageIcon("res\\buttonBack.png"));
        this.setBounds(10, 10, 30, 30);
        setBorderPainted(false);
        setBorder(null);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        this.addActionListener((e) ->sceneManager.setNewComponent(new MenuScreen(sceneManager)));
    }
}