package by.mkstudio.mytimetable.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import by.mkstudio.mytimetable.database.WdDbSchema.WdTable;


public class WdDbHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "wdDB.db";

    public WdDbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + WdTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                WdTable.Cols.DAY_NUMBER + ", " +
                WdTable.Cols.LESSON1 + ", " +
                WdTable.Cols.TIME_START1 + ", " +
                WdTable.Cols.TIME_END1 + ", " +
                WdTable.Cols.TIME_START1_FLAG + ", " +
                WdTable.Cols.TIME_END1_FLAG + ", " +
                WdTable.Cols.LESSON2 + ", " +
                WdTable.Cols.TIME_START2 + ", " +
                WdTable.Cols.TIME_END2 + ", " +
                WdTable.Cols.TIME_START2_FLAG + ", " +
                WdTable.Cols.TIME_END2_FLAG + ", " +
                WdTable.Cols.LESSON3 + ", " +
                WdTable.Cols.TIME_START3 + ", " +
                WdTable.Cols.TIME_END3 + ", " +
                WdTable.Cols.TIME_START3_FLAG + ", " +
                WdTable.Cols.TIME_END3_FLAG + ", " +
                WdTable.Cols.LESSON4 + ", " +
                WdTable.Cols.TIME_START4 + ", " +
                WdTable.Cols.TIME_END4 + ", " +
                WdTable.Cols.TIME_START4_FLAG + ", " +
                WdTable.Cols.TIME_END4_FLAG + ", " +
                WdTable.Cols.LESSON5 + ", " +
                WdTable.Cols.TIME_START5 + ", " +
                WdTable.Cols.TIME_END5 + ", " +
                WdTable.Cols.TIME_START5_FLAG + ", " +
                WdTable.Cols.TIME_END5_FLAG + ", " +
                WdTable.Cols.LESSON6 + ", " +
                WdTable.Cols.TIME_START6 + ", " +
                WdTable.Cols.TIME_END6 + ", " +
                WdTable.Cols.TIME_START6_FLAG + ", " +
                WdTable.Cols.TIME_END6_FLAG + ", " +
                WdTable.Cols.LESSON7 + ", " +
                WdTable.Cols.TIME_START7 + ", " +
                WdTable.Cols.TIME_END7 + ", " +
                WdTable.Cols.TIME_START7_FLAG + ", " +
                WdTable.Cols.TIME_END7_FLAG + ", " +
                WdTable.Cols.LESSON8 + ", " +
                WdTable.Cols.TIME_START8 + ", " +
                WdTable.Cols.TIME_END8 + ", " +
                WdTable.Cols.TIME_START8_FLAG + ", " +
                WdTable.Cols.TIME_END8_FLAG + ", " +
                WdTable.Cols.LESSON9 + ", " +
                WdTable.Cols.TIME_START9 + ", " +
                WdTable.Cols.TIME_END9 + ", " +
                WdTable.Cols.TIME_START9_FLAG + ", " +
                WdTable.Cols.TIME_END9_FLAG + ", " +
                WdTable.Cols.LESSON10 + ", " +
                WdTable.Cols.TIME_START10 + ", " +
                WdTable.Cols.TIME_END10 + ", " +
                WdTable.Cols.TIME_START10_FLAG + ", " +
                WdTable.Cols.TIME_END10_FLAG + ", " +
                WdTable.Cols.LESSON11 + ", " +
                WdTable.Cols.TIME_START11 + ", " +
                WdTable.Cols.TIME_END11 + ", " +
                WdTable.Cols.TIME_START11_FLAG + ", " +
                WdTable.Cols.TIME_END11_FLAG + ", " +
                WdTable.Cols.LESSON12 + ", " +
                WdTable.Cols.TIME_START12 + ", " +
                WdTable.Cols.TIME_END12 + ", " +
                WdTable.Cols.TIME_START12_FLAG + ", " +
                WdTable.Cols.TIME_END12_FLAG + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //код обновления базы данных
    }
}
