package by.mkstudio.mytimetable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import by.mkstudio.mytimetable.database.WDCursorWrapper;
import by.mkstudio.mytimetable.database.WdDbHelper;
import by.mkstudio.mytimetable.database.WdDbSchema.WdTable;

// Синглетный класс
public class WDList {
    private final static int WD_COUNT = 7;
    private static WDList sWDList;
    private Context mContext;
    private SQLiteDatabase mDatabase;   //база данных SQLite

    private String[] wdNameShort;
    private String[] wdNameLong;
    private int[] imgId;

    //Получаем объект только через метод get()
    public static WDList get(Context context) {
        if (sWDList == null) {
            sWDList = new WDList(context);
        }
        return sWDList;
    }

    //Конструктор закрытый
    private WDList(Context context) {
        mContext = context.getApplicationContext();

        //getWritableDatabase() - открывает либо создаёт файл БД
        mDatabase = new WdDbHelper(mContext).getWritableDatabase();
        //mWDays = new ArrayList<>(WD_COUNT); //удалить
        //Cursor cursor = mDatabase.rawQuery("select count(*) from " + WdTable.NAME, null);
        Cursor cursor = mDatabase.rawQuery("select day_number from " + WdTable.NAME, null);
        int num = cursor.getCount();
        cursor.close();
        //Массив коротких названий дней недели
        wdNameShort = context.getResources().getStringArray(R.array.weekdays_short_ru);

        //Массив длинных названий дней недели
        wdNameLong = context.getResources().getStringArray(R.array.weekdays_ru);

        //Массив ресурсов иконок дней недели
        imgId = new int[]{R.drawable.ic_face_1, R.drawable.ic_face_2,
                R.drawable.ic_face_3, R.drawable.ic_face_4,
                R.drawable.ic_face_5, R.drawable.ic_face_6,
                R.drawable.ic_face_7};

        //Первоначальное открытие программы и создание стартовой БД
        if (num < WD_COUNT) {
            for (int i = 1; i <= WD_COUNT; i++) {
                WD wd = new WD();
                wd.setWDNum(i);
                wd.setWDName(wdNameShort[i - 1]);
                wd.setWDNameLong(wdNameLong[i - 1]);
                wd.setWDImg(imgId[i - 1]);
                //добавляем WD в БД
                addWD(wd);
            }
        }
    }

    public void addWD(WD wd) {
        ContentValues values = getContentValues(wd);
        mDatabase.insert(WdTable.NAME, null, values);
    }

    public List<WD> getWDays() {
        List<WD> wdList = new ArrayList<>(WD_COUNT);

        WDCursorWrapper cursor = queryWD(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                WD wd = cursor.getWD();
                int i = wd.getWDNum() - 1;
                wd.setWDName(wdNameShort[i]);
                wd.setWDNameLong(wdNameLong[i]);
                wd.setWDImg(imgId[i]);

                wdList.add(wd);
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return wdList;
    }

    public WD getWD(int wdNum) {
        String args = Integer.toString(wdNum);
        WDCursorWrapper cursor = queryWD(WdTable.Cols.DAY_NUMBER + " = " + args, null);
        try {
            int count = cursor.getCount();
            if (count == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getWD();
        } finally {
            cursor.close();
        }
    }

    //обновление строк в БД
    public void updateWD(WD wd) {
        String wdNum = Integer.toString(wd.getWDNum());
        ContentValues values = getContentValues(wd);
        mDatabase.update(WdTable.NAME, values, WdTable.Cols.DAY_NUMBER + " = " + wdNum,
                null);
    }

    private WDCursorWrapper queryWD(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(WdTable.NAME,
                null,   //null - выбираются все столбцы
                whereClause,
                whereArgs,
                null,
                null,
                null);

        return new WDCursorWrapper(cursor);
    }

    //метод преобразовывает объект WD в ContentValues (обеспечивает хранение пар "ключ-значение" для БД)
    private static ContentValues getContentValues(WD wd) {
        ContentValues values = new ContentValues();
        values.put(WdTable.Cols.DAY_NUMBER, wd.getWDNum());
        //Урок 1
        values.put(WdTable.Cols.LESSON1, wd.getTask(0).getTaskText());
        values.put(WdTable.Cols.TIME_START1, wd.getTask(0).getTimeStartInt());
        values.put(WdTable.Cols.TIME_END1, wd.getTask(0).getTimeEndInt());
        values.put(WdTable.Cols.TIME_START1_FLAG, wd.getTask(0).isTimeStart() ? 1 : 0);
        values.put(WdTable.Cols.TIME_END1_FLAG, wd.getTask(0).isTimeEnd() ? 1 : 0);
        //Урок 2
        values.put(WdTable.Cols.LESSON2, wd.getTask(1).getTaskText());
        values.put(WdTable.Cols.TIME_START2, wd.getTask(1).getTimeStartInt());
        values.put(WdTable.Cols.TIME_END2, wd.getTask(1).getTimeEndInt());
        values.put(WdTable.Cols.TIME_START2_FLAG, wd.getTask(1).isTimeStart() ? 1 : 0);
        values.put(WdTable.Cols.TIME_END2_FLAG, wd.getTask(1).isTimeEnd() ? 1 : 0);
        //Урок 3
        values.put(WdTable.Cols.LESSON3, wd.getTask(2).getTaskText());
        values.put(WdTable.Cols.TIME_START3, wd.getTask(2).getTimeStartInt());
        values.put(WdTable.Cols.TIME_END3, wd.getTask(2).getTimeEndInt());
        values.put(WdTable.Cols.TIME_START3_FLAG, wd.getTask(2).isTimeStart() ? 1 : 0);
        values.put(WdTable.Cols.TIME_END3_FLAG, wd.getTask(2).isTimeEnd() ? 1 : 0);
        //Урок 4
        values.put(WdTable.Cols.LESSON4, wd.getTask(3).getTaskText());
        values.put(WdTable.Cols.TIME_START4, wd.getTask(3).getTimeStartInt());
        values.put(WdTable.Cols.TIME_END4, wd.getTask(3).getTimeEndInt());
        values.put(WdTable.Cols.TIME_START4_FLAG, wd.getTask(3).isTimeStart() ? 1 : 0);
        values.put(WdTable.Cols.TIME_END4_FLAG, wd.getTask(3).isTimeEnd() ? 1 : 0);
        //Урок 5
        values.put(WdTable.Cols.LESSON5, wd.getTask(4).getTaskText());
        values.put(WdTable.Cols.TIME_START5, wd.getTask(4).getTimeStartInt());
        values.put(WdTable.Cols.TIME_END5, wd.getTask(4).getTimeEndInt());
        values.put(WdTable.Cols.TIME_START5_FLAG, wd.getTask(4).isTimeStart() ? 1 : 0);
        values.put(WdTable.Cols.TIME_END5_FLAG, wd.getTask(4).isTimeEnd() ? 1 : 0);
        //Урок 6
        values.put(WdTable.Cols.LESSON6, wd.getTask(5).getTaskText());
        values.put(WdTable.Cols.TIME_START6, wd.getTask(5).getTimeStartInt());
        values.put(WdTable.Cols.TIME_END6, wd.getTask(5).getTimeEndInt());
        values.put(WdTable.Cols.TIME_START6_FLAG, wd.getTask(5).isTimeStart() ? 1 : 0);
        values.put(WdTable.Cols.TIME_END6_FLAG, wd.getTask(5).isTimeEnd() ? 1 : 0);
        //Урок 7
        values.put(WdTable.Cols.LESSON7, wd.getTask(6).getTaskText());
        values.put(WdTable.Cols.TIME_START7, wd.getTask(6).getTimeStartInt());
        values.put(WdTable.Cols.TIME_END7, wd.getTask(6).getTimeEndInt());
        values.put(WdTable.Cols.TIME_START7_FLAG, wd.getTask(6).isTimeStart() ? 1 : 0);
        values.put(WdTable.Cols.TIME_END7_FLAG, wd.getTask(6).isTimeEnd() ? 1 : 0);
        //Урок 8
        values.put(WdTable.Cols.LESSON8, wd.getTask(7).getTaskText());
        values.put(WdTable.Cols.TIME_START8, wd.getTask(7).getTimeStartInt());
        values.put(WdTable.Cols.TIME_END8, wd.getTask(7).getTimeEndInt());
        values.put(WdTable.Cols.TIME_START8_FLAG, wd.getTask(7).isTimeStart() ? 1 : 0);
        values.put(WdTable.Cols.TIME_END8_FLAG, wd.getTask(7).isTimeEnd() ? 1 : 0);
        //Урок 9
        values.put(WdTable.Cols.LESSON9, wd.getTask(8).getTaskText());
        values.put(WdTable.Cols.TIME_START9, wd.getTask(8).getTimeStartInt());
        values.put(WdTable.Cols.TIME_END9, wd.getTask(8).getTimeEndInt());
        values.put(WdTable.Cols.TIME_START9_FLAG, wd.getTask(8).isTimeStart() ? 1 : 0);
        values.put(WdTable.Cols.TIME_END9_FLAG, wd.getTask(8).isTimeEnd() ? 1 : 0);
        //Заметка 1
        values.put(WdTable.Cols.LESSON10, wd.getTask(9).getTaskText());
        values.put(WdTable.Cols.TIME_START10, wd.getTask(9).getTimeStartInt());
        values.put(WdTable.Cols.TIME_END10, wd.getTask(9).getTimeEndInt());
        values.put(WdTable.Cols.TIME_START10_FLAG, wd.getTask(9).isTimeStart() ? 1 : 0);
        values.put(WdTable.Cols.TIME_END10_FLAG, wd.getTask(9).isTimeEnd() ? 1 : 0);
        //Заметка 2
        values.put(WdTable.Cols.LESSON11, wd.getTask(10).getTaskText());
        values.put(WdTable.Cols.TIME_START11, wd.getTask(10).getTimeStartInt());
        values.put(WdTable.Cols.TIME_END11, wd.getTask(10).getTimeEndInt());
        values.put(WdTable.Cols.TIME_START11_FLAG, wd.getTask(10).isTimeStart() ? 1 : 0);
        values.put(WdTable.Cols.TIME_END11_FLAG, wd.getTask(10).isTimeEnd() ? 1 : 0);
        //Заметка 3
        values.put(WdTable.Cols.LESSON12, wd.getTask(11).getTaskText());
        values.put(WdTable.Cols.TIME_START12, wd.getTask(11).getTimeStartInt());
        values.put(WdTable.Cols.TIME_END12, wd.getTask(11).getTimeEndInt());
        values.put(WdTable.Cols.TIME_START12_FLAG, wd.getTask(11).isTimeStart() ? 1 : 0);
        values.put(WdTable.Cols.TIME_END12_FLAG, wd.getTask(11).isTimeEnd() ? 1 : 0);
        return values;
    }

    public String getWDName (int wdNum, boolean longName) {
        if (longName) {
            return wdNameLong[wdNum - 1];
        } else return wdNameShort[wdNum - 1];
    }

}
