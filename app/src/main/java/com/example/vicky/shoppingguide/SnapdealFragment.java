package com.example.vicky.shoppingguide;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by vicky on 17/2/18.
 */

public class SnapdealFragment extends Fragment {
    private FloatingActionButton floatingActionButtonSD;
    Context context;
    String currurl="";
    WebView webView;
    static  final String TAG="Main";
  //  ProgressDialog progressDialog;
    String string="";
    AlertDialog.Builder alertDialog1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.snapdeal_fragment,container,false);
        string=getArguments().getString("snapdeal");
        floatingActionButtonSD= (FloatingActionButton) this.getActivity().findViewById(R.id.wishListSnapdeal);
        context=getActivity();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webView= (WebView) view.findViewById(R.id.webViewSnapdeal);
        WebSettings settings=webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true);
        settings.setSupportZoom(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setGeolocationEnabled(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setSavePassword(true);
        settings.setSaveFormData(true);
        settings.setEnableSmoothTransition(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);

        final AlertDialog alertDialog=new AlertDialog.Builder(getContext()).create();
        /*progressDialog=ProgressDialog.show(getContext(),"Loading","Please wait...",true);
        progressDialog.setCancelable(false);*/
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.i(TAG,"Processing webview URL click...");
                view.loadUrl(url);
                currurl=url;
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.i(TAG,"Finished loading URL:"+url);
               /* if(progressDialog.isShowing())
                    progressDialog.dismiss();*/
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                Log.e(TAG,"Error: "+description);
                Toast.makeText(getContext(),"Oh no!! "+description,Toast.LENGTH_SHORT).show();
                alertDialog.setTitle("Error");
                alertDialog.setMessage(description);
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                alertDialog.show();
            }
        });
        webView.loadUrl(string);
        webView.canGoBack();
        webView.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        || event.getAction() == MotionEvent.ACTION_UP
                        || webView.canGoBack()) {
                    webView.goBack();
                    return true;
                }
                return false;
            }


        });

        floatingActionButtonSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog1=new AlertDialog.Builder(getContext());

                alertDialog1.setTitle("Wish List").setMessage("Are you Sure this is a product page and that you want to add the product to Wish List?").
                        setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                currurl=webView.getUrl();
                                URL url=new URL();
                                url.setUrl(currurl);

                                MyDatabase database=new MyDatabase(getContext());
                                database.insertDatabase(url);
                                Toast.makeText(getContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                            }
                        }).
                        setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).setCancelable(true).show();
            }
        });
    }
}
