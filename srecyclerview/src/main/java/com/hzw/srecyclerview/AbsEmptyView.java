package com.hzw.srecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * author: hzw
 * time: 2018/2/5 下午5:24
 * description:
 */
public abstract class AbsEmptyView extends FrameLayout {

    public AbsEmptyView(@NonNull Context context) {
        this(context, null);
    }

    public AbsEmptyView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AbsEmptyView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ViewGroup.LayoutParams params = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                            ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(params);
        init();
    }

    final public void emptyRetry(boolean isAnim) {
        if (listener != null) {
            listener.emptyRetry(isAnim);
        }
    }

    interface EmptyRetryListener {
        void emptyRetry(boolean isAnim);
    }

    private EmptyRetryListener listener;

    final void setEmptyRetryListener(EmptyRetryListener listener) {
        this.listener = listener;
    }

    public abstract void init();

}
