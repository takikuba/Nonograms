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

class MenuScreen extends JPanel {
    JButton buttonStartGame;
    JButton buttonCreateNew;
    JButton buttonExit;

    public MenuScreen(SceneManager sceneManager){
        setBounds(0,0,300, 400);
        setBackground(Color.GRAY);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        add(new JLabel("<html><h1><strong><i>Nonogramy</i></strong></h1><hr></html>"), gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        buttonStartGame = new JButton("New Game");
        buttonStartGame.addActionListener((e) -> {
            sceneManager.getScreen().remove(this);
            sceneManager.getScreen().add(new GameNewGame(sceneManager));
            sceneManager.getScreen().revalidate();
            sceneManager.getScreen().repaint();

        });
        buttonStartGame.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonCreateNew = new JButton("Create");
        buttonCreateNew.addActionListener((e) -> {
            sceneManager.getScreen().remove(this);
            sceneManager.getScreen().add(new GameCreateNew());
            sceneManager.getScreen().revalidate();
            sceneManager.getScreen().repaint();
        });
        buttonCreateNew.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonExit = new JButton("Exit");
        buttonExit.addActionListener((e) -> {
            System.exit(0);
        });
        buttonExit.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.setBackground(this.getBackground());
        buttons.add(buttonStartGame, gbc);
        buttons.add(buttonCreateNew, gbc);
        buttons.add(buttonExit);

        gbc.weighty = 1;
        add(buttons, gbc);
    }

}
