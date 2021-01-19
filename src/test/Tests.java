package test;

import game.Nonogram;
import game.NonogramBoard;
import game.NonogramList;
import org.junit.*;

import javax.swing.*;
import java.awt.*;

public class Tests {

    NonogramList nonogramList;
    String str;
    @Before
    public void setUp1() throws Exception {
        System.out.println("Setting up1!");
        str = "1110001110001110001100001";

        nonogramList = new NonogramList();
    }
    //Test sprawdza poprawnosc zamiany na przyciski
    @Test
    public void testChangeToNumbers(){
        int[][] actual = nonogramList.testChangeToNumbers(str);
        int[][] expected = {
                {0, 0, 0, 1, 2, 3, 3, 3},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {3, 0, 0, 1, 1, 1, 0, 0},
                {3, 0, 0, 0, 1, 1, 1, 0},
                {3, 0, 0, 0, 0, 1, 1, 1},
                {2, 0, 0, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 1}
        };
        Assert.assertArrayEquals(expected, actual);

    }

    Nonogram nonogram;
    @Before
    public void setUp2() throws Exception {
        System.out.println("Setting up2!");
        NonogramList nonogramList = new NonogramList();
        nonogram = nonogramList.getFirst();
    }

    //Test sprawdza poprawnosc wczytania z pliku
    @Test
    public void testLoadNonogram(){
        System.out.println("Running testLoadNonogram!");

        Nonogram testNonogram = new Nonogram();
        int[][] clickedButton = {
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        testNonogram.setClickedButton(clickedButton);
        int[][] numbers = {
                {0, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {5, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        testNonogram.setNumbers(numbers);

        Assert.assertArrayEquals(testNonogram.getClickedButton(), nonogram.getClickedButton());
        Assert.assertArrayEquals(testNonogram.getNumbers(), nonogram.getNumbers());
    }

    @After
    public void tearDown2() throws Exception {
        System.out.println("Running: tearDown!");
        nonogram = null;
        Assert.assertNull(nonogram);
    }

    @Test
    public void testColorButton(){
        JButton button = new JButton();
        button.setBackground(Color.white);
        new NonogramBoard(new JPanel(), false).colorButton(button);

        Assert.assertEquals(Color.black, button.getBackground());
    }



}