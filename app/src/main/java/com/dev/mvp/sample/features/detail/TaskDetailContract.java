package com.dev.mvp.sample.features.detail;

import com.dev.mvp.sample.BasePresenter;
import com.dev.mvp.sample.BaseView;
import com.dev.mvp.sample.data.model.Task;

public interface TaskDetailContract {

    interface View extends BaseView {
        void showTask();
        void setDeleteButtonVisibility(boolean visible);
        void showError(String error);
    }

    interface Presenter extends BasePresenter<View> {
        void DeleteTask(Task task);
        void saveChanges(int importance,String title);
    }
}
