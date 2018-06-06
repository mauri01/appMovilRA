/*===============================================================================
Copyright (c) 2016 PTC Inc. All Rights Reserved.

Copyright (c) 2012-2014 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of PTC Inc., registered in the United States and other 
countries.
===============================================================================*/

package com.vuforia.samples.VideoPlayback.ui.ActivityList;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.vuforia.samples.VideoPlayback.R;


public class AboutScreen extends AppCompatActivity
{
    private static final String LOGTAG = "AboutScreen";
    
    private WebView mAboutWebText;
    private Button mStartButton;
    private TextView mAboutTextTitle;
    private String mClassToLaunch;
    private String mClassToLaunchPackage;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        /*super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.about_screen);
        
        Bundle extras = getIntent().getExtras();
        String webText = extras.getString("ABOUT_TEXT");
        mClassToLaunchPackage = getPackageName();
        mClassToLaunch = mClassToLaunchPackage + "."
            + extras.getString("ACTIVITY_TO_LAUNCH");
        
        *//*mAboutWebText = (WebView) findViewById(R.id.about_html_text);
        
        AboutWebViewClient aboutWebClient = new AboutWebViewClient();
        mAboutWebText.setWebViewClient(aboutWebClient);*//*
        
        String aboutText = "";
        try
        {
            InputStream is = getAssets().open(webText);
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(is));
            String line;
            
            while ((line = reader.readLine()) != null)
            {
                aboutText += line;
            }
        } catch (IOException e)
        {
            Log.e(LOGTAG, "About html loading failed");
        }
        
        //mAboutWebText.loadData(aboutText, "text/html", "UTF-8");
        
        mStartButton = (Button) findViewById(R.id.button_start);
        mStartButton.setOnClickListener(this);
        
        mAboutTextTitle = (TextView) findViewById(R.id.about_text_title);
        mAboutTextTitle.setText(extras.getString("ABOUT_TEXT_TITLE"));*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_screen);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //Agregar fragmentos
        adapter.addFragment(new FragmentUno(),"");//Scan
        adapter.addFragment(new FragmentUno(),"");//Mapa
        adapter.addFragment(new FragmentUno(),"");//Favoritos
        //Adapter setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

       tabLayout.getTabAt(0).setIcon(R.drawable.ic_scan);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_map);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_fav);
    }
    
    
    // Starts the chosen activity
    private void startARActivity()
    {
        Intent i = new Intent();
        i.setClassName(mClassToLaunchPackage, mClassToLaunch);
        startActivity(i);
    }
    
    
    /*@Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button_start:
                startARActivity();
                break;
        }
    }*/
    
    private class AboutWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }
    }
}
