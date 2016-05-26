package com.beauti.experthp.bijnorbeautihub.DataBaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.beauti.experthp.bijnorbeautihub.DataBaseModel.BeautiSubServices;
import com.beauti.experthp.bijnorbeautihub.Model.BeautiPoints;
import com.beauti.experthp.bijnorbeautihub.Model.BeautyServices;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by expert on 5/5/2016.
 */
public class DataBaseHelper1 extends SQLiteOpenHelper {
    //DataBase Version
    private static final int DATABASE_VERSION=1;
    //Database name
    private static final String DataBase_Name = "BIJNORBeautyHubData.db";
    //Logcat
    private static final String LOG = "DataBasehelper";

    //Table names
    private static final String Table_name_Points="BeautyPoints";
    private static final String Table_name_Services="BeautyServices";
    private static final String Table_name_Sub_Services="Subservices";

    //COMMON columns Names
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";

    //Table_name_Services columns Names---same as above

    //Table_name_Sub_Services columns Names
    protected  static final String KEY_PRICE="price";
    private static final String KEY_Point_ID="Point_Id";
    private static final String KEY_Services_ID="Service_ID";

    //Create CREATE_TABLE_BEAUTYPOINT
    private static final String CREATE_TABLE_BEAUTYPOINT="CREATE TABLE " + Table_name_Points + "(" + KEY_ID
            + " INTEGER PRIMARY KEY   AUTOINCREMENT, " + KEY_NAME + " TEXT NOT NULL" + ");";

    //CREATE CREATE_TABLE_BEAUTYSERVICE
    private static final String CREATE_TABLE_BEAUTYSERVICE="CREATE TABLE " + Table_name_Services + "(" + KEY_ID
            + " INTEGER PRIMARY KEY   AUTOINCREMENT, " +KEY_NAME + " TEXT NOT NULL" + ");";

    //CREATE CREATE_TABLE_SUB_SERVICE
    private static final String CREATE_TABLE_SUB_SERVICE="CREATE TABLE " + Table_name_Sub_Services + "(" + KEY_ID
            + " INTEGER PRIMARY KEY   AUTOINCREMENT, " + KEY_NAME + " TEXT NOT NULL, " + KEY_PRICE
            +" INT NOT NULL, " + KEY_Point_ID + " INT, " + KEY_Services_ID + " INT" + ");";


    public DataBaseHelper1(Context context) {
        super(context, DataBase_Name, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BEAUTYPOINT);
        db.execSQL(CREATE_TABLE_BEAUTYSERVICE);
        db.execSQL(CREATE_TABLE_SUB_SERVICE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //ON UPGRATE DROP OLDER TABLES
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_BEAUTYPOINT);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_BEAUTYSERVICE);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_SUB_SERVICE);
        //IF YES CREATE AGAIN
        onCreate(db);
    }
    //---------------------CREATE BEAUTYPOINTS TABLE METHODS----------------------

    public long create_beauti_Point(BeautiPoints beautiPoints){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAME,beautiPoints.getName());
    // insert row
        long row_id=db.insert(Table_name_Points,null,values);

    return row_id;
    }

    public BeautiPoints getSinglePoint(long id){
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT * FROM " + Table_name_Points + " WHERE " + KEY_ID + " = " + id;
        Cursor cursor=db.rawQuery(query,null);
        BeautiPoints beautiPoint = new BeautiPoints();

        if(cursor.moveToNext()) {
            beautiPoint.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
            beautiPoint.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
        }
        return beautiPoint;
    }
    public List<BeautiPoints> getALLPoint(){
        List<BeautiPoints> beautiPointsList=new ArrayList<BeautiPoints>();
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT * FROM " + Table_name_Points;
        Cursor cursor=db.rawQuery(query, null);

        if(cursor.moveToNext()) {
            do {
                BeautiPoints beautiPoint = new BeautiPoints();
                beautiPoint.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                beautiPoint.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                beautiPointsList.add(beautiPoint);
            } while (cursor.moveToNext());
        }
        return beautiPointsList;
    }

    public long getPoint_Count() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + Table_name_Points;
        Cursor cursor = db.rawQuery(query, null);
        long count = cursor.getCount();
        return count;
    }

    public int update_Point(BeautiPoints beautiPoints){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAME, beautiPoints.getName());
        return db.update(Table_name_Points,values,KEY_ID + " = ?",new String[]{String.valueOf(beautiPoints.getId())});
    }
    public void delete_Point(long id){
        SQLiteDatabase db=this.getWritableDatabase();
         db.delete(Table_name_Points, KEY_ID + " = ?", new String[]{String.valueOf(id)});
    }
    public void delete_AllPoints(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Table_name_Points,null,null);
    }

    //---------------------CREATE BEAUTY_SERVICES TABLE METHODS----------------------


    public long create_beauti_Service(BeautyServices beautyServices){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAME,beautyServices.getService_name());
        // insert row
        long row_id=db.insert(Table_name_Services,null,values);

        return row_id;
    }

    public BeautyServices getSingleService(long id){
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT * FROM " + Table_name_Services + " WHERE " + KEY_ID + " = " + id;
        Cursor cursor=db.rawQuery(query,null);
        BeautyServices beautyService = new BeautyServices();

        if(cursor.moveToNext()) {
            beautyService.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
            beautyService.setService_name(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
        }
        return beautyService;
    }
    public List<BeautyServices> getALLServices(){
        List<BeautyServices> beautiServicesList=new ArrayList<BeautyServices>();
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT * FROM " + Table_name_Services;
        Cursor cursor=db.rawQuery(query, null);

        if(cursor.moveToNext()) {
            do {
                BeautyServices beautiPoint = new BeautyServices();
                beautiPoint.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                beautiPoint.setService_name(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                beautiServicesList.add(beautiPoint);
            } while (cursor.moveToNext());
        }
        return beautiServicesList;
    }
    public void delete_Service(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Table_name_Services,null,null);
    }

    //---------------------CREATE BEAUTY_SUB_SERVICES TABLE METHODS----------------------

    public long create_table_SubService(List<BeautiSubServices> beautiSubServices, long point_Id,long service_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long row_id=0;
        for (int i = 0; i < beautiSubServices.size(); i++) {
            ContentValues values = new ContentValues();
            values.put(KEY_NAME, beautiSubServices.get(i).getSubService_Name());
            values.put(KEY_PRICE, beautiSubServices.get(i).getPrice());
            values.put(KEY_Point_ID, point_Id);
            values.put(KEY_Services_ID, service_id);
            row_id = db.insert(Table_name_Sub_Services, null, values);

        }
        return row_id;
    }

    public long getSuService_Count() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + Table_name_Sub_Services;
        Cursor cursor = db.rawQuery(query, null);
        long count = cursor.getCount();
        return count;
    }

    public List<BeautiSubServices> get_ALL_Sub_Service(long point_id,long Service_id){
        List<BeautiSubServices> beautiSubServicesList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
/*
        String query="SELECT * FROM " + Table_name_Sub_Services + " TSS, " + Table_name_Points + " BP, " +Table_name_Services
        + " TS" + " WHERE BP." + KEY_ID + " = " + point_id + " AND TS." + KEY_ID + " = " + Service_id
        + " AND BP." + KEY_ID + " = " + "TSS." + KEY_Point_ID + " AND TS." + KEY_ID + " = " + "TSS." + KEY_Services_ID;
        Log.e("Query", query);
        */
        String query="SELECT * FROM " + Table_name_Sub_Services + " where " + KEY_Point_ID
                + " = " + point_id + " AND " + KEY_Services_ID + " = " + Service_id;

        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToNext()){
            // BeautiSubServices beautiSubServices=new BeautiSubServices();
            do{
                BeautiSubServices beautiSubServices=new BeautiSubServices();

                beautiSubServices.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                beautiSubServices.setSubService_Name(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                beautiSubServices.setPrice(cursor.getInt(cursor.getColumnIndex(KEY_PRICE)));
                beautiSubServices.setPoint_id(cursor.getInt(cursor.getColumnIndex(KEY_Point_ID)));
                beautiSubServices.setService_id(cursor.getInt(cursor.getColumnIndex(KEY_PRICE)));
                beautiSubServicesList.add(beautiSubServices);
            }while (cursor.moveToNext());
        }


        return beautiSubServicesList;
    }

    public void delete_Sub_Service(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Table_name_Sub_Services,null,null);
    }

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

}
