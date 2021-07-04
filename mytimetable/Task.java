package by.mkstudio.mytimetable;

public class Task {
    private String mTaskText;
    private int mTimeStart;
    private int mTimeEnd;
    private boolean mTimeStartFlag;
    private boolean mTimeEndFlag;

    //Конструктор
    public Task() {
        mTaskText = "---";
        mTimeStart = 0;
        mTimeEnd = 0;

        mTimeStartFlag = true;
        mTimeEndFlag = true;
    }

    //setters
    public void setTaskText(String task) {
        mTaskText = task;
    }

    public void setTimeStart(int h, int m) {
        mTimeStart = h * 100 + m;
    }
    public void setTimeStart(int hm) {
        mTimeStart = hm;
    }

    public void setTimeEnd(int h, int m) {
        mTimeEnd = h * 100 + m;
    }
    public void setTimeEnd(int hm) {
        mTimeEnd = hm;
    }

    public void setTimeStartFlag(boolean fl) {
        mTimeStartFlag = fl;
    }

    public void setTimeEndFlag(boolean fl) {
        mTimeEndFlag = fl;
    }

    //getters
    public boolean isTimeStart() {
        return mTimeStartFlag;
    }

    public boolean isTimeEnd() {
        return mTimeEndFlag;
    }

    public int getTimeStartInt() {return mTimeStart;}

    public int getTimeEndInt() {return mTimeEnd;}

    public int getTimeHourStart() {
        return (mTimeStart / 100);
    }

    public int getTimeMinuteStart() {
        return mTimeStart - getTimeHourStart() * 100;
    }

    public int getTimeHourEnd() {
        return (mTimeEnd / 100);
    }

    public int getTimeMinuteEnd() {
        return mTimeEnd - getTimeHourEnd() * 100;
    }

    public String getTaskText() {
         return mTaskText;
    }

    public String getTaskTextAndTime() {
        //Вывод строки в формате "ЧЧ:ММ - ЧЧ:ММ Текст"
        String txt;
        if (mTaskText.equals("")){
            txt = "---";
        } else txt = mTaskText;

        if (mTimeStartFlag & mTimeEndFlag) {
            return getTimeStart() + " - " + getTimeEnd() + " " + txt;
        } else {
            if (mTimeStartFlag) {
                return getTimeStart() + " " + txt;
            } else return txt;
        }
    }

    public String getTimeStart() {
        String strHs, strMs;
        int Hs, Ms;

        Hs = getTimeHourStart();
        Ms = getTimeMinuteStart();

        //TimeHourStart
        if (Hs < 10) {
            strHs = "0" + Hs;
        } else strHs = "" + Hs;

        //TimeMinuteStart
        if (Ms < 10) {
            strMs = "0" + Ms;
        } else strMs = "" + Ms;

        //Вывод строки в формате "ЧЧ:ММ"
        return strHs + ":" + strMs;
    }

    public String getTimeEnd() {
        String strHe, strMe;
        int He, Me;

        He = getTimeHourEnd();
        Me = getTimeMinuteEnd();

        //TimeHourEnd
        if (He < 10) {
            strHe = "0" + He;
        } else strHe = "" + He;

        //TimeMinuteEnd
        if (Me < 10) {
            strMe = "0" + Me;
        } else strMe = "" + Me;

        //Вывод строки в формате "ЧЧ:ММ"
        return strHe + ":" + strMe;
    }
}
