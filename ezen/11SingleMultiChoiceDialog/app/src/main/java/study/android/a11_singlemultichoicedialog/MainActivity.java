package study.android.a11_singlemultichoicedialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;
    TextView  textView1, textView2;

    String[] items = {"봄", "여름", "가을", "겨울"};
    int singleChoiceIndex = 0;
    boolean[] multiChoiceIndex = {false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSingleChoiceDialog();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMultiChoiceDialog();
            }
        });
    }

    public void showSingleChoiceDialog() {

        final int backupChoiceIndex = singleChoiceIndex;

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("좋아하는 계절을 선택하세요.");
        builder.setIcon(R.mipmap.ic_launcher);

        builder.setSingleChoiceItems(items, singleChoiceIndex, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT).show();
                singleChoiceIndex = which;
            }
        });

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView1.setText(items[singleChoiceIndex]);
            }
        });

        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                singleChoiceIndex = backupChoiceIndex;
            }
        });

        builder.create();
        builder.show();
    }

    public void showMultiChoiceDialog() {

        final boolean[] backupChoiceIndex = new boolean[multiChoiceIndex.length];
        System.arraycopy(multiChoiceIndex, 0, backupChoiceIndex, 0, multiChoiceIndex.length);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("좋아하는 계절을 선택하세요.");
        builder.setIcon(R.mipmap.ic_launcher);

        builder.setMultiChoiceItems(items, multiChoiceIndex,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        multiChoiceIndex[which] = isChecked;

                        String msg = items[which];
                        msg += isChecked ? "체크됨" : "체크안됨";
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String result = "";
                for (int i = 0; i < items.length; i++) {
                    if (multiChoiceIndex[i]) {
                        result += items[i] + "\n";
                    }
                }
                textView2.setText(result);
            }
        });

        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                System.arraycopy(backupChoiceIndex, 0, multiChoiceIndex, 0, multiChoiceIndex.length);
            }
        });

        builder.create();
        builder.show();
    }
}