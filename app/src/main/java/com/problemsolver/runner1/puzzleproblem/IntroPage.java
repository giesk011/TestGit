package com.problemsolver.runner1.puzzleproblem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class IntroPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);
    }

    /** Called when the user taps the start button */
    public void startPuzzle(View view) {
        Intent intent = new Intent(this, PuzzlePage.class);
        startActivity(intent);
    }

}
