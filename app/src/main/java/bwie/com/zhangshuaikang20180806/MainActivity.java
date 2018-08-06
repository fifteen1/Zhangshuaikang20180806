package bwie.com.zhangshuaikang20180806;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import bwie.com.zhangshuaikang20180806.view.FlowLayout;

public class MainActivity extends AppCompatActivity {
    private String mNames[] = {"流感","布洛芬","感冒","上火","失眠","中风","鼻炎"};
    private FlowLayout flowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> list = new ArrayList<String>();

        initChildView();
    }

    private void initChildView() {
        flowLayout = findViewById(R.id.flowLayout);
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 5;
        lp.rightMargin = 5;
        lp.bottomMargin = 5;
        lp.topMargin = 5;

        for (int i = 0; i <mNames.length ; i++) {
            TextView textView = new TextView(this);
            textView.setText(mNames[i]);
            textView.setTextColor(Color.WHITE);
            textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_bg));
            flowLayout.addView(textView,lp);
        }


    }
}
