import javax.swing.*;
import java.awt.*;

public class Nonogram {

    int[][] numbers = new int[8][8];
    int[][] clickedButton = new int[5][5];

    public Nonogram(){

        for( int i = 0; i < 8; i++){
            for( int j = 0; j < 8; j++){
                if(i == 0 || i == 1 || i == 2 || j == 0 || j == 1 || j == 2){
                    numbers[i][j] = 1;
                } else {
                    numbers[i][j] = 0;
                }
            }
        }

        for( int i = 0; i < 5; i++){
            for( int j = 0; j < 5; j++){
                if(i == 0){
                    clickedButton[i][j] = 1;
                } else {
                    clickedButton[i][j] = 0;
                }
            }
        }


    }
}
