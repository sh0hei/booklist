package com.example.booklist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * DataBase Helper Class
 * 
 * @author sh0hei
 */
public class DataBaseHelper extends SQLiteOpenHelper {

	// DataBase Name
	private static final String DBNAME = "books";
	
	// DataBase Version
	private static final int VERSION = 1;
	
	public DataBaseHelper(Context context) {
		super(context, DBNAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.beginTransaction();
		
		try {
			/*
			StringBuilder createSql = new StringBuilder();
			createSql.append("CREATE TABLE " + Book.TABLE_NAME + " (");
			createSql.append(Book.COLUMN_ID + " integer primary key autoincrement not null,");
			createSql.append(Book.COLUMN_TITLE + " text,");
			createSql.append(Book.COLUMN_TITLE_KANA + " text,");
			createSql.append(Book.COLUMN_SUBTITLE + " text,");
			createSql.append(Book.COLUMN_SUBTITLE_KANA + " text,");
			createSql.append(Book.COLUMN_SERIES_NAME + " text,");
			createSql.append(Book.COLUMN_SERIES_NAME_KANA + " text,");
			createSql.append(Book.COLUMN_AUTHOR + " text,");
			createSql.append(Book.COLUMN_AUTHOR_KANA + " text,");
			createSql.append(Book.COLUMN_PUBLISHER_NAME + " text,");
			createSql.append(Book.COLUMN_SIZE + " text,");
			createSql.append(Book.COLUMN_ISBN + " text, unique, not null");
			createSql.append(Book.COLUMN_ITEM_CAPTION + " text,");
			createSql.append(Book.COLUMN_SALES_DATE + " text,");
			createSql.append(Book.COLUMN_ITEM_PRICE + " integer,");
			createSql.append(Book.COLUMN_ITEM_URL + " text,");
			createSql.append(Book.COLUMN_SMALL_IMAGE_URL + " text,");
			createSql.append(Book.COLUMN_MEDIUM_IMAGE_URL + " text,");
			createSql.append(Book.COLUMN_LARGE_IMAGE_URL + " text");
			createSql.append(Book.COLUMN_RATE + " integer");
			createSql.append(Book.COLUMN_STATUS + " integer");
			createSql.append(")");
			

			db.execSQL(createSql.toString());
			*/
		} finally {
			db.endTransaction();
		}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS books");
		onCreate(db);
	}
}
