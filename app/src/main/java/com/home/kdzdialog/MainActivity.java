package com.home.kdzdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kdz.kdzdialogcore.INegativeListener;
import com.kdz.kdzdialogcore.IPositiveListener;
import com.kdz.kdzdialogcore.KDZDialog;

public class MainActivity extends AppCompatActivity {

    private Button btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowDialog = (Button) findViewById(R.id.showDialog);
        final KDZDialog dialogBuilder = KDZDialog.getInstance(this);


//        int temp = Integer.valueOf("asdfasdf");

        dialogBuilder
                .withTitle("Modal Dialog")
                .withMessage("This action cannot undo, are you sure?")
                .withPositiveButtonText("YES")
                .withNegativeButtonText("CANCEL")
                .setPositiveListener(new IPositiveListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(getApplicationContext(), "On positive click", Toast.LENGTH_SHORT).show();
                        dialogBuilder.dismiss();
                    }
                })
                .setNegativeListener(new INegativeListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(getApplicationContext(), "On negative click", Toast.LENGTH_SHORT).show();
                        dialogBuilder.dismiss();
                    }
                })
                .enablePositiveButton(View.VISIBLE)
                .enableNegativeButton(View.GONE);

        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilder.show();
            }
        });
    }
}
