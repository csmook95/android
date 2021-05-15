package study.android.a03_button;

import android.view.View;
import android.widget.Button;

public class OnButton1Click implements View.OnClickListener {


    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        b.setText("버튼 1이 클릭되었습니다.");
    }
}
