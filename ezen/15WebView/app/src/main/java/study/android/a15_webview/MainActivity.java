package study.android.a15_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        WebSettings webSettings = webView.getSettings();
        webSettings.setSaveFormData(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("http://m.naver.com");

        webView.setWebViewClient(new MyViewClient());

        webView.loadUrl("http://m.naver.com");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("http://m.naver.com");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("http://m.daum.net");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("file:///android_asset/hello.html");
            }
        });

    }

    class MyViewClient extends WebViewClient {
        Dialog dialog;

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            if (dialog == null) {
                dialog = new Dialog(MainActivity.this);

                Window window = dialog.getWindow();
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                window.setDimAmount(0);

                dialog.setContentView(new ProgressBar(MainActivity.this));
                dialog.show();
            }
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            if(dialog != null) {
                dialog.dismiss();
                dialog = null;
            }
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }
    }

    class MyChromeClient extends WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle(R.string.app_name)
                    .setIcon(R.mipmap.ic_launcher)
                    .setMessage(message)
                    .setCancelable(true)
                    .setPositiveButton("확인", new AlertDialog.OnClickListener() {
                        public  void onClick(DialogInterface dialog, int which) {
                            result.confirm();
                        }
                    })
                    .create()
                    .show();

            return  true;
        }

        @Override
        public  boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle(R.string.app_name)
                    .setIcon(R.mipmap.ic_launcher)
                    .setMessage(message)
                    .setCancelable(true)
                    .setPositiveButton("확인", new AlertDialog.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            result.confirm();
                        }
                    })
                    .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            result.cancel();
                        }
                    })
                    .create()
                    .show();
            return true;
        }
    }
}