package com.henghao.greendaodemo01;

import android.content.Context;

import com.henghao.greendaodemo01.greendao.DaoMaster;
import com.henghao.greendaodemo01.greendao.DaoSession;

/**
 * Created by zb on 2017/6/19.
 * 数据库帮助类
 */

public class GreenDaoManager {
    private DaoMaster.DevOpenHelper helper;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private static GreenDaoManager greenDaoManager;

    private GreenDaoManager(Context context) {
        helper = new DaoMaster.DevOpenHelper(context.getApplicationContext(), "GreenDao_DB");
        daoMaster = new DaoMaster(helper.getWritableDb());
        daoSession = daoMaster.newSession();
    }

    public static GreenDaoManager getInstance(Context context) {
        if (greenDaoManager == null){
            synchronized (GreenDaoManager.class){
                if (greenDaoManager == null) {
                    greenDaoManager = new GreenDaoManager(context);
                }
            }
        }
        return greenDaoManager;
    }

    public DaoMaster.DevOpenHelper getDevOpenHelper() {
        return helper;
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public void closeDB() {
        if (helper != null) {
            helper.close();
        }
    }

}
