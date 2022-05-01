package com.dev.mvp.sample.features.detail;

import com.dev.mvp.sample.data.local.dao.TaskDao;
import com.dev.mvp.sample.data.model.Task;

public class TaskDetailPresenter implements TaskDetailContract.Presenter{
    private TaskDao taskDao;
    private TaskDetailContract.View view;


    public TaskDetailPresenter(TaskDao taskDao){
        this.taskDao = taskDao;
    }

    @Override
    public void onAttach(TaskDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void onDetach() {

    }

    @Override
    public void DeleteTask(Task task) {

    }

    @Override
    public void saveChanges(int importance, String title) {
        if (!title.isEmpty()){
            Task task = new Task();
            task.setTitle(title);
            task.setImportance(importance);
            long id = taskDao.add(task);
            task.setId(id);
            view.returnResult(TaskDetailActivity.RESULT_ADD_TASK,task);
        }
        else
            view.showError("title is Empty!");
    }
}
