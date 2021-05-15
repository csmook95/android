package study.android.samplewidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittext);

        editText1 = findViewById(R.id.usernameInput);
        editText2 = findViewById(R.id.usernameInput2);
        editText1.getSelectionStart();
        

    }
}