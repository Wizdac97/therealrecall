package com.smle.recallpro

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webview)

        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            allowFileAccess = true
            allowContentAccess = true
            cacheMode = WebSettings.LOAD_DEFAULT
            textZoom = 100
        }

        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = WebViewClient()
        webView.addJavascriptInterface(AndroidBridge(), "AndroidBridge")

        webView.loadUrl("file:///android_asset/index.html")

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                webView.evaluateJavascript("window.handleAndroidBack && window.handleAndroidBack()") { result ->
                    if (result != "true") {
                        isEnabled = false
                        onBackPressedDispatcher.onBackPressed()
                    }
                }
            }
        })
    }

    inner class AndroidBridge {
        private val prefs by lazy { getSharedPreferences("smle_recall_prefs", MODE_PRIVATE) }

        @JavascriptInterface
        fun getPref(key: String): String {
            return prefs.getString(key, "") ?: ""
        }

        @JavascriptInterface
        fun setPref(key: String, value: String) {
            prefs.edit().putString(key, value).apply()
        }
        @JavascriptInterface
        fun setStatusBarTheme(theme: String) {
            runOnUiThread {
                val isDark = (theme == "dark")
                window.statusBarColor = if (isDark) Color.parseColor("#0B1120") else Color.parseColor("#F6F8FB")
                window.navigationBarColor = if (isDark) Color.parseColor("#131C31") else Color.parseColor("#FFFFFF")
                val controller = WindowInsetsControllerCompat(window, window.decorView)
                controller.isAppearanceLightStatusBars = !isDark
                controller.isAppearanceLightNavigationBars = !isDark
            }
        }
    }
}
