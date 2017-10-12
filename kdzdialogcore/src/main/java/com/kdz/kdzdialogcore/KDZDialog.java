package com.kdz.kdzdialogcore;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by CPU11403-local on 10/12/2017.
 */

public class KDZDialog extends Dialog {

    private static Activity mActivity;
    private IPositiveListener iPositiveListener = null;
    private INegativeListener iNegativeListener = null;

    private View mDialogView;
    private TextView txtTitle;
    private TextView txtMessage;
    private Button btnNegativeButton;
    private Button btnPositiveButton;

    private static KDZDialog instance;

    public KDZDialog(Activity activity) {
        super(activity);
        init(activity);
    }

    public static KDZDialog getInstance(Activity activity) {
        if (instance == null || !mActivity.equals(activity)) {
            synchronized (KDZDialog.class) {
                if (instance == null || !mActivity.equals(activity)) {
                    instance = new KDZDialog(activity);
                }
            }
        }
        mActivity = activity;
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    public void init(Activity activity) {
        mDialogView = View.inflate(activity, R.layout.ios_dialog, null);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        txtTitle = (TextView) mDialogView.findViewById(R.id.txt_title);
        txtMessage = (TextView) mDialogView.findViewById(R.id.txt_message);
        btnNegativeButton = (Button) mDialogView.findViewById(R.id.btn_negative);
        btnPositiveButton = (Button) mDialogView.findViewById(R.id.btn_positive);

        btnNegativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iNegativeListener.onClick();
            }
        });

        btnPositiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iPositiveListener.onClick();
            }
        });

        setContentView(mDialogView);
    }

    public KDZDialog withTitle(String title) {
        txtTitle.setText(title);
        return this;
    }

    public KDZDialog withMessage(String msg) {
        txtMessage.setText(msg);
        return this;
    }

    public KDZDialog withPositiveButtonText(String text) {
        btnPositiveButton.setText(text);
        return this;
    }

    public KDZDialog withNegativeButtonText(String text) {
        btnNegativeButton.setText(text);
        return this;
    }

    public KDZDialog setPositiveListener(IPositiveListener positiveListener) {
        iPositiveListener = positiveListener;
        return this;
    }

    public KDZDialog setNegativeListener(INegativeListener negativeListener) {
        iNegativeListener = negativeListener;
        return this;
    }

    public KDZDialog enablePositiveButton(int visiblity) {
        btnPositiveButton.setVisibility(visiblity);
        return this;
    }

    public KDZDialog enableNegativeButton(int visiblity) {
        btnNegativeButton.setVisibility(visiblity);
        return this;
    }
}
