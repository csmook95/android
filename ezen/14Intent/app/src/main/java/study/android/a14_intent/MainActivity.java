package study.android.a14_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 01012345678"));
                        startActivity(intent1);
                        break;

                    case 1:
                        Intent intent2 = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:01012345678"));
                        intent2.putExtra("sms_body", "The SMS text");
                        startActivity(intent2);
                        break;

                    case 2:
                        Intent intent3 = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:android@gmail.com"));
                        intent3.putExtra(Intent.EXTRA_SUBJECT,"메일테스트");
                        startActivity(intent3);
                        break;

                    case 3:
                        Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://itproject.ezenac.co.kr/springmyshop"));
                        startActivity(intent4);
                        break;

                    case 4:
                        Intent intent5 = new Intent(Intent.ACTION_WEB_SEARCH);
                        intent5.putExtra(SearchManager.QUERY,"Android");
                        startActivity(intent5);
                        break;

                    case 5:
                        Intent intent6 = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.android.chrome"));
                        startActivity(intent6);
                        break;

                    case 6:
                        Intent intent7 = new Intent(Intent.ACTION_VIEW);
                        intent7.setDataAndType(
                                Uri.parse("http://itpaper.co.kr/demo/app/BigBuck.mp4"), "video/*");
                        startActivity(intent7);
                        break;

                    case  7:
                        Intent intent8 = new Intent(Intent.ACTION_VIEW);
                        intent8.setDataAndType(
                                Uri.parse("http://itpaper.co.kr/demo/app/music.mp3"), "audio/*");
                        startActivity(intent8);
                        break;

                    case 8:
                        startActivity(new Intent(Settings.ACTION_SETTINGS));
                        break;

                    case 9:
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        break;

                    case  10:
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));

                    case 11:
                        startActivity(new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                Uri.parse("package:study.android.a14_intent")));
                }
            }
        });
    }
}