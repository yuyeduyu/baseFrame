package com.ascend.assetcheck_jinhua.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ascend.assetcheck_jinhua.R;
import com.ascend.assetcheck_jinhua.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.load)
    TextView load;
    @BindView(R.id.pandian)
    TextView pandian;
    @BindView(R.id.upload)
    TextView upload;

    @Override
    protected void findViews(Bundle savedInstanceState) {
        super.findViews(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick({R.id.load, R.id.pandian, R.id.upload})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.load:
                //下载盘点任务
                break;
            case R.id.pandian:
                //盘点
                Intent intent = new Intent(MainActivity.this,PandianActivity.class);

                intent.putExtra("data","");
                startActivity(intent);
                break;
            case R.id.upload:
                //上传盘点结果
                break;
        }
    }
}
