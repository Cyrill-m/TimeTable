package by.mkstudio.mytimetable;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class WDListFragment extends Fragment {
    private RecyclerView mWDRecyclerView;
    private WDListAdapter mWDListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wd_list, container, false);
        mWDRecyclerView = view.findViewById(R.id.wd_recycler_view);

        //LayoutManager - управляет позиционированием эл-ов и определяет поведение прокрутки
        mWDRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        updateUI();
        //установка позиции текущего дня
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == 1) {
            day = 6;
        } else {day = day - 2;}

        mWDRecyclerView.scrollToPosition(day);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    //настройка пользовательского интерфейса
    private void updateUI() {
        WDList wdList = WDList.get(getActivity());  //Получаем или создаем новый синглетный объект WDList
        List<WD> wds = wdList.getWDays();           //Получаем из WDList список дней недели (объекты WD)

        if (mWDListAdapter == null) {
            mWDListAdapter = new WDListAdapter(wds);    //Создание адаптера WDListAdapter
            mWDRecyclerView.setAdapter(mWDListAdapter); //установка адаптера для RecyclerView
        } else {
            mWDListAdapter.setWDays(wds);
            mWDListAdapter.notifyDataSetChanged();
        }

    }

    //*** Реализация ViewHolder ***
    //отвечает за отображение и заполнение макета
    //поле itemView - хранит ссылку на все представление View созданное super(view)
    private class WDListHolder extends RecyclerView.ViewHolder {

        private WD mWD;
        private TextView mWDNameShort;
        private TextView mWDNameLong;
        private TextView mLesson1Text;
        private TextView mLesson2Text;
        private TextView mLesson3Text;
        private TextView mLesson4Text;
        private TextView mLesson5Text;
        private TextView mLesson6Text;
        private TextView mLesson7Text;
        private TextView mLesson8Text;
        private TextView mLesson9Text;
        private TextView mNoteWD;
        private TextView mNote1Text;
        private TextView mNote2Text;
        private TextView mNote3Text;

        private ImageView mWDImage;

        //Конструктор ViewHolder
        //извлечение всех виджетов представляющих интерес
        public WDListHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_wd, parent, false));

            //Иконка дня недели
            mWDImage = itemView.findViewById(R.id.ivWD);

            //День недели (короткий формат - ПН, ВТ, СР, ...)
            mWDNameShort = itemView.findViewById(R.id.tvWDshort);

            //День недели (длинный формат - Понедельник, Вторник, ...)
            mWDNameLong = itemView.findViewById(R.id.tvWDlong);
            mNoteWD = itemView.findViewById(R.id.tvNoteWD);

            //Поля названий уроков
            mLesson1Text = itemView.findViewById(R.id.tvLessText1);
            mLesson2Text = itemView.findViewById(R.id.tvLessText2);
            mLesson3Text = itemView.findViewById(R.id.tvLessText3);
            mLesson4Text = itemView.findViewById(R.id.tvLessText4);
            mLesson5Text = itemView.findViewById(R.id.tvLessText5);
            mLesson6Text = itemView.findViewById(R.id.tvLessText6);
            mLesson7Text = itemView.findViewById(R.id.tvLessText7);
            mLesson8Text = itemView.findViewById(R.id.tvLessText8);
            mLesson9Text = itemView.findViewById(R.id.tvLessText9);

            //Поля названий заметок
            mNote1Text = itemView.findViewById(R.id.tvNoteText1);
            mNote2Text = itemView.findViewById(R.id.tvNoteText2);
            mNote3Text = itemView.findViewById(R.id.tvNoteText3);

            //Иконка кнопки редактирования уроков
            ImageView editImage = itemView.findViewById(R.id.ivEdit);
            editImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Intent intent = WDPagerActivity.newIntent(getActivity(), mWD.getWDNum());
                    Intent intent = WDActivity.newIntent(getActivity(), mWD.getWDNum());
                    startActivity(intent);
                }
            });

            //Иконка кнопки редактирования заметок
            ImageView editNoteImage = itemView.findViewById(R.id.ivEditNote);
            editNoteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = WDNoteActivity.newIntent(getActivity(), mWD.getWDNum());
                    startActivity(intent);
                }
            });

        }


        //метод bind(WD wd) вызывается каждый раз, когда RecyclerView потребует связать
        //заданный объект WDListHolder с объектом конкретного дня недели WD.
        //Обновляет информацию в виджетах
        public void bind(WD wd) {
            mWD = wd;
            mWDNameShort.setText(mWD.getWDName());
            mWDNameLong.setText(mWD.getWDNameLong());
            mWDImage.setImageResource(mWD.getWDImg());

            mLesson1Text.setText(mWD.getTask(0).getTaskTextAndTime());
            mLesson2Text.setText(mWD.getTask(1).getTaskTextAndTime());
            mLesson3Text.setText(mWD.getTask(2).getTaskTextAndTime());
            mLesson4Text.setText(mWD.getTask(3).getTaskTextAndTime());
            mLesson5Text.setText(mWD.getTask(4).getTaskTextAndTime());
            mLesson6Text.setText(mWD.getTask(5).getTaskTextAndTime());
            mLesson7Text.setText(mWD.getTask(6).getTaskTextAndTime());
            mLesson8Text.setText(mWD.getTask(7).getTaskTextAndTime());
            mLesson9Text.setText(mWD.getTask(8).getTaskTextAndTime());

            mNoteWD.setText(mWD.getWDNameLong());

            mNote1Text.setText(mWD.getTask(9).getTaskTextAndTime());
            mNote2Text.setText(mWD.getTask(10).getTaskTextAndTime());
            mNote3Text.setText(mWD.getTask(11).getTaskTextAndTime());
        }
    }


    //*** Реализация Adapter ***
    //создает объекты WDListHolder
    //связывает WDListHolder с данными из уровня модели (WDList)
    private class WDListAdapter extends RecyclerView.Adapter<WDListHolder> {

        private List<WD> mWDays;    //список дней недели (объекты WD)

        //Конструктор WDListAdapter
        public WDListAdapter(List<WD> wdList) {
            mWDays = wdList;
        }

        @NonNull
        @Override
        public WDListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new WDListHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull WDListHolder holder, int position) {
            WD wd = mWDays.get(position);   //Получаем объект WD для соответствующей позиции в RecyclerView
            holder.bind(wd);                //Связываем данные объекта WD с элементами интерфейса
        }

        //Количество элементов в списке RecyclerView
        @Override
        public int getItemCount() {
            return mWDays.size();
        }

        public void setWDays(List<WD> wDays) {
            mWDays = wDays;
        }
    }
}
