import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class MenuScreen extends JPanel {
    JButton buttonStartGame;
    JButton buttonCreateNew;
    JButton buttonExit;
    SceneManager sceneManager;

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
        buttonStartGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonStartGame.addActionListener((e) -> {
            sceneManager.setNewComponent(new GameNewGame(sceneManager));
        });

        buttonCreateNew = new JButton("Create");
        buttonCreateNew.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonCreateNew.addActionListener((e) -> {
            sceneManager.setNewComponent(new GameCreateNew(sceneManager));
        });

        buttonExit = new JButton("Exit");
        buttonExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonExit.addActionListener((e) -> System.exit(0));

        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.setBackground(this.getBackground());
        buttons.add(buttonStartGame, gbc);
        buttons.add(buttonCreateNew, gbc);
        buttons.add(buttonExit);

        gbc.weighty = 1;
        add(buttons, gbc);
    }

}
