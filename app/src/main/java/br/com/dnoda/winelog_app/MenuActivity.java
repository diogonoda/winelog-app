package br.com.dnoda.winelog_app;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private Button btNewWine, btListWine, btEditWine, btAbout, btExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btNewWine = (Button) findViewById(R.id.btNewWine);
        btListWine = (Button) findViewById(R.id.btListWine);
        btEditWine = (Button) findViewById(R.id.btEditWine);
        btAbout = (Button) findViewById(R.id.btAbout);
        btExit = (Button) findViewById(R.id.btExit);


/*        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/steelworksvintage.ttf");

        btNewWine.setTypeface(font);
        btListWine.setTypeface(font);
        btEditWine.setTypeface(font);
        btAbout.setTypeface(font);
        btExit.setTypeface(font);
*/    }

    public void newWine(View view){
        Intent intent = new Intent(this, NewWineActivity.class);

        startActivity(intent);
    }

    public void wineList(View view){
        Intent intent = new Intent(this, ListWineActivity.class);

        startActivity(intent);
    }

    public void editWine(View view){
        Toast.makeText(this, "O jogo ainda está sendo construído", Toast.LENGTH_SHORT).show();
    }

    public void about(View view){
        Toast.makeText(this, "O jogo ainda está sendo construído", Toast.LENGTH_SHORT).show();
    }

    public void exit(View view){
        finish();
    }
}
