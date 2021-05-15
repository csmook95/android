package study.android.doitmission03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1, imageView2;
    ScrollView scrollView1, scrollView2;
    BitmapDrawable bitmapDrawable;
    int bitmapWidth, bitmapHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        scrollView1 = findViewById(R.id.scrollView1);
        scrollView2 = findViewById(R.id.scrollView2);
        scrollView1.setHorizontalScrollBarEnabled(true);
        scrollView2.setHorizontalScrollBarEnabled(true);

        Resources res = getResources();
        bitmapDrawable = (BitmapDrawable) res.getDrawable(R.drawable.beach);
        bitmapWidth = bitmapDrawable.getIntrinsicWidth();
        bitmapHeight = bitmapDrawable.getIntrinsicHeight();

        imageView1.setImageDrawable(bitmapDrawable);
        imageView1.getLayoutParams().width = bitmapWidth;
        imageView1.getLayoutParams().height = bitmapHeight;

    }

    public void onButton1Clicked(View v) {
        changeImage(imageView1, imageView2);
    }

    public void onButton2Clicked(View v) {
        changeImage(imageView2, imageView1);
    }

    private void changeImage(ImageView imageView1, ImageView imageView2) {
        imageView1.setImageDrawable(bitmapDrawable);
        imageView1.getLayoutParams().width = bitmapWidth;
        imageView1.getLayoutParams().height = bitmapHeight;

        imageView2.setImageResource(0);
    }
}