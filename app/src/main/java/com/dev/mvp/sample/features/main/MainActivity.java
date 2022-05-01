package com.dev.mvp.sample.features.main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dev.mvp.sample.R;
import com.dev.mvp.sample.data.local.AppDatabase;
import com.dev.mvp.sample.databinding.MainPageBinding;
import com.dev.mvp.sample.data.model.Task;
import com.dev.mvp.sample.features.detail.TaskDetailActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements TaskAdapter.TaskItemEventListener,MainContract.View {

    private TaskAdapter adapter;
    private MainPageBinding binding;
    private MainContract.Presenter presenter;
    private final int REQUEST_CODE = 310;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.main_page);
        presenter = new MainPresenter(AppDatabase.getAppDatabase(this).getTaskDao());
        initRecyclerView();

        newTaskBtnOnClick();
        deleteAllBtnOnClick();
        presenter.onAttach(this);
    }

    //setup recyclerview
    private void initRecyclerView(){
        adapter = new TaskAdapter(this,this);
        binding.taskListRv.setLayoutManager(
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        );
        binding.taskListRv.setAdapter(adapter);
    }

    private void newTaskBtnOnClick(){
        binding.addNewTaskBtn.setOnClickListener(v->{
            startActivityForResult(
                    new Intent(MainActivity.this,
                            TaskDetailActivity.class),REQUEST_CODE);
        });
    }
    //delete all task
    private void deleteAllBtnOnClick(){
        binding.deleteAllBtn.setOnClickListener(v->{
            presenter.onDeleteAllBtnClick();
        });
    }

    @Override
    public void onClick(Task task) {

    }

    @Override
    public void onLongClick(Task task) {

    }

    @Override
    public void showTasks(List<Task> tasks) {
        adapter.setTasks(tasks);
    }

    @Override
    public void clearTasks() {
        adapter.clearItems();
    }

    @Override
    public void updateTask(Task task) {
        adapter.updateItem(task);
    }

    @Override
    public void addTask(Task task) {
        adapter.addItem(task);
    }

    @Override
    public void deleteTask(Task task) {
        adapter.deleteItem(task);
    }

    @Override
    public void setEmptyStateVisibility(boolean visible) {
        binding.emptyState.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (data!=null){
                Task task = data.getParcelableExtra(TaskDetailActivity.EXTRA_RESULT);
                if (task!=null){
                    switch (resultCode){
                        case TaskDetailActivity.RESULT_ADD_TASK:
                            addTask(task);
                            break;
                        case TaskDetailActivity.RESULT_UPDATE_TASK:
                            updateTask(task);
                            break;
                        case TaskDetailActivity.RESULT_DELETE_TASK:
                            deleteTask(task);
                            break;
                    }
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
