package com.bwei.greendaodem;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bwei.dao.DaoMaster;
import com.bwei.dao.DaoSession;

/**
 * Created by muhanxi on 17/6/11.
 */

public class MyApplication extends Application {
    private final static String dbName = "test_db.db";
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;
    public  DaoSession daoSession;


    @Override
    public void onCreate() {
        super.onCreate();

        openHelper = new DaoMaster.DevOpenHelper(this, dbName);
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();

    }
}
