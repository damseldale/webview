package com.example.app;

import android.app.Activity; // Kita pakai Activity standar bawaan Android
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity { // Berubah menjadi Activity biasa

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Membuat layar WebView
        webView = new WebView(this);
        setContentView(webView);

        // Pengaturan dasar
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        // Agar tidak lompat ke Google Chrome
        webView.setWebViewClient(new WebViewClient());

        // INI TEKS PANCINGANNYA
        webView.loadUrl("TEMPLATE_URL_WEB");
    }

    // Mengatur tombol "Back" (Kembali) di HP
    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
