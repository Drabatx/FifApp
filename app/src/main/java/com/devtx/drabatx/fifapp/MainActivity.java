package com.devtx.drabatx.fifapp;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private ImageView logoFIF;
    //private ImageView imgFIF;
    private AppBarLayout mAppBarLayout;
    private RelativeLayout content;
    private String EXTRA_IMAGE="com.devtx.drabatx.fifapp";
    public static String TAG = "FIFAPP";
    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR  = 0.8f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS     = 0.8f;
    private static final int ALPHA_ANIMATIONS_DURATION              = 600;
    private boolean mIsTheTitleVisible          = false;
    private boolean mIsTheTitleContainerVisible = true;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoFIF = (ImageView)findViewById(R.id.imgLogoFIF);
        //imgFIF  = (ImageView)findViewById(R.id.imgFIF);
        mAppBarLayout = (AppBarLayout)findViewById(R.id.appbar);
        content = (RelativeLayout)findViewById(R.id.layoutContent);

        ViewCompat.setTransitionName(findViewById(R.id.appbar),EXTRA_IMAGE);
        supportPostponeEnterTransition();

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mAppBarLayout.addOnOffsetChangedListener(this);
        setSupportActionBar(toolbar);
        startAlphaAnimation(logoFIF,0,View.INVISIBLE);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        Fragment miercoles  =new EventosFragment();
        Fragment jueves     =new EventosFragment();
        Fragment viernes    =new EventosFragment();
        Fragment sabado     =new EventosFragment();
        Fragment domingo    =new EventosFragment();
        mSectionsPagerAdapter.addFragment(miercoles,"21 Nov");
        setArgumentFragment(miercoles,0);
        mSectionsPagerAdapter.addFragment(jueves,"22 Nov");
        setArgumentFragment(jueves,1);
        mSectionsPagerAdapter.addFragment(viernes,"23 Nov");
        setArgumentFragment(viernes,2);
        mSectionsPagerAdapter.addFragment(sabado,"24 Nov");
        setArgumentFragment(sabado,3);
        mSectionsPagerAdapter.addFragment(domingo,"25 Nov");
        setArgumentFragment(domingo,4);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        setStatusBarTranslucent(true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    private void setArgumentFragment(Fragment fragment, int section) {
        //Log.d("MENSAJE", ">" + section);
        Bundle args = new Bundle();
        args.putInt("SECTION",section);
        fragment.setArguments(args);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void startAlphaAnimation (View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0.0f, 1f)
                : new AlphaAnimation(1f, 0.0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setStartOffset(200);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        Log.d(TAG, "maxScroll = " + maxScroll);
        float percentage = (float) (Math.abs(verticalOffset)) / (float) maxScroll;
        Log.d(TAG, "percentage = " + percentage);
        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);

    }
    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if(!mIsTheTitleVisible) {
                startAlphaAnimation(logoFIF, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(logoFIF, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if(mIsTheTitleContainerVisible) {
                startAlphaAnimation(content, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(content, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }
    protected void setStatusBarTranslucent(boolean makeTranslucent) {
        if (makeTranslucent) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
}
