package com.henghao.greendaodemo01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void insert() throws Exception{
        User user = new User(1,"zhangbao1",12);
        try {
            App.getDaoSession().getUserDao().insert(user);
        }catch (Exception e) {
//            Toast.makeText(App.getContext(),"数据库插入出错",Toast.LENGTH_SHORT).show();
//            Log.i("cuo","出错啦");
        }
//        Toast.makeText(App.getContext(),"数据插入成功",Toast.LENGTH_SHORT).show();
//        Log.i("zhengque","成功啦");
    }
}