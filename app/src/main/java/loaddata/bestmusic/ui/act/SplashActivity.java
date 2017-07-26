package loaddata.bestmusic.ui.act;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import loaddata.bestmusic.R;
import loaddata.bestmusic.inject.component.DaggerSplashComponent;
import loaddata.bestmusic.inject.module.SplashModule;
import loaddata.bestmusic.presenter.contract.SplashContract;

public class SplashActivity extends BaseActivity implements SplashContract.view {

    @Inject
    SplashContract.persenter persenter;
    @BindView(R.id.activity_splash_text)
    TextView activitySplashText;
    @BindView(R.id.activity_splash_img)
    ImageView activitySplashImg;
    @BindView(R.id.activity_splash_lay)
    LinearLayout activitySplashLay;


    private AnimationDrawable ad;
    private MyCount count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置无标题，无状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        DaggerSplashComponent.builder()
                .splashModule(new SplashModule(this))
                .build().inject(this);


        initView();
    }

    private void initView() {
        // 实例化一个持续4秒，间隔为一秒的计时器
        count = new MyCount(8000, 1000);
        count.start();
        //设置，开始帧动画
        ad = (AnimationDrawable) activitySplashImg.getBackground();
        ad.start();
    }

    @Override
    public void intent2Act() {
        count.cancel();
        ad.stop();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    @OnClick({R.id.activity_splash_text, R.id.activity_splash_img, R.id.activity_splash_lay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_splash_text:
                persenter.startIntent();
                break;
            case R.id.activity_splash_img:
                break;
            case R.id.activity_splash_lay:
                break;
        }
    }

    class MyCount extends CountDownTimer {
        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            activitySplashText.setText("跳过  " + l / 1000 + "s");
            activitySplashText.setTextColor(getResources().getColor(R.color.colorAccent));
        }

        @Override
        public void onFinish() {
            persenter.startIntent();
        }
    }


}
