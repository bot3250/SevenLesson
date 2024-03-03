package com.bot.sevenlesson;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {

    private TextView screen, coordinates;
    private float x;
    private float y;
    private int[] coordinatesKeys;
    private int interval = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.screen);
        coordinates = findViewById(R.id.coordinates);

        screen.setOnTouchListener(listener);
    }
    private View.OnTouchListener listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Random random = new Random();
            coordinatesKeys = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IntStream.range(0, 10)
                    .forEach(index -> coordinatesKeys[index] = random.nextInt(view.getWidth()));

            x = motionEvent.getX();
            y = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    coordinates.setText("Нажатие " + x + ", " + y);
                    break;
                case MotionEvent.ACTION_MOVE:
                    coordinates.setText("Движение " + x + ", " + y);
                    if (x >= (coordinatesKeys[0] - interval) && x <= (coordinatesKeys[0] + interval) && y >= (coordinatesKeys[1] - interval) && y <= (coordinatesKeys[1] + interval)) {
                        Toast.makeText(MainActivity.this, "Найден первый ключ", Toast.LENGTH_SHORT).show();
                    } else if (x >= (coordinatesKeys[2] - interval) && x <= (coordinatesKeys[2] + interval) && y >= (coordinatesKeys[3] - interval) && y <= (coordinatesKeys[3] + interval)) {
                        Toast.makeText(MainActivity.this, "Найден второй ключ", Toast.LENGTH_SHORT).show();
                    } else if (x >= (coordinatesKeys[4] - interval) && x <= (coordinatesKeys[4] + interval) && y >= (coordinatesKeys[5] - interval) && y <= (coordinatesKeys[5] + interval)) {
                        Toast.makeText(MainActivity.this, "Найден третий ключ", Toast.LENGTH_SHORT).show();
                    } else if (x >= (coordinatesKeys[6] - interval) && x <= (coordinatesKeys[6] + interval) && y >= (coordinatesKeys[7] - interval) && y <= (coordinatesKeys[7] + interval)) {
                        Toast.makeText(MainActivity.this, "Найден четвёртый ключ", Toast.LENGTH_SHORT).show();
                    } else if (x >= (coordinatesKeys[8] - interval) && x <= (coordinatesKeys[8] + interval) && y >= (coordinatesKeys[9] - interval) && y <= (coordinatesKeys[9] + interval)) {
                        Toast.makeText(MainActivity.this, "Найден пятый ключ", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    coordinates.setText("Отпускание " + x + ", " + y);
                    break;
            }

            return true;
        }
    };
}