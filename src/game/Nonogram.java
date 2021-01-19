package game;

public class Nonogram {

    protected int[][] numbers = new int[8][8];
    protected int[][] clickedButton = new int[5][5];

    public Nonogram(){}

    public int[][] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[][] numbers) {
        this.numbers = numbers;
    }

    public int[][] getClickedButton() {
        return clickedButton;
    }

    public void setClickedButton(int[][] clickedButton) {
        this.clickedButton = clickedButton;
    }
}

class DrawNonogram extends Nonogram{

    public DrawNonogram(){
        Nonogram nonogram = new NonogramList().getRandom();
        this.clickedButton = nonogram.clickedButton;
        this.numbers = nonogram.numbers;
    }

}

