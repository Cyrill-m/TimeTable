package by.mkstudio.mytimetable;

import java.util.ArrayList;
import java.util.List;

public class WD {
    public final static int LESSON_COUNT = 9;
    public final static int NOTE_COUNT = 3;
    private List<Task> mTaskList;
    private String mWDName;
    private String mWDNameLong;
    private int mWDImg;
    private int mWDNum;


    //Конструктор
    public WD() {
        mTaskList = new ArrayList<>(LESSON_COUNT + NOTE_COUNT);
        //Список уроков
        for (int i = 0; i < LESSON_COUNT; i++) {
            Task task = new Task();
            //task.setTaskText("Урок " + (i + 1));
            task.setTaskText("");
            task.setTimeStartFlag(false);
            mTaskList.add(task);
        }
        //Список заметок
        for (int i = 0; i < NOTE_COUNT; i++) {
            Task task = new Task();
            //task.setTaskText("Заметка " + (i + 1));
            task.setTaskText("");
            task.setTimeStartFlag(false);
            mTaskList.add(task);
        }
    }

    public Task getTask(int position) {
        return mTaskList.get(position);
    }

    public String getWDName() {
        return mWDName;
    }

    public void setWDName(String wd) {
        mWDName = wd;
    }

    public String getWDNameLong() {
        return mWDNameLong;
    }

    public void setWDNameLong(String wd) {
        mWDNameLong = wd;
    }

    public int getWDImg() {
        return mWDImg;
    }

    public void setWDImg(int WDImg) {
        mWDImg = WDImg;
    }

    public int getWDNum() {
        return mWDNum;
    }

    public void setWDNum(int WDNum) {
        mWDNum = WDNum;
    }
}
