package com.msky.mypickerview;

import java.util.ArrayList;

import java.util.List;

import android.os.Bundle;

import android.os.Vibrator;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Service;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.ImageView;
import android.widget.ListView;

import android.widget.TextView;


@SuppressLint("NewApi")
public class MainActivity extends Activity implements OnScrollListener,
        OnTouchListener, OnItemClickListener {

    MyAdapter m1111;
    List<ItemBean> dataList;
    boolean lockforsrcoll = false;
    boolean byaotu = false;

    TextView t1;
    int max = 50;
    private ListView listView;

    public static int top = 0;
    ImageView m1;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        listView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        dataList = new ArrayList<ItemBean>();
        t1 = (TextView) findViewById(R.id.textView1);

        vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
        vibrator.vibrate(50);

        m1 = (ImageView) findViewById(R.id.imageView1);
        for (int i = 0; i < max * 3; i++) {
            top = 32;
            if (i == top + 2 || i == top + max + 2) {
                dataList.add(new ItemBean("" + i % max, 2));
            } else if (i == top + 1 || i == top + max + 1) {
                dataList.add(new ItemBean("" + i % max, 1));
            } else if (i == top + 3 || i == top + max + 3) {
                dataList.add(new ItemBean("" + i % max, 1));
            } else if (i == top || i == top + max) {
                dataList.add(new ItemBean("" + i % max, -1));
            } else if (i == top + 4 || i == top + max + 4) {
                dataList.add(new ItemBean("" + i % max, -10));
            } else {

                dataList.add(new ItemBean("" + i % max, 0));

            }
        }

        m1111 = new MyAdapter(this, dataList);
        listView.setAdapter(m1111);

        listView.setVerticalScrollBarEnabled(false);
        // listView.setSelection(32);

        listView.setOnScrollListener(this);
        listView.setOnTouchListener(this);
        listView.setOnItemClickListener(this);

        ObjectAnimator.ofFloat(m1, "Alpha", 1F, 0.0F).setDuration(10).start();

        new Thread(new Runnable() {

            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                listView.smoothScrollToPosition(35);
            }

        }).start();
    }

    public void dotest(View v) {


        max = 10;
        dataList.clear();
        for (int i = 0; i < max * 3; i++) {
            top = 32;
            if (i == top + 2 || i == top + max + 2) {
                dataList.add(new ItemBean("" + i % max, 2));
            } else if (i == top + 1 || i == top + max + 1) {
                dataList.add(new ItemBean("" + i % max, 1));
            } else if (i == top + 3 || i == top + max + 3) {
                dataList.add(new ItemBean("" + i % max, 1));
            } else if (i == top || i == top + max) {
                dataList.add(new ItemBean("" + i % max, -1));
            } else if (i == top + 4 || i == top + max + 4) {
                dataList.add(new ItemBean("" + i % max, -10));
            } else {

                dataList.add(new ItemBean("" + i % max, 0));

            }
        }
        m1111.notifyDataSetChanged();
        movetopostion(max + 2 % max - 2);

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        // TODO Auto-generated method stub


        if (scrollState == SCROLL_STATE_FLING && byaotu == false) {

            ObjectAnimator.ofFloat(m1, "Alpha", 0.3F, 0.0F).setDuration(100)
                    .start();

        } else if (scrollState == SCROLL_STATE_IDLE) {

            if (byaotu == false) {

                ObjectAnimator.ofFloat(m1, "Alpha", 0.1F, 0.0F)
                        .setDuration(500).start();

                if (top == 0) {

                }
                if (top == 85) {

                } else if (top != 0) {

                    dataList.clear();
                    datachange();

                    m1111.notifyDataSetChanged();

                    listView.smoothScrollToPosition(top);
                    byaotu = true;

                }

            } else {
                byaotu = false;
            }

        } else if (scrollState == SCROLL_STATE_TOUCH_SCROLL && byaotu == false) {

            if (lockforsrcoll == false) {

                dataList.clear();
                for (int i = 0; i < max * 3; i++) {

                    dataList.add(new ItemBean("" + i % max, 0));
                }
                m1111.notifyDataSetChanged();
                ObjectAnimator.ofFloat(m1, "Alpha", 0.3F, 0.2F)
                        .setDuration(100).start();
            }
        }
    }

    public void datachange() {
        for (int i = 0; i < max * 3; i++) {
            if (i == top + 2 || i == top + max + 2) {
                dataList.add(new ItemBean("" + i % max, 2));
            } else if (i == top + 1 || i == top + max + 1) {
                dataList.add(new ItemBean("" + i % max, 1));
            } else if (i == top + 3 || i == top + max + 3) {
                dataList.add(new ItemBean("" + i % max, 1));
            } else if (i == top || i == top + max) {
                dataList.add(new ItemBean("" + i % max, -1));
            } else if (i == top + 4 || i == top + max + 4) {
                dataList.add(new ItemBean("" + i % max, -10));
            } else {

                dataList.add(new ItemBean("" + i % max, 0));

            }
        }
    }

    public void datachange(int mtop1) {
        for (int i = 0; i < max * 3; i++) {
            if (i == mtop1 + 2 || i == mtop1 + max + 2) {
                dataList.add(new ItemBean("" + i % max, 2));
            } else if (i == mtop1 + 1 || i == mtop1 + max + 1) {
                dataList.add(new ItemBean("" + i % max, 1));
            } else if (i == mtop1 + 3 || i == mtop1 + 20 + 3) {
                dataList.add(new ItemBean("" + i % max, 1));
            } else if (i == mtop1 || i == mtop1 + max) {
                dataList.add(new ItemBean("" + i % max, -1));
            } else if (i == mtop1 + 4 || i == mtop1 + max + 4) {
                dataList.add(new ItemBean("" + i % max, -10));
            } else {

                dataList.add(new ItemBean("" + i % 20, 0));

            }
        }

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        // TODO Auto-generated method stub
        // listView.setSelection(firstVisibleItem);
        top = firstVisibleItem;
        // t1.setText("" + getScrollY());
        if (firstVisibleItem <= 2) {
            listView.setSelection(max + 2);
        } else if (firstVisibleItem + visibleItemCount > m1111.getCount() - 2) {
            listView.setSelection(firstVisibleItem - max);
        }

    }

    public void movetopostion(int mtop) {

        dataList.clear();
        datachange(mtop);

        m1111.notifyDataSetChanged();

        listView.setSelection(mtop);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // TODO Auto-generated method stub
        // t1.setText(""+event.getY());
        return false;
    }

    public int getScrollY() {
        View c = listView.getChildAt(0);
        if (c == null) {
            return 0;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int top = c.getTop();
        return -top + firstVisiblePosition * c.getHeight();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO Auto-generated method stub

        movetopostion(max + position % max - 2);

        t1.setText("" + position);

    }
}
