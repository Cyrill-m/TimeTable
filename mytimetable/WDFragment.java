package by.mkstudio.mytimetable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class WDFragment extends Fragment {

    private static final String WD_NUMBER = "wd_num";
    private static final String DIALOG_TIME = "dialog_time";
    private static final int REQUEST_CODE = 0;

    private WD mWD;

    //компоненты
    private Button btnTimeStart1;
    private Button btnTimeEnd1;
    private Button btnTimeStart2;
    private Button btnTimeEnd2;
    private Button btnTimeStart3;
    private Button btnTimeEnd3;
    private Button btnTimeStart4;
    private Button btnTimeEnd4;
    private Button btnTimeStart5;
    private Button btnTimeEnd5;
    private Button btnTimeStart6;
    private Button btnTimeEnd6;
    private Button btnTimeStart7;
    private Button btnTimeEnd7;
    private Button btnTimeStart8;
    private Button btnTimeEnd8;
    private Button btnTimeStart9;
    private Button btnTimeEnd9;


    //метод newInstance создаёт экземпляр фрагмента WDFragment,
    //упаковывает и задает его аргументы (номер дня недели)
    public static WDFragment newInstance(int wdNum) {
        Bundle args = new Bundle();
        args.putInt(WD_NUMBER, wdNum);
        WDFragment fragment = new WDFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int wdNum = getArguments().getInt(WD_NUMBER);
        mWD = WDList.get(getActivity()).getWD(wdNum);
    }

    @Override
    public void onPause() {
        super.onPause();
        //обновление экземпляра WD в БД
        WDList.get(getActivity()).updateWD(mWD);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //1- идентификатор ресурса макета
        //2- родитель представления
        //3- нужно ли включать заполненное представление в родителя
        View v = inflater.inflate(R.layout.fragment_wd, container, false);

        //поле заголовка - день недели
        TextView mtvWDName = v.findViewById(R.id.tvWDName);
        mtvWDName.setText(WDList.get(getActivity()).getWDName(mWD.getWDNum(), true));

        /*  УРОК 1  */
        //поле редактирования Урока 1
        EditText etLesson1 = v.findViewById(R.id.etLesson1);
        etLesson1.setText(mWD.getTask(0).getTaskText());
        etLesson1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //
            }

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                mWD.getTask(0).setTaskText(text.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //
            }
        });

        //CheckBox - время начала Урока 1
        CheckBox cbTimeStart1 = v.findViewById(R.id.cbTimeStart1);
        cbTimeStart1.setChecked(mWD.getTask(0).isTimeStart());
        cbTimeStart1.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(0).setTimeStartFlag(isChecked));

        //CheckBox - время конца Урока 1
        CheckBox cbTimeEnd1 = v.findViewById(R.id.cbTimeEnd1);
        cbTimeEnd1.setChecked(mWD.getTask(0).isTimeEnd());
        cbTimeEnd1.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(0).setTimeEndFlag(isChecked));

        //Button - установка времени начала Урока 1
        btnTimeStart1 = v.findViewById(R.id.btnTimeStart1);
        btnTimeStart1.setText(mWD.getTask(0).getTimeStart());
        btnTimeStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(0).getTimeHourStart(),
                        mWD.getTask(0).getTimeMinuteStart(),
                        R.string.time_start_ru,
                        11);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        //Button - установка времени конца Урока 1
        btnTimeEnd1 = v.findViewById(R.id.btnTimeEnd1);
        btnTimeEnd1.setText(mWD.getTask(0).getTimeEnd());
        btnTimeEnd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(0).getTimeHourEnd(),
                        mWD.getTask(0).getTimeMinuteEnd(),
                        R.string.time_end_ru,
                        12);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        /*  УРОК 2  */
        //поле редактирования Урока 2
        EditText etLesson2 = v.findViewById(R.id.etLesson2);
        etLesson2.setText(mWD.getTask(1).getTaskText());
        etLesson2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //
            }

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                mWD.getTask(1).setTaskText(text.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //
            }
        });

        //CheckBox - время начала Урока 2
        CheckBox cbTimeStart2 = v.findViewById(R.id.cbTimeStart2);
        cbTimeStart2.setChecked(mWD.getTask(1).isTimeStart());
        cbTimeStart2.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(1).setTimeStartFlag(isChecked));

        //CheckBox - время конца Урока 2
        CheckBox cbTimeEnd2 = v.findViewById(R.id.cbTimeEnd2);
        cbTimeEnd2.setChecked(mWD.getTask(1).isTimeEnd());
        cbTimeEnd2.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(1).setTimeEndFlag(isChecked));

        //Button - установка времени начала Урока 2
        btnTimeStart2 = v.findViewById(R.id.btnTimeStart2);
        btnTimeStart2.setText(mWD.getTask(1).getTimeStart());
        btnTimeStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(1).getTimeHourStart(),
                        mWD.getTask(1).getTimeMinuteStart(),
                        R.string.time_start_ru,
                        21);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        //Button - установка времени конца Урока 2
        btnTimeEnd2 = v.findViewById(R.id.btnTimeEnd2);
        btnTimeEnd2.setText(mWD.getTask(1).getTimeEnd());
        btnTimeEnd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(1).getTimeHourEnd(),
                        mWD.getTask(1).getTimeMinuteEnd(),
                        R.string.time_end_ru,
                        22);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        /*  УРОК 3  */
        //поле редактирования Урока 3
        EditText etLesson3 = v.findViewById(R.id.etLesson3);
        etLesson3.setText(mWD.getTask(2).getTaskText());
        etLesson3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //
            }

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                mWD.getTask(2).setTaskText(text.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //
            }
        });

        //CheckBox - время начала Урока 3
        CheckBox cbTimeStart3 = v.findViewById(R.id.cbTimeStart3);
        cbTimeStart3.setChecked(mWD.getTask(2).isTimeStart());
        cbTimeStart3.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(2).setTimeStartFlag(isChecked));

        //CheckBox - время конца Урока 3
        CheckBox cbTimeEnd3 = v.findViewById(R.id.cbTimeEnd3);
        cbTimeEnd3.setChecked(mWD.getTask(2).isTimeEnd());
        cbTimeEnd3.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(2).setTimeEndFlag(isChecked));

        //Button - установка времени начала Урока 3
        btnTimeStart3 = v.findViewById(R.id.btnTimeStart3);
        btnTimeStart3.setText(mWD.getTask(2).getTimeStart());
        btnTimeStart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(2).getTimeHourStart(),
                        mWD.getTask(2).getTimeMinuteStart(),
                        R.string.time_start_ru,
                        31);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        //Button - установка времени конца Урока 3
        btnTimeEnd3 = v.findViewById(R.id.btnTimeEnd3);
        btnTimeEnd3.setText(mWD.getTask(2).getTimeEnd());
        btnTimeEnd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(2).getTimeHourEnd(),
                        mWD.getTask(2).getTimeMinuteEnd(),
                        R.string.time_end_ru,
                        32);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        /*  УРОК 4  */
        //поле редактирования Урока 4
        EditText etLesson4 = v.findViewById(R.id.etLesson4);
        etLesson4.setText(mWD.getTask(3).getTaskText());
        etLesson4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //
            }

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                mWD.getTask(3).setTaskText(text.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //
            }
        });

        //CheckBox - время начала Урока 4
        CheckBox cbTimeStart4 = v.findViewById(R.id.cbTimeStart4);
        cbTimeStart4.setChecked(mWD.getTask(3).isTimeStart());
        cbTimeStart4.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(3).setTimeStartFlag(isChecked));

        //CheckBox - время конца Урока 4
        CheckBox cbTimeEnd4 = v.findViewById(R.id.cbTimeEnd4);
        cbTimeEnd4.setChecked(mWD.getTask(3).isTimeEnd());
        cbTimeEnd4.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(3).setTimeEndFlag(isChecked));

        //Button - установка времени начала Урока 4
        btnTimeStart4 = v.findViewById(R.id.btnTimeStart4);
        btnTimeStart4.setText(mWD.getTask(3).getTimeStart());
        btnTimeStart4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(3).getTimeHourStart(),
                        mWD.getTask(3).getTimeMinuteStart(),
                        R.string.time_start_ru,
                        41);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        //Button - установка времени конца Урока 4
        btnTimeEnd4 = v.findViewById(R.id.btnTimeEnd4);
        btnTimeEnd4.setText(mWD.getTask(3).getTimeEnd());
        btnTimeEnd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(3).getTimeHourEnd(),
                        mWD.getTask(3).getTimeMinuteEnd(),
                        R.string.time_end_ru,
                        42);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        /*  УРОК 5  */
        //поле редактирования Урока 5
        EditText etLesson5 = v.findViewById(R.id.etLesson5);
        etLesson5.setText(mWD.getTask(4).getTaskText());
        etLesson5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //
            }

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                mWD.getTask(4).setTaskText(text.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //
            }
        });

        //CheckBox - время начала Урока 5
        CheckBox cbTimeStart5 = v.findViewById(R.id.cbTimeStart5);
        cbTimeStart5.setChecked(mWD.getTask(4).isTimeStart());
        cbTimeStart5.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(4).setTimeStartFlag(isChecked));

        //CheckBox - время конца Урока 5
        CheckBox cbTimeEnd5 = v.findViewById(R.id.cbTimeEnd5);
        cbTimeEnd5.setChecked(mWD.getTask(4).isTimeEnd());
        cbTimeEnd5.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(4).setTimeEndFlag(isChecked));

        //Button - установка времени начала Урока 5
        btnTimeStart5 = v.findViewById(R.id.btnTimeStart5);
        btnTimeStart5.setText(mWD.getTask(4).getTimeStart());
        btnTimeStart5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(4).getTimeHourStart(),
                        mWD.getTask(4).getTimeMinuteStart(),
                        R.string.time_start_ru,
                        51);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        //Button - установка времени конца Урока 5
        btnTimeEnd5 = v.findViewById(R.id.btnTimeEnd5);
        btnTimeEnd5.setText(mWD.getTask(4).getTimeEnd());
        btnTimeEnd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(4).getTimeHourEnd(),
                        mWD.getTask(4).getTimeMinuteEnd(),
                        R.string.time_end_ru,
                        52);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        /*  УРОК 6  */
        //поле редактирования Урока 6
        EditText etLesson6 = v.findViewById(R.id.etLesson6);
        etLesson6.setText(mWD.getTask(5).getTaskText());
        etLesson6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //
            }

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                mWD.getTask(5).setTaskText(text.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //
            }
        });

        //CheckBox - время начала Урока 6
        CheckBox cbTimeStart6 = v.findViewById(R.id.cbTimeStart6);
        cbTimeStart6.setChecked(mWD.getTask(5).isTimeStart());
        cbTimeStart6.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(5).setTimeStartFlag(isChecked));

        //CheckBox - время конца Урока 6
        CheckBox cbTimeEnd6 = v.findViewById(R.id.cbTimeEnd6);
        cbTimeEnd6.setChecked(mWD.getTask(5).isTimeEnd());
        cbTimeEnd6.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(5).setTimeEndFlag(isChecked));

        //Button - установка времени начала Урока 6
        btnTimeStart6 = v.findViewById(R.id.btnTimeStart6);
        btnTimeStart6.setText(mWD.getTask(5).getTimeStart());
        btnTimeStart6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(5).getTimeHourStart(),
                        mWD.getTask(5).getTimeMinuteStart(),
                        R.string.time_start_ru,
                        61);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        //Button - установка времени конца Урока 6
        btnTimeEnd6 = v.findViewById(R.id.btnTimeEnd6);
        btnTimeEnd6.setText(mWD.getTask(5).getTimeEnd());
        btnTimeEnd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(5).getTimeHourEnd(),
                        mWD.getTask(5).getTimeMinuteEnd(),
                        R.string.time_end_ru,
                        62);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        /*  УРОК 7  */
        //поле редактирования Урока 7
        EditText etLesson7 = v.findViewById(R.id.etLesson7);
        etLesson7.setText(mWD.getTask(6).getTaskText());
        etLesson7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //
            }

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                mWD.getTask(6).setTaskText(text.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //
            }
        });

        //CheckBox - время начала Урока 7
        CheckBox cbTimeStart7 = v.findViewById(R.id.cbTimeStart7);
        cbTimeStart7.setChecked(mWD.getTask(6).isTimeStart());
        cbTimeStart7.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(6).setTimeStartFlag(isChecked));

        //CheckBox - время конца Урока 7
        CheckBox cbTimeEnd7 = v.findViewById(R.id.cbTimeEnd7);
        cbTimeEnd7.setChecked(mWD.getTask(6).isTimeEnd());
        cbTimeEnd7.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(6).setTimeEndFlag(isChecked));

        //Button - установка времени начала Урока 7
        btnTimeStart7 = v.findViewById(R.id.btnTimeStart7);
        btnTimeStart7.setText(mWD.getTask(6).getTimeStart());
        btnTimeStart7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(6).getTimeHourStart(),
                        mWD.getTask(6).getTimeMinuteStart(),
                        R.string.time_start_ru,
                        71);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        //Button - установка времени конца Урока 7
        btnTimeEnd7 = v.findViewById(R.id.btnTimeEnd7);
        btnTimeEnd7.setText(mWD.getTask(6).getTimeEnd());
        btnTimeEnd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(6).getTimeHourEnd(),
                        mWD.getTask(6).getTimeMinuteEnd(),
                        R.string.time_end_ru,
                        72);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        /*  УРОК 8  */
        //поле редактирования Урока 8
        EditText etLesson8 = v.findViewById(R.id.etLesson8);
        etLesson8.setText(mWD.getTask(7).getTaskText());
        etLesson8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //
            }

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                mWD.getTask(7).setTaskText(text.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //
            }
        });

        //CheckBox - время начала Урока 8
        CheckBox cbTimeStart8 = v.findViewById(R.id.cbTimeStart8);
        cbTimeStart8.setChecked(mWD.getTask(7).isTimeStart());
        cbTimeStart8.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(7).setTimeStartFlag(isChecked));

        //CheckBox - время конца Урока 8
        CheckBox cbTimeEnd8 = v.findViewById(R.id.cbTimeEnd8);
        cbTimeEnd8.setChecked(mWD.getTask(7).isTimeEnd());
        cbTimeEnd8.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(7).setTimeEndFlag(isChecked));

        //Button - установка времени начала Урока 8
        btnTimeStart8 = v.findViewById(R.id.btnTimeStart8);
        btnTimeStart8.setText(mWD.getTask(7).getTimeStart());
        btnTimeStart8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(7).getTimeHourStart(),
                        mWD.getTask(7).getTimeMinuteStart(),
                        R.string.time_start_ru,
                        81);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        //Button - установка времени конца Урока 8
        btnTimeEnd8 = v.findViewById(R.id.btnTimeEnd8);
        btnTimeEnd8.setText(mWD.getTask(7).getTimeEnd());
        btnTimeEnd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(7).getTimeHourEnd(),
                        mWD.getTask(7).getTimeMinuteEnd(),
                        R.string.time_end_ru,
                        82);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        /*  УРОК 9  */
        //поле редактирования Урока 9
        EditText etLesson9 = v.findViewById(R.id.etLesson9);
        etLesson9.setText(mWD.getTask(8).getTaskText());
        etLesson9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //
            }

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                mWD.getTask(8).setTaskText(text.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //
            }
        });

        //CheckBox - время начала Урока 9
        CheckBox cbTimeStart9 = v.findViewById(R.id.cbTimeStart9);
        cbTimeStart9.setChecked(mWD.getTask(8).isTimeStart());
        cbTimeStart9.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(8).setTimeStartFlag(isChecked));

        //CheckBox - время конца Урока 9
        CheckBox cbTimeEnd9 = v.findViewById(R.id.cbTimeEnd9);
        cbTimeEnd9.setChecked(mWD.getTask(8).isTimeEnd());
        cbTimeEnd9.setOnCheckedChangeListener((button, isChecked) -> mWD.getTask(8).setTimeEndFlag(isChecked));

        //Button - установка времени начала Урока 9
        btnTimeStart9 = v.findViewById(R.id.btnTimeStart9);
        btnTimeStart9.setText(mWD.getTask(8).getTimeStart());
        btnTimeStart9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(8).getTimeHourStart(),
                        mWD.getTask(8).getTimeMinuteStart(),
                        R.string.time_start_ru,
                        91);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        //Button - установка времени конца Урока 9
        btnTimeEnd9 = v.findViewById(R.id.btnTimeEnd9);
        btnTimeEnd9.setText(mWD.getTask(8).getTimeEnd());
        btnTimeEnd9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(
                        mWD.getTask(8).getTimeHourEnd(),
                        mWD.getTask(8).getTimeMinuteEnd(),
                        R.string.time_end_ru,
                        92);
                dialog.setTargetFragment(WDFragment.this, REQUEST_CODE);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        return v;
    }

    //метод onActivityResult вызывается для родительской активности при уничтожении дочерней активности
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode != Activity.RESULT_OK) return;
        if (requestCode == REQUEST_CODE) {
            int h = data.getIntExtra(TimePickerFragment.EXTRA_H, 0);
            int m = data.getIntExtra(TimePickerFragment.EXTRA_M, 0);
            int source = data.getIntExtra(TimePickerFragment.EXTRA_SOURCE, 0);

            switch (source) {
                case 11:
                    mWD.getTask(0).setTimeStart(h, m);
                    btnTimeStart1.setText(mWD.getTask(0).getTimeStart());
                    break;
                case 12:
                    mWD.getTask(0).setTimeEnd(h, m);
                    btnTimeEnd1.setText(mWD.getTask(0).getTimeEnd());
                    break;
                case 21:
                    mWD.getTask(1).setTimeStart(h, m);
                    btnTimeStart2.setText(mWD.getTask(1).getTimeStart());
                    break;
                case 22:
                    mWD.getTask(1).setTimeEnd(h, m);
                    btnTimeEnd2.setText(mWD.getTask(1).getTimeEnd());
                    break;
                case 31:
                    mWD.getTask(2).setTimeStart(h, m);
                    btnTimeStart3.setText(mWD.getTask(2).getTimeStart());
                    break;
                case 32:
                    mWD.getTask(2).setTimeEnd(h, m);
                    btnTimeEnd3.setText(mWD.getTask(2).getTimeEnd());
                    break;
                case 41:
                    mWD.getTask(3).setTimeStart(h, m);
                    btnTimeStart4.setText(mWD.getTask(3).getTimeStart());
                    break;
                case 42:
                    mWD.getTask(3).setTimeEnd(h, m);
                    btnTimeEnd4.setText(mWD.getTask(3).getTimeEnd());
                    break;
                case 51:
                    mWD.getTask(4).setTimeStart(h, m);
                    btnTimeStart5.setText(mWD.getTask(4).getTimeStart());
                    break;
                case 52:
                    mWD.getTask(4).setTimeEnd(h, m);
                    btnTimeEnd5.setText(mWD.getTask(4).getTimeEnd());
                    break;
                case 61:
                    mWD.getTask(5).setTimeStart(h, m);
                    btnTimeStart6.setText(mWD.getTask(5).getTimeStart());
                    break;
                case 62:
                    mWD.getTask(5).setTimeEnd(h, m);
                    btnTimeEnd6.setText(mWD.getTask(5).getTimeEnd());
                    break;
                case 71:
                    mWD.getTask(6).setTimeStart(h, m);
                    btnTimeStart7.setText(mWD.getTask(6).getTimeStart());
                    break;
                case 72:
                    mWD.getTask(6).setTimeEnd(h, m);
                    btnTimeEnd7.setText(mWD.getTask(6).getTimeEnd());
                    break;
                case 81:
                    mWD.getTask(7).setTimeStart(h, m);
                    btnTimeStart8.setText(mWD.getTask(7).getTimeStart());
                    break;
                case 82:
                    mWD.getTask(7).setTimeEnd(h, m);
                    btnTimeEnd8.setText(mWD.getTask(7).getTimeEnd());
                    break;
                case 91:
                    mWD.getTask(8).setTimeStart(h, m);
                    btnTimeStart9.setText(mWD.getTask(8).getTimeStart());
                    break;
                case 92:
                    mWD.getTask(8).setTimeEnd(h, m);
                    btnTimeEnd9.setText(mWD.getTask(8).getTimeEnd());
                    break;
                default:
                    break;
            }
        }
    }
}
