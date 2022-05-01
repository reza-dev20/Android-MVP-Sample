package com.dev.mvp.sample.features.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import com.dev.mvp.sample.R;
import com.dev.mvp.sample.databinding.MainPageBinding;
import com.dev.mvp.sample.data.model.Task;

import java.util.List;

public class MainActivity extends AppCompatActivity implements TaskAdapter.TaskItemEventListener,MainContract.View {

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

    @Override
    public void showTasks(List<Task> tasks) {

    }

    @Override
    public void clearTasks() {

    }

    @Override
    public void updateTask(Task task) {

    }

    @Override
    public void addTask(Task task) {

    }

    @Override
    public void deleteTask(Task task) {

    }

    @Override
    public void setEmptyStateVisibility(boolean visible) {

    }
}
