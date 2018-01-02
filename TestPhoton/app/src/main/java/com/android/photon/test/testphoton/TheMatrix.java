package com.android.photon.test.testphoton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TheMatrix extends AppCompatActivity {

    Context cntxt;
    public static int row = 0, col = 0;
    List<EditText> matrixValues;
    public static int arr[][];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cntxt = this;
        row = getIntent().getIntExtra("row", 0);
        col = getIntent().getIntExtra("col", 0);
        arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = 0;
            }
        }
        HorizontalScrollView hScrlV = new HorizontalScrollView(this);
        hScrlV.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        ScrollView vScrlV = new ScrollView(this);
        vScrlV.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        LinearLayout lnrLyt = new LinearLayout(this);
        lnrLyt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        lnrLyt.setOrientation(LinearLayout.VERTICAL);

        TableLayout tblLyt = new TableLayout(this);
        tblLyt.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.MATCH_PARENT));

        matrixValues = new ArrayList<EditText>();
        int tot = 0;
        for (int i = 0; i < row; i++) {
            TableRow tr = new TableRow(this);
            tblLyt.addView(tr);
            TableLayout.LayoutParams trPara = new TableLayout.LayoutParams();
            trPara.setMargins(25, 5, 5, 5);
            tr.setLayoutParams(trPara);

            for (int j = 0; j < col; j++) {
                EditText iv = new EditText(this);
                iv.setInputType(InputType.TYPE_CLASS_NUMBER);
                tot++;
                matrixValues.add(iv);
                tr.addView(iv);
                TableRow.LayoutParams trPara2 = new TableRow.LayoutParams();
                trPara2.width = 150;
                trPara2.setMargins(25, 5, 5, 5);
                trPara2.height = ViewGroup.LayoutParams.MATCH_PARENT;
//                trPara2.weight = 1f;
//                trPara2.gravity = Gravity.CENTER;
                iv.setLayoutParams(trPara2);
            }
        }
        Button submitButton = new Button(this);
        submitButton.setText("Submit");
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tot = 0, nas = 0;
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        try {
                            arr[i][j] = Integer.parseInt(matrixValues.get(tot).getText().toString());
                            tot++;
                        } catch (NumberFormatException nfe) {
                            nfe.printStackTrace();
                            Toast.makeText(cntxt, "Invalid number", Toast.LENGTH_LONG).show();
                            nas = 1;
                            break;
                        }
                    }
                    if (nas == 1)
                        break;
                }
                if (nas == 0) startActivity(new Intent(cntxt, AnotherActivity.class));
            }
        });
        lnrLyt.addView(tblLyt);
        lnrLyt.addView(submitButton);
        vScrlV.addView(lnrLyt);
        hScrlV.addView(vScrlV);
        setContentView(hScrlV);
    }
}
