package com.dev.mvp.sample;
/*
* created to prevent boilerplate code because
* onAttach and onDetach methods are used several times.
* */
public interface BasePresenter<T extends BaseView> {
    void onAttach(T view);
    void onDetach();
}
