package com.genglun.teach_en.tab;

import android.graphics.Color;
import android.support.v4.app.Fragment;

/**
 * Created by garytan on 15/9/20.
 */
public class BaseFragment extends Fragment {

    private String title = "";
    private int indicatorColor = Color.BLUE;
    private int dividerColor = Color.GRAY;
    private int iconResId = 0;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getIndicatorColor() {
        return indicatorColor;
    }
    public void setIndicatorColor(int indicatorColor) {
        this.indicatorColor = indicatorColor;
    }
    public int getDividerColor() {
        return dividerColor;
    }
    public void setDividerColor(int dividerColor) {
        this.dividerColor = dividerColor;
    }
    //
    public int getIconResId() {
        return iconResId;
    }
    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }
}