package by.mkstudio.mytimetable;

import androidx.fragment.app.Fragment;

public class WDListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new WDListFragment();
    }
}