package com.ascend.assetcheck_jinhua.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ascend.assetcheck_jinhua.R;
import com.ascend.assetcheck_jinhua.base.BaseActivity;
import com.ascend.assetcheck_jinhua.ui.adapter.AbnormalAdapter;
import com.ascend.assetcheck_jinhua.ui.adapter.TotalAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartPandianActivity extends BaseActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.bg_finish)
    Button bgFinish;
    @BindView(R.id.total)
    TextView total;
    @BindView(R.id.abnormal)
    TextView abnormal;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.recyclerview1)
    RecyclerView recyclerview1;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private TotalAdapter totalAdapter;
    private List<String> totalDatas;

    private AbnormalAdapter abnormalAdapter;
    private List<String> abnormalDatas;

    private String data;
    @Override
    protected void findViews(Bundle savedInstanceState) {
        super.findViews(savedInstanceState);
        setContentView(R.layout.activity_start_pandian);
    }

    @Override
    protected void initViews() {
        super.initViews();
        data = getIntent().getStringExtra("data");
        title.setText(data);
        bgFinish.setVisibility(View.VISIBLE);
        initRecyle();
    }

    private void initRecyle() {
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        totalDatas = new ArrayList<>();
        for (int i = 0; i < 22; i++) {
            totalDatas.add("盘点区域" + i);
        }
        totalAdapter = new TotalAdapter(this, totalDatas);
        recyclerview.setAdapter(totalAdapter);
        recyclerview.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerview1.setLayoutManager(new LinearLayoutManager(this));
        abnormalDatas = new ArrayList<>();
        for (int i = 0; i < 22; i++) {
            abnormalDatas.add("盘点区域" + i);
        }
        abnormalAdapter = new AbnormalAdapter(this, abnormalDatas);
        recyclerview1.setAdapter(abnormalAdapter);
        recyclerview1.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }
    @OnClick({R.id.back, R.id.bg_finish, R.id.total, R.id.abnormal, R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.bg_finish:
                break;
            case R.id.total:
                recyclerview.setVisibility(View.VISIBLE);
                recyclerview1.setVisibility(View.GONE);
                total.setBackground(ContextCompat.getDrawable(StartPandianActivity.this,R.drawable.bg_slect));
                abnormal.setBackground(ContextCompat.getDrawable(StartPandianActivity.this,R.drawable.bg_unslect));
                break;
            case R.id.abnormal:
                recyclerview.setVisibility(View.GONE);
                recyclerview1.setVisibility(View.VISIBLE);
                total.setBackground(ContextCompat.getDrawable(StartPandianActivity.this,R.drawable.bg_unslect));
                abnormal.setBackground(ContextCompat.getDrawable(StartPandianActivity.this,R.drawable.bg_slect));
                break;
            case R.id.fab:
                break;
        }
    }
}
