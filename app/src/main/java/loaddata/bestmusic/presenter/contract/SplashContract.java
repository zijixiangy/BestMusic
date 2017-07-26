package loaddata.bestmusic.presenter.contract;

/**
 * Created by svmsung on 2017-07-19.
 */

public interface SplashContract {
    /**
     * view
     */
    interface view {
        void intent2Act();
    }

    /**
     * presenter
     */
    interface persenter {
        void startIntent();
    }
}
