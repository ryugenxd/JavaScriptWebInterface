package com.example.webview;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView; 
import android.view.View;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.webkit.JavascriptInterface;
import android.widget.Toast;  
import android.content.Context;

public class MainActivity extends Activity {
public WebView webku;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webku = (WebView) findViewById(R.id.webku);
        webku.setWebViewClient(new WebViewClient());
        webku.addJavascriptInterface(new WebAppInterface(this), "Android");
        WebSettings setc = webku.getSettings();      
        setc.setJavaScriptEnabled(true);
        webku.loadUrl("file:///android_asset/Activity.html");
    }
    public class WebAppInterface {
          Context mContext;

           /** Instantiate the interface and set the context */
           WebAppInterface(Context c) {
              mContext = c;
           }

          /** Show a toast from the web page */
          @JavascriptInterface
           public void showToast(String toast) {
             Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
           }
    }
}