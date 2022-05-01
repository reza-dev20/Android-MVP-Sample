package com.dev.mvp.sample.features.main;

import com.dev.mvp.sample.data.local.dao.TaskDao;
import com.dev.mvp.sample.data.model.Task;

import java.util.List;

public class MainPresenter implements MainContract.Presenter{
    private TaskDao taskDao;
    private List<Task> tasks;
    private MainContract.View view;

    public MainPresenter(TaskDao taskDao){
        this.taskDao = taskDao;
        tasks = taskDao.getAll();
    }

    @Override
    public void onDeleteAllBtnClick() {
        taskDao.deleteAll();
        view.clearTasks();
        view.setEmptyStateVisibility(true);
    }

    @Override
    public List<Task> onSearch(String q) {
        return null;
    }

    @Override
    public void onTaskItemClick() {

    }

    @Override
    public void onAttach(MainContract.View view) {
        this.view = view;
        if (!tasks.isEmpty()) {
            view.setEmptyStateVisibility(false);
            view.showTasks(tasks);
        }
        else
            view.setEmptyStateVisibility(true);
    }

    @Override
    public void onDetach() {
        view = null;
    }
}
