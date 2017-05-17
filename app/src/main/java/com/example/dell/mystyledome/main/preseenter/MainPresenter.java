package com.example.dell.mystyledome.main.preseenter;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/5/16.
 * function:
 */

public interface MainPresenter {
    void onResume();

    void onItemClicked(int position);

    void onDestroy();
}
