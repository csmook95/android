package study.android.a13_customdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }

    void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("로그인");
        builder.setIcon(R.mipmap.ic_launcher);

        LayoutInflater inflater = getLayoutInflater();
        final View bodyView = inflater.inflate(R.layout.dialog_body, null);
        builder.setView(bodyView);

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText editText1 = (EditText) bodyView.findViewById(R.id.editText1);
                EditText editText2 = (EditText) bodyView.findViewById(R.id.editText2);

                String result = String.format("아이디 %s\n비밀번호 %s",
                        editText1.getText().toString().trim(),
                        editText2.getText().toString().trim()
                        );

                textView.setText(result);
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "취소되었습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        builder.create();
        builder.show();
    }
}