/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Message
 *  android.os.Process
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebView$WebViewTransport
 *  android.webkit.WebViewClient
 *  android.widget.CheckBox
 *  android.widget.Toast
 *  androidx.appcompat.app.AlertDialog
 *  androidx.appcompat.app.AlertDialog$Builder
 *  androidx.appcompat.app.AppCompatActivity
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentStatePagerAdapter
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.steppers.Gnumap;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.steppers.Gnumap.FifthFragment;
import com.steppers.Gnumap.FirstFragment;
import com.steppers.Gnumap.FourthFragment;
import com.steppers.Gnumap.PreferenceManager;
import com.steppers.Gnumap.SecondFragment;
import com.steppers.Gnumap.SixthFragment;
import com.steppers.Gnumap.ThirdFragment;

public class MainActivity
extends AppCompatActivity {
    static String addr_home = "https://www.google.com/maps/d/drive?state=%7B%22ids%22%3A%5B%221vrw5WpIN-yeePzDEowxN7snbVEHJVORm%22%5D%2C%22action%22%3A%22open%22%2C%22userId%22%3A%22112678020809424446096%22%7D&usp=sharing";
    static int check;
    private Context mContext;
    private boolean mFlag = false;
    private Handler mHandler;
    private WebView mWebView;
    ViewPager vp;

    protected void onCreate(Bundle bundle) {
        WebView webView;
        int n;
        ViewPager viewPager;
        super.onCreate(bundle);
        this.setContentView(2131427356);
        this.vp = viewPager = (ViewPager)this.findViewById(2131231023);
        viewPager.setAdapter((PagerAdapter)new pagerAdapter(this.getSupportFragmentManager()));
        this.vp.setCurrentItem(0);
        this.mContext = this;
        check = n = PreferenceManager.getInt((Context)this, "check");
        if (n == 0) {
            this.vp.setVisibility(4);
            this.findViewById(2131230803).setVisibility(4);
            this.findViewById(2131230997).setVisibility(4);
        } else {
            this.vp.setVisibility(0);
            this.findViewById(2131230803).setVisibility(0);
            this.findViewById(2131230997).setVisibility(0);
        }
        ((CheckBox)this.findViewById(2131230803)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                if (((CheckBox)view).isChecked()) {
                    PreferenceManager.setInt(MainActivity.this.mContext, "check", 0);
                    return;
                }
                PreferenceManager.setInt(MainActivity.this.mContext, "check", 1);
            }
        });
        this.mWebView = webView = (WebView)this.findViewById(2131231024);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setSupportMultipleWindows(true);
        webSettings.setBuiltInZoomControls(false);
        this.mWebView.setWebViewClient(new WebViewClient(){

            public void onReceivedError(WebView webView, int n, String string2, String string3) {
                super.onReceivedError(webView, n, string2, string3);
                switch (n) {
                    default: {
                        return;
                    }
                    case -15: 
                    case -14: 
                    case -13: 
                    case -12: 
                    case -11: 
                    case -10: 
                    case -9: 
                    case -8: 
                    case -7: 
                    case -6: 
                    case -5: 
                    case -4: 
                    case -3: 
                    case -2: 
                    case -1: 
                }
                MainActivity.this.mWebView.loadUrl("about:blank");
                AlertDialog.Builder builder = new AlertDialog.Builder((Context)MainActivity.this);
                builder.setPositiveButton((CharSequence)"\ud655\uc778", new DialogInterface.OnClickListener(){

                    public void onClick(DialogInterface dialogInterface, int n) {
                        Process.killProcess((int)Process.myPid());
                    }
                });
                builder.setMessage((CharSequence)"\uc11c\ubc84 \uc5f0\uacb0\uc5d0 \uc2e4\ud328\ud558\uc600\uc2b5\ub2c8\ub2e4. \n\uc778\ud130\ub137 \uc811\uc18d\ud658\uacbd\uc744 \ud655\uc778\ud558\uc138\uc694.");
                builder.setCancelable(false);
                builder.show();
            }

        });
        this.mWebView.setWebChromeClient(new WebChromeClient(){

            public boolean onCreateWindow(WebView webView, boolean bl, boolean bl2, Message message) {
                WebView webView2 = new WebView((Context)MainActivity.this);
                webView2.getSettings();
                final Dialog dialog = new Dialog((Context)MainActivity.this);
                dialog.setContentView((View)webView2);
                dialog.show();
                webView2.setWebChromeClient(new WebChromeClient(){

                    public void onCloseWindow(WebView webView) {
                        dialog.dismiss();
                    }
                });
                ((WebView.WebViewTransport)message.obj).setWebView(webView2);
                message.sendToTarget();
                return true;
            }

        });
        this.mWebView.loadUrl(addr_home);
        this.mHandler = new Handler(){

            public void handleMessage(Message message) {
                if (message.what == 0) {
                    MainActivity.this.mFlag = false;
                }
            }
        };
    }

    public boolean onKeyDown(int n, KeyEvent keyEvent) {
        if (n == 4) {
            if (this.mWebView.canGoBack()) {
                this.mWebView.goBack();
                return false;
            }
            if (!this.mFlag) {
                Toast.makeText((Context)this, (CharSequence)"'\ub4a4\ub85c' \ubc84\ud2bc\uc744 \ud55c\ubc88 \ub354 \ub204\ub974\uc2dc\uba74 \uc885\ub8cc\ub429\ub2c8\ub2e4.", (int)0).show();
                this.mFlag = true;
                this.mHandler.sendEmptyMessageDelayed(0, 2000L);
                return false;
            }
            this.finish();
        }
        return super.onKeyDown(n, keyEvent);
    }

    public void start_btn(View view) {
        this.vp.setVisibility(4);
        this.findViewById(2131230803).setVisibility(4);
        this.findViewById(2131230997).setVisibility(4);
    }

    private class pagerAdapter
    extends FragmentStatePagerAdapter {
        public pagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int getCount() {
            return 6;
        }

        public Fragment getItem(int n) {
            if (n != 0) {
                if (n != 1) {
                    if (n != 2) {
                        if (n != 3) {
                            if (n != 4) {
                                if (n != 5) {
                                    return null;
                                }
                                return new SixthFragment();
                            }
                            return new FifthFragment();
                        }
                        return new FourthFragment();
                    }
                    return new ThirdFragment();
                }
                return new SecondFragment();
            }
            return new FirstFragment();
        }
    }

}

