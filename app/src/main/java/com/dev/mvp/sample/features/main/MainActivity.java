package com.dev.mvp.sample.features.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import com.dev.mvp.sample.R;
import com.dev.mvp.sample.databinding.MainPageBinding;
import com.dev.mvp.sample.data.model.Task;

public class MainActivity extends AppCompatActivity implements TaskAdapter.TaskItemEventListener {

    private TaskAdapter adapter;
    private MainPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.main_page);

        adapter = new TaskAdapter(this,this);
        binding.taskListRv.setLayoutManager(
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        );
        binding.taskListRv.setAdapter(adapter);

    }

    @Override
    public void onClick(Task task) {

    }

    @Override
    public void onLongClick(Task task) {

    }
}
