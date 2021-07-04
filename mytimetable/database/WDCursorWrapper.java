package by.mkstudio.mytimetable.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import by.mkstudio.mytimetable.WD;
import by.mkstudio.mytimetable.database.WdDbSchema.WdTable;

public class WDCursorWrapper extends CursorWrapper {
    public WDCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public WD getWD() {

        WD wd = new WD();
        wd.setWDNum(getInt(getColumnIndex(WdTable.Cols.DAY_NUMBER)));

        //Урок 1
        wd.getTask(0).setTaskText(getString(getColumnIndex(WdTable.Cols.LESSON1)));
        wd.getTask(0).setTimeStart(getInt(getColumnIndex(WdTable.Cols.TIME_START1)));
        wd.getTask(0).setTimeEnd(getInt(getColumnIndex(WdTable.Cols.TIME_END1)));
        wd.getTask(0).setTimeStartFlag(getInt(getColumnIndex(WdTable.Cols.TIME_START1_FLAG)) != 0);
        wd.getTask(0).setTimeEndFlag(getInt(getColumnIndex(WdTable.Cols.TIME_END1_FLAG)) != 0);
        //Урок 2
        wd.getTask(1).setTaskText(getString(getColumnIndex(WdTable.Cols.LESSON2)));
        wd.getTask(1).setTimeStart(getInt(getColumnIndex(WdTable.Cols.TIME_START2)));
        wd.getTask(1).setTimeEnd(getInt(getColumnIndex(WdTable.Cols.TIME_END2)));
        wd.getTask(1).setTimeStartFlag(getInt(getColumnIndex(WdTable.Cols.TIME_START2_FLAG)) != 0);
        wd.getTask(1).setTimeEndFlag(getInt(getColumnIndex(WdTable.Cols.TIME_END2_FLAG)) != 0);
        //Урок 3
        wd.getTask(2).setTaskText(getString(getColumnIndex(WdTable.Cols.LESSON3)));
        wd.getTask(2).setTimeStart(getInt(getColumnIndex(WdTable.Cols.TIME_START3)));
        wd.getTask(2).setTimeEnd(getInt(getColumnIndex(WdTable.Cols.TIME_END3)));
        wd.getTask(2).setTimeStartFlag(getInt(getColumnIndex(WdTable.Cols.TIME_START3_FLAG)) != 0);
        wd.getTask(2).setTimeEndFlag(getInt(getColumnIndex(WdTable.Cols.TIME_END3_FLAG)) != 0);
        //Урок 4
        wd.getTask(3).setTaskText(getString(getColumnIndex(WdTable.Cols.LESSON4)));
        wd.getTask(3).setTimeStart(getInt(getColumnIndex(WdTable.Cols.TIME_START4)));
        wd.getTask(3).setTimeEnd(getInt(getColumnIndex(WdTable.Cols.TIME_END4)));
        wd.getTask(3).setTimeStartFlag(getInt(getColumnIndex(WdTable.Cols.TIME_START4_FLAG)) != 0);
        wd.getTask(3).setTimeEndFlag(getInt(getColumnIndex(WdTable.Cols.TIME_END4_FLAG)) != 0);
        //Урок 5
        wd.getTask(4).setTaskText(getString(getColumnIndex(WdTable.Cols.LESSON5)));
        wd.getTask(4).setTimeStart(getInt(getColumnIndex(WdTable.Cols.TIME_START5)));
        wd.getTask(4).setTimeEnd(getInt(getColumnIndex(WdTable.Cols.TIME_END5)));
        wd.getTask(4).setTimeStartFlag(getInt(getColumnIndex(WdTable.Cols.TIME_START5_FLAG)) != 0);
        wd.getTask(4).setTimeEndFlag(getInt(getColumnIndex(WdTable.Cols.TIME_END5_FLAG)) != 0);
        //Урок 6
        wd.getTask(5).setTaskText(getString(getColumnIndex(WdTable.Cols.LESSON6)));
        wd.getTask(5).setTimeStart(getInt(getColumnIndex(WdTable.Cols.TIME_START6)));
        wd.getTask(5).setTimeEnd(getInt(getColumnIndex(WdTable.Cols.TIME_END6)));
        wd.getTask(5).setTimeStartFlag(getInt(getColumnIndex(WdTable.Cols.TIME_START6_FLAG)) != 0);
        wd.getTask(5).setTimeEndFlag(getInt(getColumnIndex(WdTable.Cols.TIME_END6_FLAG)) != 0);
        //Урок 7
        wd.getTask(6).setTaskText(getString(getColumnIndex(WdTable.Cols.LESSON7)));
        wd.getTask(6).setTimeStart(getInt(getColumnIndex(WdTable.Cols.TIME_START7)));
        wd.getTask(6).setTimeEnd(getInt(getColumnIndex(WdTable.Cols.TIME_END7)));
        wd.getTask(6).setTimeStartFlag(getInt(getColumnIndex(WdTable.Cols.TIME_START7_FLAG)) != 0);
        wd.getTask(6).setTimeEndFlag(getInt(getColumnIndex(WdTable.Cols.TIME_END7_FLAG)) != 0);
        //Урок 8
        wd.getTask(7).setTaskText(getString(getColumnIndex(WdTable.Cols.LESSON8)));
        wd.getTask(7).setTimeStart(getInt(getColumnIndex(WdTable.Cols.TIME_START8)));
        wd.getTask(7).setTimeEnd(getInt(getColumnIndex(WdTable.Cols.TIME_END8)));
        wd.getTask(7).setTimeStartFlag(getInt(getColumnIndex(WdTable.Cols.TIME_START8_FLAG)) != 0);
        wd.getTask(7).setTimeEndFlag(getInt(getColumnIndex(WdTable.Cols.TIME_END8_FLAG)) != 0);
        //Урок 9
        wd.getTask(8).setTaskText(getString(getColumnIndex(WdTable.Cols.LESSON9)));
        wd.getTask(8).setTimeStart(getInt(getColumnIndex(WdTable.Cols.TIME_START9)));
        wd.getTask(8).setTimeEnd(getInt(getColumnIndex(WdTable.Cols.TIME_END9)));
        wd.getTask(8).setTimeStartFlag(getInt(getColumnIndex(WdTable.Cols.TIME_START9_FLAG)) != 0);
        wd.getTask(8).setTimeEndFlag(getInt(getColumnIndex(WdTable.Cols.TIME_END9_FLAG)) != 0);
        //Заметка 1
        wd.getTask(9).setTaskText(getString(getColumnIndex(WdTable.Cols.LESSON10)));
        wd.getTask(9).setTimeStart(getInt(getColumnIndex(WdTable.Cols.TIME_START10)));
        wd.getTask(9).setTimeEnd(getInt(getColumnIndex(WdTable.Cols.TIME_END10)));
        wd.getTask(9).setTimeStartFlag(getInt(getColumnIndex(WdTable.Cols.TIME_START10_FLAG)) != 0);
        wd.getTask(9).setTimeEndFlag(getInt(getColumnIndex(WdTable.Cols.TIME_END10_FLAG)) != 0);
        //Заметка 2
        wd.getTask(10).setTaskText(getString(getColumnIndex(WdTable.Cols.LESSON11)));
        wd.getTask(10).setTimeStart(getInt(getColumnIndex(WdTable.Cols.TIME_START11)));
        wd.getTask(10).setTimeEnd(getInt(getColumnIndex(WdTable.Cols.TIME_END11)));
        wd.getTask(10).setTimeStartFlag(getInt(getColumnIndex(WdTable.Cols.TIME_START11_FLAG)) != 0);
        wd.getTask(10).setTimeEndFlag(getInt(getColumnIndex(WdTable.Cols.TIME_END11_FLAG)) != 0);
        //Заметка 3
        wd.getTask(11).setTaskText(getString(getColumnIndex(WdTable.Cols.LESSON12)));
        wd.getTask(11).setTimeStart(getInt(getColumnIndex(WdTable.Cols.TIME_START12)));
        wd.getTask(11).setTimeEnd(getInt(getColumnIndex(WdTable.Cols.TIME_END12)));
        wd.getTask(11).setTimeStartFlag(getInt(getColumnIndex(WdTable.Cols.TIME_START12_FLAG)) != 0);
        wd.getTask(11).setTimeEndFlag(getInt(getColumnIndex(WdTable.Cols.TIME_END12_FLAG)) != 0);

        return wd;
    }
}