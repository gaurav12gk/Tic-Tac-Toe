package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//    0 - x
//    1 - O
int activeplayer=0;
boolean gameactive=true;
int[] gamestate={2,2,2,2,2,2,2,2,2};
int[][] winpos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playerTap(View view) {
        if (!gameactive) {
            gamereset(view);

        }
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if (gamestate[tappedImage] == 2) {
            gamestate[tappedImage] = activeplayer;
            img.setTranslationX(-1000f);
            if (activeplayer == 1) {

                img.setImageResource(R.drawable.o);
                activeplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn");
            } else {img.setImageResource(R.drawable.x);
                activeplayer = 1;

                TextView status = findViewById(R.id.status);
                status.setText("O's turn");
            }
            img.animate().translationXBy(1000f);
        }
        boolean s = false;
        //checking for winning
        for (int[] pos : winpos) {
            if (gamestate[pos[0]] == gamestate[pos[1]] && gamestate[pos[2]] == gamestate[pos[1]] && gamestate[pos[0]] != 2) {
                s = true;
                //someone is winner;
                gameactive = false;
                String win;
                if (gamestate[pos[0]] == 0) {
                    win = "X is winner ";

                } else win = "O is winner";
                //update the status;
                TextView status = findViewById(R.id.status);
                status.setText(win);

            }}
        int a=0;
        for(int i=0;i<9;i++)
        {
            if(gamestate[i]!=2){
                a++;
            }


        }
            if (a==9&&s==false){

                TextView status = findViewById(R.id.status);
                status.setText("Game draw");

                gameactive=false;


            }
        }

public void gamereset(View view)
{
    gameactive=true;
    activeplayer=0;
    TextView status = findViewById(R.id.status);
    status.setText("x-turn to play");
    for(int i=0;i<gamestate.length;i++)
    {
        gamestate[i]=2;
    }
    ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);

    ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);

    ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
}
public void ch(View view)
{
    activeplayer=0;
gameactive=true;
    for(int i=0;i<gamestate.length;i++)
    {
        gamestate[i]=2;
    }
    TextView status = findViewById(R.id.status);
    status.setText("x-turn to play");


    ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}