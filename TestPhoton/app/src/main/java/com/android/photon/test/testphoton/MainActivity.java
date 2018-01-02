package com.android.photon.test.testphoton;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context cntxt;
    EditText noOfRows, noOfColumns;
    Button submitButton;
    int row = 0, col = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cntxt=this;
        setContentView(R.layout.activity_main);

        noOfRows = (EditText) findViewById(R.id.rows);
        noOfColumns = (EditText) findViewById(R.id.columns);
        submitButton = (Button) findViewById(R.id.submit1);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    row = Integer.parseInt(noOfRows.getText().toString());
                    col = Integer.parseInt(noOfColumns.getText().toString());
                    if (col >= 1) {
                        Intent intent = new Intent(cntxt, TheMatrix.class);
                        intent.putExtra("row", row);
                        intent.putExtra("col", col);
                        startActivity(intent);
                    } else if (col < 1)
                        GlobalVariables.showAlert(cntxt, "No input!", "Invalid Input! Please enter a positive integer.");
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    GlobalVariables.showAlert(cntxt, "Symbol/Alphabet", "Invalid Input!.");
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(cntxt, "Please Check input.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
