package com.dev.mvp.sample.features.main;

import com.dev.mvp.sample.data.model.Task;

import java.util.List;

public interface MainContract {

    interface View{
        void showTasks(List<Task> tasks);
        void clearTasks();
        void updateTask(Task task);
        void addTask(Task task);
        void deleteTask(Task task);
        void setEmptyStateVisibility(boolean visible);
    }

    interface Presenter{
        void onDeleteAllBtnClick();
        List<Task> onSearch(String q);
        void onTaskItemClick();
        void onAttack(View view);
        void onDetach();
    }
}
