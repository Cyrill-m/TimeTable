package by.mkstudio.mytimetable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class WDPagerActivity extends AppCompatActivity {

    private static final String EXTRA_WD_NUM = "mk_studio_extra_wd_num";
    private static final int EXTRA_WD_NUM_DEFAULT = 1;

    private ViewPager2 mViewPager;
    private List<WD> mWDs;

    public static Intent newIntent(Context packageContext, int wdNum) {
        Intent intent = new Intent(packageContext, WDPagerActivity.class);
        intent.putExtra(EXTRA_WD_NUM, wdNum);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wd_pager);

        //получаем из интента выбранный день недели
        int wdNum = getIntent().getIntExtra(EXTRA_WD_NUM, EXTRA_WD_NUM_DEFAULT);

        //находим компонент ViewPager
        mViewPager = findViewById(R.id.wd_view_pager);

        //получаем список дней недели
        mWDs = WDList.get(this).getWDays();

        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStateAdapter(fragmentManager, getLifecycle()) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                WD wd = mWDs.get(position);
                return WDFragment.newInstance(wd.getWDNum());
            }

            @Override
            public int getItemCount() {
                return mWDs.size();
            }
        });

        mViewPager.setCurrentItem(wdNum - 1);
        //Поиск выбранного дня недели
        /*for (int i = 0; i < mWDs.size(); i++){
            if (mWDs.get(i).getWDNum() == wdNum){
                mViewPager.setCurrentItem(i);
                break;
            }
        }*/
    }
}
