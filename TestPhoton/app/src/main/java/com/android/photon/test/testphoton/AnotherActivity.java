package com.android.photon.test.testphoton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;


public class AnotherActivity extends AppCompatActivity {

    TextView tcost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity);
        tcost = (TextView) findViewById(R.id.cost);
        seeTraverse();
    }

    public void seeTraverse() {
        Path path = new Path(TheMatrix.arr);
        List<String> trList = path.traverse(TheMatrix.arr);
        tcost.setText(" " + trList.get(2) + "\n Traverse Cost:  " + trList.get(0) + " \n and path " + trList.get(1));
    }
}
