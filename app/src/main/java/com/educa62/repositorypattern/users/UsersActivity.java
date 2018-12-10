package com.educa62.repositorypattern.users;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.educa62.repositorypattern.Injection;
import com.educa62.repositorypattern.R;
import com.educa62.repositorypattern.model.User;

public class UsersActivity extends AppCompatActivity implements UsersContract.View {

    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private UsersAdapter adapter;
    private List<User> data = new ArrayList<>();

    private UsersPresenter presenter = new UsersPresenter(Injection.provideRepository(), this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_activity);
        recyclerView = findViewById(R.id.recyclerView);
        presenter.getDataListUsers();
        initAdapter();
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(UsersActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.setTitle("Harap tunggu");
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showDataList(List<User> data) {
        this.data.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    private void initAdapter() {
        adapter = new UsersAdapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

}
