package com.example.dell.mystyledome.main;

import java.util.List;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/5/16.
 * function:
 */

public interface FindItemsInteractor {
    interface OnFinishedListener {
        void onFinished(List<String> items);
    }

    void findItems(OnFinishedListener listener);
}
