package com.dev.mvp.sample.features.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dev.mvp.sample.R;
import com.dev.mvp.sample.data.model.Task;
import com.dev.mvp.sample.databinding.ActivityTaskDetailBinding;

public class TaskDetailActivity extends AppCompatActivity implements TaskDetailContract.View{

    private ActivityTaskDetailBinding binding;
    private int selectedImportance = Task.IMPORTANCE_NORMAL;
    private ImageView lastSelectedImportanceIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_task_detail);
        binding.backBtn.setOnClickListener(v -> finish());

        lastSelectedImportanceIv = binding.normalImportanceCheckIv;

        View highImportanceBtn = findViewById(R.id.highImportanceBtn);
        highImportanceBtn.setOnClickListener(v -> {
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

    @Override
    protected void onDestroy() {
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
}
