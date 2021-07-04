package by.mkstudio.mytimetable;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WDNoteFragment extends Fragment {

    private static final String WD_NUMBER = "wd_num_note";
    private WD mWD;

    //метод newInstance создаёт экземпляр фрагмента WDFragment,
    //упаковывает и задает его аргументы (номер дня недели)
    public static WDNoteFragment newInstance(int wdNum) {
        Bundle args = new Bundle();
        args.putInt(WD_NUMBER, wdNum);
        WDNoteFragment fragment = new WDNoteFragment();
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

        View v = inflater.inflate(R.layout.fragment_note, container, false);

        //поле заголовка - день недели
        TextView mtvWDName = v.findViewById(R.id.tvWDName);
        mtvWDName.setText(WDList.get(getActivity()).getWDName(mWD.getWDNum(), true));

        /*  ЗАМЕТКА 1  */
        //поле редактирования Заметки 1
        EditText etNote1 = v.findViewById(R.id.etNote1);
        etNote1.setText(mWD.getTask(9).getTaskText());
        etNote1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mWD.getTask(9).setTaskText(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //
            }
        });

        /*  ЗАМЕТКА 2  */
        //поле редактирования Заметки 2
        EditText etNote2 = v.findViewById(R.id.etNote2);
        etNote2.setText(mWD.getTask(10).getTaskText());
        etNote2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mWD.getTask(10).setTaskText(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //
            }
        });

        /*  ЗАМЕТКА 3  */
        //поле редактирования Заметки 3
        EditText etNote3 = v.findViewById(R.id.etNote3);
        etNote3.setText(mWD.getTask(11).getTaskText());
        etNote3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mWD.getTask(11).setTaskText(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //
            }
        });

        return v;
    }
}
