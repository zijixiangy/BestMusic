package loaddata.bestmusic.ui.act;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import loaddata.bestmusic.R;
import loaddata.bestmusic.ui.fragment.MainFragment;
import loaddata.bestmusic.ui.fragment.MainPlayFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_fragment_music)
    FrameLayout mainFragmentMusic;
    @BindView(R.id.main_fragment_play)
    FrameLayout mainFragmentPlay;
    @BindView(R.id.main_Navigation)
    NavigationView mainNavigation;
    @BindView(R.id.activity_main)
    DrawerLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setFragment();
    }

    private void setFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        MainFragment m=new MainFragment();
        fragmentTransaction.add(R.id.main_fragment_music,m);
        MainPlayFragment mp=new MainPlayFragment();
        fragmentTransaction.add(R.id.main_fragment_play,mp);
        fragmentTransaction.commit();
    }
}
