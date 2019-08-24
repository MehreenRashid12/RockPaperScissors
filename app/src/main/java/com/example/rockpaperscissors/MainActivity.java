package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView round_text,player_score_text,computer_score_text;
    ImageView player_choice,computer_choice;
    Button rock_button,paper_button,scissors_button;

    int player_score=0,computer_score=0,round=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rock_button = (Button) findViewById(R.id.rock_button);
        paper_button = (Button) findViewById(R.id.paper_button);
        scissors_button = (Button) findViewById(R.id.scissors_button);

        player_choice = (ImageView) findViewById(R.id.player_choice);
        computer_choice = (ImageView) findViewById(R.id.computer_choice);

        player_score_text = (TextView) findViewById(R.id.player_score_text);
        computer_score_text = (TextView) findViewById(R.id.computer_score_text);
        round_text = (TextView) findViewById(R.id.round_text);

        round_text.setText("Round "+round);
        player_score_text.setText("You: "+player_score);
        computer_score_text.setText("Computer: "+computer_score);

        rock_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player_choice.setImageResource(R.drawable.rock);
                compare("Rock");
            }
        });

        paper_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player_choice.setImageResource(R.drawable.paper);
                compare("Paper");
            }
        });

        scissors_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player_choice.setImageResource(R.drawable.scissors);
                compare("Scissors");
            }
        });



    }

    String computerChoice(){
        Random rand = new Random();
        int n = rand.nextInt(3)+1;
        String cchoice = null;

        if(n==1){
            computer_choice.setImageResource(R.drawable.crock);
            cchoice = "Rock";
        }

        if(n==2){
            computer_choice.setImageResource(R.drawable.cpaper);
            cchoice = "Paper";
        }

        if(n==3){
            computer_choice.setImageResource(R.drawable.cscissors);
            cchoice = "Scissors";
        }
        return cchoice;
    }


    void compare(String pchoice){
        String cchoice = computerChoice();
        round++;
        round_text.setText("Round "+round);
        if(cchoice == pchoice){
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
        }
        else if(cchoice == "Rock" && pchoice=="Paper"){
            player_score++;
            Toast.makeText(this, "You win", Toast.LENGTH_SHORT).show();
        }
        else if(cchoice == "Paper" && pchoice=="Rock"){
            computer_score++;
            Toast.makeText(this, "Computer wins", Toast.LENGTH_SHORT).show();
        }
        else if(cchoice == "Scissors" && pchoice=="Rock"){
            player_score++;
            Toast.makeText(this, "You win", Toast.LENGTH_SHORT).show();
        }
        else if(cchoice == "Rock" && pchoice=="Scissors"){
            computer_score++;
            Toast.makeText(this, "Computer wins", Toast.LENGTH_SHORT).show();
        }
        else if(cchoice == "Paper" && pchoice=="Scissors"){
            player_score++;
            Toast.makeText(this, "You win", Toast.LENGTH_SHORT).show();
        }
        else if(cchoice == "Scissors" && pchoice=="Paper"){
            computer_score++;
            Toast.makeText(this, "Computer wins", Toast.LENGTH_SHORT).show();
        }

        player_score_text.setText("You: "+player_score);
        computer_score_text.setText("Computer: "+computer_score);
    }

}
