package app.rockkworld.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.widget.ProgressBar;
import android.widget.TextView;

import app.rockkworld.R;

/**
 * Created by divya on 29/11/15.
 */
public class LoadingDialog extends Dialog {
    private final String DEFAULT_MSG = "Loading..";

    public LoadingDialog(Context context, String loadingMsg) {
        super(context, R.style.DialogThemeTransparent);
        setUp(loadingMsg);
    }

    public LoadingDialog(Context context) {
        super(context, R.style.DialogThemeTransparent);
        setUp(DEFAULT_MSG);
    }

    private void setUp(String loadingMsg) {
        setContentView(R.layout.layout_loadingdialog);
        ((TextView) findViewById(R.id.txt_loadingMsg)).setText(loadingMsg);
        ProgressBar spinner = (ProgressBar) findViewById(R.id.dialog_progressBar);
        spinner.getIndeterminateDrawable().setColorFilter(Color.parseColor("#FF2FCFA8"),
                android.graphics.PorterDuff.Mode.MULTIPLY);
    }
}
