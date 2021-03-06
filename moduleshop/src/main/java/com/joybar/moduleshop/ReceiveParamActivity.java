package com.joybar.moduleshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.joybar.annotation.router.annotation.RegisterRouter;
import com.joybar.librouter.guider.annotation.DataParam;
import com.joybar.librouter.guider.annotation.RegisterLaunch;

@RegisterRouter(module = "shop", path = "receive_param")
public class ReceiveParamActivity extends AppCompatActivity {

    private TextView tvDes;
    @DataParam
    public int id;
    @DataParam
    public String name;
    @DataParam
    public String address;

    @RegisterLaunch
    public static void launch(Context context,String address){
        Intent intent = new Intent(context,ReceiveParamActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("address",address);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @RegisterLaunch
    public static void launch(Context context,String name,int id){
        Intent intent = new Intent(context,ReceiveParamActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id",id);
        bundle.putString("name",name);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity_receive_param);
        initView();
        initData();
    }

    private void initView() {
        tvDes = findViewById(R.id.tv_des);
    }

    private void initData() {
        Bundle mExtras = getIntent().getExtras();
        int id = mExtras.getInt("id", 0);
        String name = mExtras.getString("name", "");
        tvDes.setText("我从Module User 跳转过来"+"\n"+"接受到的参数"+"\n"+"\n"+" ID:" + id + "," + "name:" + name);

    }

}


