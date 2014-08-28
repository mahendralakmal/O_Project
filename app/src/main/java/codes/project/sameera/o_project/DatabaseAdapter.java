package codes.project.sameera.o_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.sql.SQLException;

/**
 * Created by Samy on 8/27/2014.
 */
public class DatabaseAdapter {

    DatabaseHelper Helper;
    public DatabaseAdapter(Context context){
        Helper= new DatabaseHelper(context);
    }
    public long insertData(String fname,String mname, String sname, String address, String TPhome, String TPmobile, String presentsport){
        SQLiteDatabase db = Helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Helper.FIRST_NAME,fname);
        contentValues.put(Helper.MID_NAME,mname);
        contentValues.put(Helper.SURE_NAME, sname);
        contentValues.put(Helper.ADDRESS, address);
        contentValues.put(Helper.CN_HOME, TPhome);
        contentValues.put(Helper.CN_MOBILE, TPmobile);
        contentValues.put(Helper.Pres_SPORT, presentsport);

        long id=db.insert(Helper.TABLE_NAME,null,contentValues);
        return id;
    }

    public String getAllData(){
        SQLiteDatabase db = Helper.getWritableDatabase();
        //select id,fname,mname from tabele
        String[] columns = {Helper.ID,Helper.FIRST_NAME,Helper.MID_NAME, Helper.SURE_NAME, Helper.ADDRESS};
        Cursor cursor = db.query(Helper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){
            int cid=cursor.getInt(0);
            String fname = cursor.getString(1);
            String mname = cursor.getString(2);
            String sname = cursor.getString(3);
            String address = cursor.getString(4);
            buffer.append(cid+" "+fname+" "+mname+" "+sname+" "+address+"\n");
        }
        return buffer.toString();
    }

    static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String DTABASE_NAME = "sport_unleash";
        private static final String TABLE_NAME = "susParticipants";
        private static final int DATABASE_VERSION = 8;
        private static final String ID = "id";
        private static final String FIRST_NAME = "first_name";
        private static final String MID_NAME = "middle_name";
        private static final String SURE_NAME = "sure_name";
        private static final String ADDRESS = "Address";
        private static final String CN_HOME = "contact_home_number";
        private static final String CN_MOBILE = "contact_mobile_number";
        private static final String Pres_SPORT = "present_sports";
        private static final String CREATE_TALBE = "CREATE TABLE " + TABLE_NAME +" ("+ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FIRST_NAME + " VARCHAR(255), " + MID_NAME + " VARCHAR(255), " + SURE_NAME + " VARCHAR(255), " +
                ADDRESS + " VARCHAR(255), " + CN_HOME + " VARCHAR(255), " + CN_MOBILE + " VARCHAR(255), " + Pres_SPORT + " VARCHAR(255));";
        private static final String DROP_TABLE = " DROP TABLE IF EXISTS " + TABLE_NAME ;
        private Context context;

        public DatabaseHelper(Context context){
            super(context,DTABASE_NAME,null,DATABASE_VERSION);
            this.context=context;
            Message.message(context, "constructor called");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //try {
                db.execSQL(CREATE_TALBE);
            //}catch (SQLException e){
            //    Message.message(context, "" + e);

            //}
        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i2) {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }
    }
}
