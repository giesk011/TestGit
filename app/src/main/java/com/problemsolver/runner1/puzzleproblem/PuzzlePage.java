package com.problemsolver.runner1.puzzleproblem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import static android.R.attr.id;

public class PuzzlePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_page);
        cState = new State();
        grid = (GridLayout) findViewById(R.id.gridmoves);
        message1 = (TextView) findViewById(R.id.message);

        buttonList = new Button[]{(Button) findViewById(R.id.button1), (Button) findViewById(R.id.button2),
                (Button) findViewById(R.id.button3), (Button) findViewById(R.id.button4),
                (Button) findViewById(R.id.button5), (Button) findViewById(R.id.button6),
                (Button) findViewById(R.id.button7), (Button) findViewById(R.id.button8)};
        message1.setText("");
        cState.reset();
        for(int i = 0; i < 8; i++){
            moveButton(buttonList[i], i + 1);
        }

    }
    public void clickButton1(View view) {
        if(moveButtonHelper(1))
            moveButton((Button) findViewById(R.id.button1), 1);
    }

    public void clickButton2(View view) {
        if(moveButtonHelper(2))
            moveButton((Button) findViewById(R.id.button2), 2);
    }

    public void clickButton3(View view) {
        if(moveButtonHelper(3))
            moveButton((Button) findViewById(R.id.button3), 3);
    }

    public void clickButton4(View view) {
        if(moveButtonHelper(4))
            moveButton((Button) findViewById(R.id.button4), 4);
    }

    public void clickButton5(View view) {
        if(moveButtonHelper(5))
            moveButton((Button) findViewById(R.id.button5), 5);
    }

    public void clickButton6(View view) {
        if(moveButtonHelper(6))
            moveButton((Button) findViewById(R.id.button6), 6);
    }

    public void clickButton7(View view) {
        if(moveButtonHelper(7))
            moveButton((Button) findViewById(R.id.button7), 7);
    }

    public void clickButton8(View view) {
        if(moveButtonHelper(8))
            moveButton((Button) findViewById(R.id.button8), 8);
    }

    public void clickReset(View view) {
        message1.setText("");
        cState.reset();
        for(int i = 0; i < 8; i++){
            moveButton(buttonList[i], i + 1);
        }
    }

    public void moveButton(Button b, int tile){
        int row = cState.getLocatoin(tile).getRow();
        int col = cState.getLocatoin(tile).getCol();
        b.setMinimumHeight(210);
        b.setMaxWidth(180);
        b.setLayoutParams(new GridLayout.LayoutParams(grid.spec(row), grid.spec(col)));
    }

    public boolean moveButtonHelper(int tile) {
        message1.setText("");
        boolean works = cState.canDo(tile);
        if(!works) {
            //illegal move message
            message1.setText("Illegal Move");

        }
        if(cState.checkGoal()) {
            // Goal reached message
            message1.setText("Congradulations! You Finished the Puzzle!");
        }
        return works;
    }

    /*EditText editText = (EditText) findViewById(R.id.editText);
    String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        @+id/button1
        */

    //instanace fields
    private State cState;
    private GridLayout grid;
    private Button[] buttonList;
    private TextView message1;

}
