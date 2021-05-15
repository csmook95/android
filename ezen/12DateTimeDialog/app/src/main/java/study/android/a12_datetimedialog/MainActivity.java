package study.android.a12_datetimedialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;
    TextView textView1, textView2;

    int[] date;
    int[] time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        Calendar calendar = Calendar.getInstance();

        date = new int[]{
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        };

        time = new int[]{
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE)
        };

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });
    }

    public void showDatePickerDialog() {
        final int[] backup = new int[date.length];
        System.arraycopy(date, 0, backup, 0, date.length);

        DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date[0] = year;
                        date[1] = month;
                        date[2] = dayOfMonth;

                        textView1.setText(String.format("%04d-%02d-%02d",
                                year, month + 1, dayOfMonth));
                    }
                }, date[0], date[1], date[2]);

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                System.arraycopy(backup, 0, date, 0, date.length);
            }
        });

        dialog.show();
    }

    public void showTimePickerDialog() {
        final int[] backup = new int[time.length];
        System.arraycopy(time, 0, backup, 0, time.length);

        TimePickerDialog dialog = new TimePickerDialog(MainActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time[0] = hourOfDay;
                        time[1] = minute;

                        textView2.setText(String.format("%02d:%02d", time[0], time[1]));
                    }
                }, time[0], time[1], true);

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                System.arraycopy(backup, 0, time, 0, time.length);
            }
        });

        dialog.show();
    }
}