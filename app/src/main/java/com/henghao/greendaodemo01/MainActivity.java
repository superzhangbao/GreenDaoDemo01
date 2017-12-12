package com.henghao.greendaodemo01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.henghao.greendaodemo01.greendao.UserDao;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.textview)
    TextView textview;
    @InjectView(R.id.btn_insert)
    Button btnInsert;
    @InjectView(R.id.btn_delete)
    Button btnDelete;
    @InjectView(R.id.btn_update)
    Button btnUpdate;
    @InjectView(R.id.btn_query)
    Button btnQuery;
    @InjectView(R.id.activity_main)
    LinearLayout activityMain;
    private UserDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        dao = GreenDaoManager.getInstance(this).getDaoSession().getUserDao();
    }

    @OnClick({R.id.btn_insert, R.id.btn_delete, R.id.btn_update, R.id.btn_query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_insert:
                try {
                    dao.insert(new User(1,"战报",11));
                }catch (Exception e) {
                    Toast.makeText(this,"添加数据失败",Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(this,"添加数据成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_delete:
//                List<User> users = dao.queryBuilder().where(UserDao.Properties.Id.eq(1)).build().list();
//                for(User uer : users) {
//                    GreenDaoManager.getInstance(this).getDaoSession().getUserDao().delete(uer);
//                }
                User user = new User(1,"战报",11);
                dao.delete(user);
                break;
            case R.id.btn_update:
                List<User> list1 = dao.queryBuilder().where(UserDao.Properties.Name.eq("战报")).build().list();
                for (int i = 0; i < list1.size(); i++) {
                    list1.get(i).setName("张宝");
                    dao.update(list1.get(i));
                }
                break;
            case R.id.btn_query:
                List<User> list = dao.queryBuilder().build().list();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i).getName());
                }
                textview.setText(sb.toString());
                break;
        }
    }
}
