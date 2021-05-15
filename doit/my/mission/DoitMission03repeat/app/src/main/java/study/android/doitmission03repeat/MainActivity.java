package study.android.doitmission03repeat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView01, imageView02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView01 = findViewById(R.id.imageView01);
        imageView02 = findViewById(R.id.imageView02);

        Button button01 = findViewById(R.id.button01);
        button01.setOnClickListener(v -> moveImageUp());

        Button button02 = findViewById(R.id.button02);
        button02.setOnClickListener((v) -> {moveImageDown();});

        moveImageUp();
    }

    private void moveImageUp() {
        imageView01.setImageResource(R.drawable.beach);
        imageView02.setImageResource(0);

        imageView01.invalidate();
        imageView02.invalidate();
    }

    private void moveImageDown() {
        imageView01.setImageResource(0);
        imageView02.setImageResource(R.drawable.beach);

    }
}