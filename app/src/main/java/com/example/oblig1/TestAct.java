package com.example.oblig1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class TestAct extends AppCompatActivity {

    private EditText sb_ans;
    private Button sb_submit;
    private TextView sb_score;
    private ImageView imgView;
    private String correctAnswer;
    private ArrayList<Image> quiz;
    int score = 0;
    int total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imgView = findViewById(R.id.quizImageView);
        //imgView.setImageResource(((GlobalStorage) this.getApplication()).getImages().get(2).getId());

        sb_ans = findViewById(R.id.submitText);
        sb_score = findViewById(R.id.tv_scoreText);
       sb_submit = findViewById(R.id.submitAnswer);

        initView();

    }

    private void initView(){
        setupList();
        sb_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("ANSWER GIVEN WAS: " + sb_ans.getText().toString());
                if (isCorrect(sb_ans.getText().toString(), correctAnswer)){
                    score++;
                    total++;
                    Toast.makeText(getApplicationContext(),"Correct!",Toast.LENGTH_SHORT).show();
                    sb_score.setText(score + "/" + total);
                    sb_ans.getText().clear();
                    setupList();

                }else {
                    total++;
                    sb_score.setText(score + "/" + total);
                    Toast.makeText(getApplicationContext(), "Incorrect! \nThe correct answer is: " + correctAnswer, Toast.LENGTH_LONG).show();
                    sb_ans.getText().clear();
                }
            }
        });

    }
    public void setupList(){
        Random r = new Random();
        quiz = ((GlobalStorage) this.getApplication()).getImages();
        int next = r.nextInt(quiz.size());
        quiz.remove(next); //Probably?
        imgView.setImageURI(quiz.get(next).getId());
        correctAnswer = quiz.get(next).getName();
    }
    public void updateImage(){

    }


    public boolean isCorrect(String a, String c){
        return a.trim().equalsIgnoreCase(c.trim());
    }

}
