package com.example.javademo.viewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.javademo.viewdemo.view.SquireView;

/**
 * 自定义折线图，学习到了android view的坐标 paint和canvas和自定义view的一些知识
 * Created by 侯占磊 on 2017/9/21.
 */

public class ChatActivity extends AppCompatActivity{

    private SquireView chatView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_chat);
        init();
    }

    private void init() {
        chatView=(SquireView)findViewById(R.id.chat);
        int[][] columnInfo=new int[][]{
                {6, Color.BLUE},
                {5, Color.GREEN},
                {9, Color.RED},
                {2, Color.GRAY},
                {4, Color.DKGRAY},
                {1, Color.MAGENTA},
                {3, Color.CYAN},
                {8, Color.YELLOW},
        };
        chatView.setColorInfo(columnInfo);
        chatView.setXVale(8,8);
        chatView.setYVale(10,10000);
    }
}
