package by.mkstudio.mytimetable;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

public class WDNoteActivity extends SingleFragmentActivity {

    public static final String EXTRA_WD_NUMBER = "mk_studio_extra_wd_number2";

    public static Intent newIntent(Context packContext, int wdNum) {
        Intent intent = new Intent(packContext, WDNoteActivity.class);
        intent.putExtra(EXTRA_WD_NUMBER, wdNum);
        return intent;
    }

    protected Fragment createFragment() {
        int wdNum = getIntent().getIntExtra(EXTRA_WD_NUMBER, 0);
        return WDNoteFragment.newInstance(wdNum);
    }
}
