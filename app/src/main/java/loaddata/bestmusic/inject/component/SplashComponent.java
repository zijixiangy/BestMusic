package loaddata.bestmusic.inject.component;

import dagger.Component;
import loaddata.bestmusic.inject.module.SplashModule;
import loaddata.bestmusic.ui.act.SplashActivity;

/**
 * Created by svmsung on 2017-07-19.
 */
@Component(modules = SplashModule.class)
public interface SplashComponent {
    void inject(SplashActivity splashActivity);
}
