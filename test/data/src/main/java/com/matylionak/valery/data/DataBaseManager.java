package com.matylionak.valery.data;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;


public class DataBaseManager {
    private DBHelper dbHelper;
    private SQLiteDatabase database;


    //database columns
    private static int idColIndex;
    private static int nameColIndex;
    private static int profesionColIndex;
    private static int ageColIndex;
    private static int phoneColIndex;
    private static int emailColIndex;

    public DataBaseManager(Context context) {
        dbHelper = new DBHelper(context);
    }


    public void open(boolean isWritable) {
        if (isWritable) {
            database = dbHelper.getWritableDatabase();

        } else {
            database = dbHelper.getReadableDatabase();
        }


    }

    public void close() {
        if (database != null) {
            database.close();
        }
    }

    public void insertPeople(People people) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO test ('name', 'profession', 'age', 'phone', 'email') ");
        sql.append("VALUES ('");
        sql.append(people.getName());
        sql.append("', '");
        sql.append(people.getProfession());
        sql.append("', ");
        sql.append(people.getAge());
        sql.append(", '");
        sql.append(people.getPhone());
        sql.append("', '");
        sql.append(people.getEmail());
        sql.append("')");
        Log.e("TAG-insertTask", Thread.currentThread().getName() + "SQL" + sql.toString());
        database.execSQL(sql.toString());
    }


    public List<People> getPeoples() {
        List<People> list = new ArrayList<>();
        Cursor cursor = database.query("test", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            idColIndex = cursor.getColumnIndex("ID");
            nameColIndex = cursor.getColumnIndex("name");
            profesionColIndex = cursor.getColumnIndex("profession");
            ageColIndex = cursor.getColumnIndex("age");
            phoneColIndex = cursor.getColumnIndex("phone");
            emailColIndex = cursor.getColumnIndex("email");
            do {
                list.add(factory(cursor));
            }
            while (cursor.moveToNext());
        } else
            Log.d("LOG_TAG", "0 rows");

        cursor.close();
        Log.e("TAG-return from SQL", list.toString());
        return list;
    }





    private People factory(Cursor cursor) {
        People people = new People();
        people.setID(cursor.getInt(idColIndex));
        people.setName(cursor.getString(nameColIndex));
        people.setProfession(cursor.getString(profesionColIndex));
        people.setAge(cursor.getInt(ageColIndex));
        people.setPhone(cursor.getString(phoneColIndex));
        people.setEmail(cursor.getString(emailColIndex));
        return people;

    }


    public List<People> getPeopleByKeyWord(String str) {
        List<People> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT  rowid as ");
        sql.append("ID, ");
        sql.append("name, ");
        sql.append("profession, ");
        sql.append("age, ");
        sql.append("phone, ");
        sql.append("email ");
        sql.append("FROM test WHERE name LIKE '%");
        sql.append(str);
        sql.append("%'");

        Cursor cursor = database.rawQuery(sql.toString(), null);
        if (cursor == null) {
            return list;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return list;
        }

        if (cursor.moveToFirst()) {
            do {
                list.add(factory(cursor));
            }
            while (cursor.moveToNext());
        } else
            Log.d("LOG_TAG", "0 rows");

        cursor.close();

        return list;
    }

    public List<People> getPeoplesASC() {
        List<People> list = new ArrayList<>();
        Cursor cursor = database.query("test", null, null, null, null, null, "age ASC");
        if (cursor.moveToFirst()) {
            do {
                list.add(factory(cursor));
            }
            while (cursor.moveToNext());
        } else
            Log.d("LOG_TAG", "0 rows");

        cursor.close();
        Log.e("TAG-return from SQL", list.toString());
        return list;

    }

    public List<People> getPeoplesDESC(){
        List<People> list = new ArrayList<>();
        Cursor cursor = database.query("test", null, null, null, null, null, "age DESC");
        if (cursor.moveToFirst()) {
            do {
                list.add(factory(cursor));
            }
            while (cursor.moveToNext());
        } else
            Log.d("LOG_TAG", "0 rows");

        cursor.close();
        Log.e("TAG-return from SQL", list.toString());
        return list;


    }


}
