package by.mkstudio.mytimetable;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class TimePickerFragment extends DialogFragment {
    public static final String EXTRA_H = "extra_hour";
    public static final String EXTRA_M = "extra_minute";
    public static final String EXTRA_SOURCE = "extra_source";

    private static final String ARG_H = "hour";
    private static final String ARG_M = "minute";
    private static final String ARG_TITLE = "title";
    private static final String ARG_SOURCE = "source";

    private TimePicker mTimePicker;
    private int mSource;

    public static TimePickerFragment newInstance(int h, int m, int idTitle, int idSource) {
        Bundle args = new Bundle();
        args.putInt(ARG_H, h);
        args.putInt(ARG_M, m);
        args.putInt(ARG_TITLE, idTitle);
        args.putInt(ARG_SOURCE, idSource);

        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        int hour = getArguments().getInt(ARG_H);
        int minute = getArguments().getInt(ARG_M);
        int idTitle = getArguments().getInt(ARG_TITLE);
        mSource = getArguments().getInt(ARG_SOURCE);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_time, null);

        mTimePicker = v.findViewById(R.id.dialog_time_picker);
        mTimePicker.setHour(hour);
        mTimePicker.setMinute(minute);
        mTimePicker.setIs24HourView(true);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(idTitle)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int h = mTimePicker.getHour();
                                int m = mTimePicker.getMinute();
                                sendResult(Activity.RESULT_OK, h, m, mSource);
                            }
                        })
                .create();
    }

    private void sendResult(int resultCode, int h, int m, int source) {
        if (getTargetFragment() == null) return;

        Intent intent = new Intent();
        intent.putExtra(EXTRA_H, h);
        intent.putExtra(EXTRA_M, m);
        intent.putExtra(EXTRA_SOURCE, source);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}
