package com.educa62.respositorypattern;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.educa62.respositorypattern.model.Users;

public class MainActivity extends AppCompatActivity implements MyContract.view {

    private ProgressDialog progressDoalog;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Users> data = new ArrayList<>();

    private MyPresenter presenter = new MyPresenter(Injection.UsersInjection(), this);
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rec);
        presenter.getDataListUsers();
        initAdapter();
    }

    @Override
    public void showProgress() {
        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("loading....");
        progressDoalog.setTitle("Harap tunggu");
        progressDoalog.show();
    }

    @Override
    public void hideProgress() {
        progressDoalog.dismiss();
    }

    @Override
    public void showDataList(List<Users> data) {
        this.data.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void failureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    private void initAdapter() {
        adapter = new MyAdapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

}
