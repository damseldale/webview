package com.example.app;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Kita buat WebView langsung dari kode agar tidak bergantung pada file desain XML
        webView = new WebView(this);
        setContentView(webView);

        // Pengaturan wajib untuk WebView modern
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        // Agar jika ada link yang diklik, tidak lari ke browser luar (Chrome)
        webView.setWebViewClient(new WebViewClient());

        // INI TEKS PANCINGANNYA
        webView.loadUrl("TEMPLATE_URL_WEB");
    }

    // Mengatur tombol "Back" (Kembali) di HP agar tidak langsung keluar aplikasi
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
