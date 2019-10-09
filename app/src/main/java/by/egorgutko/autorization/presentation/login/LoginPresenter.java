package by.egorgutko.autorization.presentation.login;

import android.content.Context;

import by.egorgutko.autorization.data.defaultPreference.AutorizationPreference;
import by.egorgutko.autorization.presentation.base.BasePresenter;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter<LoginActivity> implements LoginActivityInterface {

    AutorizationPreference autorizationPreferenceSingleton;
    //AuthorizationPreferences authorizationPreferences = new AuthorizationPreferences();

    @Override
    public Completable addName(Context context, String name){
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                autorizationPreferenceSingleton = AutorizationPreference.getPreference(context);
                autorizationPreferenceSingleton.addUserName(name)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe();
            }
        });

    }


}
