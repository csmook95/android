package study.android.a02_textview;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);

        textView3.setText("안녕하세요. 안드로이드");

        int color1 = Color.parseColor("#ff6600");
        int color2 = Color.parseColor("#ffff00");
        textView3.setTextColor(color1);
        textView3.setBackgroundColor(color2);

        textView3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);

        textView3.setSingleLine(false);

        textView4.setText(R.string.my_text);

        int my_color1 = getColor(R.color.my_color_1);
        int my_color2 = getColor(R.color.my_color_2);
        textView4.setTextColor(my_color1);
        textView4.setBackgroundColor(my_color2);

        Resources r = getResources();

        float my_size = r.getDimension(R.dimen.my_size);
        textView4.setTextSize(TypedValue.COMPLEX_UNIT_PX, my_size);

        textView4.setSingleLine(true);
    }
}