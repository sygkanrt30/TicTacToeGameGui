package pet_project.game.tictactoegamewindowmenu2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TicTacToeController {

    private char currentSymbol = 'x';

    private final char[][] field = new char[3][3];

    private boolean isGame = true;

    @FXML
    private Label winLabel;

    @FXML
    void btnClick(ActionEvent event) {
        if (!isGame) return;
        Button button = (Button) event.getSource();
        int rowIndex = GridPane.getRowIndex(button) == null ? 0 : GridPane.getRowIndex(button);
        int colIndex = GridPane.getColumnIndex(button) == null ? 0 : GridPane.getColumnIndex(button);
        field[rowIndex][colIndex] = currentSymbol;
        button.setText(String.valueOf(currentSymbol));
        if (isWin()) {
            if (currentSymbol == 'x') {
                winLabel.setText("Победил игрок 1!!!");
            } else {
                winLabel.setText("Победил игрок 2!!!");
            }
            isGame = false;
        } else if (isFull()) {
            winLabel.setText("Ничья!!!");

        }
        currentSymbol = currentSymbol == 'x' ? 'o' : 'x';


    }

    public boolean isFull() {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == 'x' || field[i][j] == 'o') {
                    k++;
                }
            }
        }
        return k == 9;
    }

    public boolean isWin() {
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == field[i][1] && field[i][0] == field[i][2] && (field[i][0] == 'x' || field[i][0] == 'o')) {
                return true;
            }
            if (field[0][i] == field[1][i] && field[0][i] == field[2][i] && (field[0][i] == 'x' || field[0][i] == 'o')) {
                return true;
            }
        }
        return (field[0][0] == field[1][1] && field[0][0] == field[2][2] && (field[0][0] == 'x' || field[0][0] == 'o')) ||
                (field[0][2] == field[1][1] && field[0][2] == field[2][0] && (field[0][2] == 'x' || field[0][2] == 'o'));
    }
}


