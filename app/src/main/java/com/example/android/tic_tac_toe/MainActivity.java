package com.example.android.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int ActivePlayer = 0;
        boolean gameActive = true;
    boolean playerwin =true;

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[][] winpos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {2, 5, 8}, {1, 4, 7}, {0, 4, 8}, {2, 4, 6}};


        public void playerTap (View view) {
            if (!gameActive) {

                gameReset(view);

            }

            if (ActivePlayer ==2)
            {

                ActivePlayer = 0;
                gameActive = true;

            }
            ImageView img = (ImageView) view;
            int pos = Integer.parseInt(img.getTag().toString());


            if (gameState[pos] == 2 && gameActive) {
                gameState[pos] = ActivePlayer;
                img.setTranslationY(-1000f);

                if (ActivePlayer == 0) {
                    img.setImageResource(R.drawable.x);
                    ActivePlayer = 1;
                    if(!playerwin) {
                        TextView status = findViewById(R.id.status);
                        status.setText("0's turn : Tap to play!");
                    }

                } else {
                    img.setImageResource(R.drawable.o);
                    ActivePlayer = 0;
                    if (!playerwin) {
                        TextView status = findViewById(R.id.status);
                        status.setText("x's turn : Tap to play!");
                    }
                }
                img.animate().translationYBy(1000f).setDuration(300);
            }
            int counter =0;

                if (gameState[0] == 0) {
                    for (int i=0 ;i<gameState.length ;i++) {
                    if (gameState[i] == 0) {
                        counter++;
                    }

                    if (counter == 5) {
                        gameReset(view);
                        TextView status = (TextView) findViewById(R.id.status);
                        status.setText("It was a Tie! Tap to start a new game!");
                    }
                }
                 if (gameState[0]==1)
                {for (int i=0 ;i<gameState.length ;i++) {
                    if (gameState[i] == 1) {
                        counter++;
                    }

                    if (counter == 5) {
                        gameReset(view);
                        TextView status = (TextView) findViewById(R.id.status);
                        status.setText("It was a Tie! Tap to start a new game!");
                    }}
                }
            }
                if (counter!=5) {
                    for (int[] win : winpos) {
                        if (gameState[win[0]] == gameState[win[1]] && gameState[win[1]] == gameState[win[2]] && gameState[win[0]] != 2) {
                            gameActive = false;

                            if (gameState[win[0]] == 0) {
                                TextView status = findViewById(R.id.status);
                                status.setText("X has won!! Tap to start a new game!");
                            } else if (gameState[win[0]] == 1) {

                                TextView status = findViewById(R.id.status);
                                status.setText("0 has won!! Tap to start a new game!");
                            }

                        }
                    }
                }
        }
            public void gameReset(View view) {
                ActivePlayer = 2;
                playerwin = false;
                for(int i=0; i<gameState.length; i++){
                    gameState[i] = 2;
                }
                ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);


            }










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

