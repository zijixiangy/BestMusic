package loaddata.bestmusic.inject.module;

import dagger.Module;
import dagger.Provides;
import loaddata.bestmusic.presenter.contract.SplashContract;
import loaddata.bestmusic.presenter.impl.SplashPerserter;

/**
 * Created by svmsung on 2017-07-19.
 */
@Module
public class SplashModule {
    private  SplashContract.view mView;


    public SplashModule(SplashContract.view mView) {
        this.mView = mView;

    }

    @Provides
    SplashContract.view providesSplashView() {
        return mView;
    }
    @Provides
    SplashContract.persenter providesSplashPersenter(){
        return new SplashPerserter(mView);
    }
}
