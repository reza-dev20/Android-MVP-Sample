package com.dev.mvp.sample.features.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dev.mvp.sample.R;
import com.dev.mvp.sample.data.local.AppDatabase;
import com.dev.mvp.sample.data.model.Task;
import com.dev.mvp.sample.databinding.ActivityTaskDetailBinding;

public class TaskDetailActivity extends AppCompatActivity implements TaskDetailContract.View{

    private ActivityTaskDetailBinding binding;
    private int selectedImportance = Task.IMPORTANCE_NORMAL;
    private ImageView lastSelectedImportanceIv;
    private TaskDetailContract.Presenter presenter;
    public final static int RESULT_ADD_TASK = 100;
    public final static int RESULT_DELETE_TASK = 200;
    public final static int RESULT_UPDATE_TASK = 300;
    public static final String EXTRA_RESULT = "Task_Add_Result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_task_detail);
        presenter = new TaskDetailPresenter(
                AppDatabase.getAppDatabase(this).getTaskDao()
        );
        binding.backBtn.setOnClickListener(v -> finish());
        lastSelectedImportanceIv = binding.normalImportanceCheckIv;
        initImportanceBtn();
        saveChanges();
        presenter.onAttach(this);
    }

    private void initImportanceBtn(){
        binding.highImportanceBtn.setOnClickListener(v -> {
            if (selectedImportance != Task.IMPORTANCE_HIGH) {
                lastSelectedImportanceIv.setImageResource(0);
                ImageView imageView = v.findViewById(R.id.highImportanceCheckIv);
                imageView.setImageResource(R.drawable.ic_check_white_24dp);
                selectedImportance = Task.IMPORTANCE_HIGH;

                lastSelectedImportanceIv = imageView;
            }
        });
        binding.lowImportanceBtn.setOnClickListener(v -> {
            if (selectedImportance != Task.IMPORTANCE_LOW) {
                lastSelectedImportanceIv.setImageResource(0);
                ImageView imageView = v.findViewById(R.id.lowImportanceCheckIv);
                imageView.setImageResource(R.drawable.ic_check_white_24dp);
                selectedImportance = Task.IMPORTANCE_LOW;

                lastSelectedImportanceIv = imageView;
            }
        });
        binding.normalImportanceBtn.setOnClickListener(v -> {
            if (selectedImportance != Task.IMPORTANCE_NORMAL) {
                lastSelectedImportanceIv.setImageResource(0);
                ImageView imageView = v.findViewById(R.id.normalImportanceCheckIv);
                imageView.setImageResource(R.drawable.ic_check_white_24dp);
                selectedImportance = Task.IMPORTANCE_NORMAL;

                lastSelectedImportanceIv = imageView;
            }
        });
    }

    //save task
    private void saveChanges(){
        binding.saveChangesBtn.setOnClickListener(v->{
            presenter.saveChanges(selectedImportance,binding.taskEt.getText().toString());
        });
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }


    @Override
    public void showTask() {

    }

    @Override
    public void setDeleteButtonVisibility(boolean visible) {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void returnResult(int resultCode, Task task) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_RESULT,task);
        setResult(RESULT_ADD_TASK,intent);
        finish();
    }
}
