package loaddata.bestmusic.presenter.impl;

import javax.inject.Inject;

import loaddata.bestmusic.presenter.contract.SplashContract;

/**
 * Created by svmsung on 2017-07-19.
 */

public class SplashPerserter implements SplashContract.persenter {
    public SplashContract.view view;

    @Inject
    public SplashPerserter(SplashContract.view view) {
        this.view = view;
    }

    @Override
    public void startIntent() {
        view.intent2Act();
    }
}
