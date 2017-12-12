package com.henghao.greendaodemo01;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.henghao.greendaodemo01.greendao.DaoMaster;
import com.henghao.greendaodemo01.greendao.DaoSession;

/**
 * Created by zb on 2017/6/19.
 */

public class App extends Application {
    private static Context context;
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        setUpDataBase(context);
    }

    /**
     *初始化数据库
     */
    private void setUpDataBase(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"test");
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }

    public static Context getContext() {
        return context;
    }
}
