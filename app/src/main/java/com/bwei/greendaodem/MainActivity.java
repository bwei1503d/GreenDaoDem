package com.bwei.greendaodem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.bwei.dao.UserDao;
import com.bwei.greendaodem.bean.User;

import java.util.List;
import java.util.Random;


import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class MainActivity extends Activity {

    private MyApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        application = (MyApplication) getApplication();


        findViewById(R.id.insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0;i<100;i++){
                    User user = new User();
                    user.setId(System.currentTimeMillis());
                    user.setName(" 1 " + new Random().nextInt(100));
                    user.setAge(new Random().nextInt(1000));
                    user.setCid(i);
                    user.setMax(1000);
                    application.daoSession.getUserDao().insert(user);
                }

                System.out.println("application = " + application.daoSession.loadAll(User.class).size());

            }
        });


        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              List<User> list =   application.daoSession.getUserDao().loadAll() ;

              if(list.size() > 0){
                  list.get(0).setAge(new Random().nextInt(1000)) ;
                  application.daoSession.getUserDao().update(list.get(0));
              }


            }
        });


        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              List<User> list =  application.daoSession.getUserDao().queryBuilder().list() ;

                if(list.size() > 0){

                    application.daoSession.getUserDao().delete(list.get(0));

                }

                System.out.println("application = " + application.daoSession.getUserDao().queryBuilder().list().size());



            }
        });


        findViewById(R.id.query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                application.daoSession.getUserDao().queryBuilder().offset(10).limit(10)
              List<User> userList =   application.daoSession.getUserDao().queryRaw(" where age > ? ", "100" );
               List<User> list =   application.daoSession.getUserDao().queryBuilder().where(UserDao.Properties.Age.eq(30)).list() ;

//             List<User> list =    application.daoSession.getUserDao().queryBuilder().list() ;
//
//                System.out.println("query list = " + list.size());



//                1 查询
//             List<User> list =   application.daoSession.getUserDao().queryRaw("where age > ?","100");

//              List<User> list =   application.daoSession.getUserDao().queryRaw("where age > ? and cid > ?","100","20");


//               List<User> list =   application.daoSession.getUserDao().queryBuilder().where(UserDao.Properties.Age.eq(30)).list() ;
//                List<User> list =   application.daoSession.getUserDao().rx().

//                application.daoSession.getUserDao().queryBuilder().where(UserDao.Properties.Age.ge(10)).rx()

//                application.daoSession.getUserDao().queryBuilder().rx().list()


//                System.out.println("list = " + list.size());


            }
        });



        findViewById(R.id.rxbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();
                user.setId(System.currentTimeMillis());
                user.setName("xxxx");
                user.setAge(100000);
                user.setMax(1000000);


                application.daoSession.getUserDao().rxPlain().insert(user)
                        .subscribe(new Observer<User>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(User user) {
                                System.out.println("user = " + user.getId());
                            }
                        }) ;

            }
        });


        findViewById(R.id.rxquery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                application.daoSession.getUserDao().queryBuilder().whereOr(UserDao.Properties.Age.gt(100), UserDao.Properties.Age.le(200))
//                        .rx().list().subscribe(new Action1<List<User>>() {
//                    @Override
//                    public void call(List<User> users) {
//
//                    }
//                });


               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       application.daoSession.getUserDao().queryBuilder().where(UserDao.Properties.Age.gt(100)).rxPlain().list()
                               .observeOn(AndroidSchedulers.mainThread())
                               .subscribe(new Action1<List<User>>() {
                                   @Override
                                   public void call(List<User> users) {

                                       System.out.println("users = " + Thread.currentThread().getName());
                                       System.out.println("users = " + users.size());
                                   }
                               });
                   }
               }).start();

            }
        });

    }
}
