package com.example.android.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {

    private TextView clueTextView;
    private Button guessButton;
    private EditText guess;
    private int generatedNumber;
    private int numberOfGuesses = 0;
    private final int MAX_GUESS_COUNT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        clueTextView = findViewById(R.id.clue_textview);
        guessButton = findViewById(R.id.submit_guess_button);
        guess = findViewById(R.id.guess_edittext);

        setListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        generatedNumber = (int) Math.ceil(Math.random() * 100);
    }

    private void setListener() {
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userGuess = Integer.parseInt(guess.getText().toString());
                if (userGuess > 100) {
                    clueTextView.setText("Enter a number between 1 and 100.");
                    clueTextView.setVisibility(View.VISIBLE);
                    guess.setText("");
                } else {
                    checkGuess(userGuess);
                }
            }
        });
    }

    private void checkGuess(int userGuess) {
                                                                    //COPY CODE FROM JAVA VERSION, AND ADJUST
        if (userGuess == generatedNumber) {
            //TODO -- create intent to go to winning activity -- handle winning
        } else if (numberOfGuesses == MAX_GUESS_COUNT) {
            //TODO -- create intent to go to winning activity -- handle out of chaances
        } else if (userGuess < generatedNumber) {
            clueTextView.setText("Higher");
            clueTextView.setVisibility(View.VISIBLE);
            guess.setText("");
            numberOfGuesses++;
        } else if (userGuess > generatedNumber) {
            clueTextView.setText("Lower");
            clueTextView.setVisibility(View.VISIBLE);
            guess.setText("");
            numberOfGuesses++;
        }
    }


    @Override
    public void onBackPressed() {                                   //prevents back button from calling finish()

    }
}
