package study.android.a08_edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2, editText3, editText4;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = editText1.getText().toString();
                String password = editText2.getText().toString();
                String email = editText3.getText().toString();
                String phone = editText4.getText().toString();

                System.out.println("-----------------");

                Log.v("EditText", "[사용자 입력 내용]");
                Log.d("EditText", name);
                Log.i("EditText", password);
                Log.w("EditText", email);
                Log.e("EditText", phone);
                System.out.println("-----------------");
            }
        });
    }
}