package com.example.webview_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    lateinit var webView : WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        initWebView("https://blog.naver.com/dh971125")

    }

    private fun initWebView(address : String) {

        // 웹뷰안에 새 창이 뜨지 않도록 방지
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()

        // 자바스크립트가 창을 자동으로 열 수 있게할지 여부
        webView.settings.javaScriptEnabled = true

        // 이미지 자동 로드
        webView.settings.loadsImagesAutomatically = true

        // Url 로드
        webView.loadUrl(address)

    }

    // webView 안에서 뒤로가기 버튼 구현
    // 뒤로 갈 페이지가 있다면 뒤로가고
    // 초기화면에서 뒤로가면 종료됨
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView!!.canGoBack()) {
            webView?.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}