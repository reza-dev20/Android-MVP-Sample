package com.dev.mvp.sample;

public interface BasePresenter<T extends BaseView> {
    void onAttach(T view);
    void onDetach();
}
