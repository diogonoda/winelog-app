package br.com.dnoda.winelog_app;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import br.com.dnoda.winelog_app.model.Wine;

/**
 * Created by dnoda on 2/13/18.
 */

public class WineListViewModel extends AndroidViewModel {
    private LiveData<List<Wine>> wines;

    public WineListViewModel(Application application){
        super(application);
    }
}
