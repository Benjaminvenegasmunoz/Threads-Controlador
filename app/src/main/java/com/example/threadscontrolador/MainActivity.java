package com.example.threadscontrolador;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button start;
    private LinearLayout b1, b2, b3;
    private int counter = 0;
    private boolean iniciar = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        b1 = findViewById(R.id.bombillaVerde);
        b2 = findViewById(R.id.bombillaAmarilla);
        b3 = findViewById(R.id.bombillaRoja);
        start = findViewById(R.id.btn_inicio);
        b1.setBackgroundColor(getResources().getColor(R.color.gris));
        b2.setBackgroundColor(getResources().getColor(R.color.gris));
        b3.setBackgroundColor(getResources().getColor(R.color.gris));
    }

    private void setColorCounter(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (iniciar){
                    counter++;
                    switch (counter){
                        case 1:
                            b1.setBackgroundColor(getResources().getColor(R.color.verde));
                            b2.setBackgroundColor(getResources().getColor(R.color.gris));
                            b3.setBackgroundColor(getResources().getColor(R.color.gris));
                            break;
                        case 2:
                            b1.setBackgroundColor(getResources().getColor(R.color.gris));
                            b2.setBackgroundColor(getResources().getColor(R.color.amarillo));
                            b3.setBackgroundColor(getResources().getColor(R.color.gris));
                            break;
                        case 3:
                            b1.setBackgroundColor(getResources().getColor(R.color.gris));
                            b2.setBackgroundColor(getResources().getColor(R.color.gris));
                            b3.setBackgroundColor(getResources().getColor(R.color.rojo));
                            break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}