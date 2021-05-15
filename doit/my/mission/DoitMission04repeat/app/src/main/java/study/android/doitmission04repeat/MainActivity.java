package study.android.doitmission04repeat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    EditText inputMessage;
    TextView inputCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputMessage = findViewById(R.id.inputMessage);
        inputCount = findViewById(R.id.inputCount);

        Button sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "전송할 메시지\n\n" + inputMessage.getText(), Toast.LENGTH_LONG).show());

        Button closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> finish());

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                byte[] bytes = null;

                try {
                    bytes = s.toString().getBytes("KSC5601");
                    int strCount = bytes.length;
                    inputCount.setText(strCount + "/ 80바이트");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = s.toString();

                try {
                    byte[] strBytes = str.getBytes("KSC5601");
                    if(strBytes.length >80) {
                        s.delete(s.length()-2, s.length()-1);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        };

        inputMessage.addTextChangedListener(watcher);
    }
}