package com.example.booklist.db;

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
	private static final String DBNAME = "booklist";

	// DataBase Version
	private static final int VERSION = 1;

	public DataBaseHelper(Context context) {
		super(context, DBNAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.beginTransaction();

		try {

			StringBuilder createBooks = new StringBuilder();
			createBooks.append("CREATE TABLE " + Book.TABLE_NAME + " (");
			createBooks.append(Book.COLUMN_ID
					+ " integer primary key autoincrement not null,");
			createBooks.append(Book.COLUMN_TITLE + " text,");
			createBooks.append(Book.COLUMN_TITLE_KANA + " text,");
			createBooks.append(Book.COLUMN_SUBTITLE + " text,");
			createBooks.append(Book.COLUMN_SUBTITLE_KANA + " text,");
			createBooks.append(Book.COLUMN_SERIES_NAME + " text,");
			createBooks.append(Book.COLUMN_SERIES_NAME_KANA + " text,");
			createBooks.append(Book.COLUMN_AUTHOR + " text,");
			createBooks.append(Book.COLUMN_AUTHOR_KANA + " text,");
			createBooks.append(Book.COLUMN_PUBLISHER_NAME + " text,");
			createBooks.append(Book.COLUMN_SIZE + " text,");
			createBooks.append(Book.COLUMN_ISBN + " text unique not null,");
			createBooks.append(Book.COLUMN_ITEM_CAPTION + " text,");
			createBooks.append(Book.COLUMN_SALES_DATE + " text,");
			createBooks.append(Book.COLUMN_ITEM_PRICE + " integer,");
			createBooks.append(Book.COLUMN_ITEM_URL + " text,");
			createBooks.append(Book.COLUMN_SMALL_IMAGE_URL + " text,");
			createBooks.append(Book.COLUMN_MEDIUM_IMAGE_URL + " text,");
			createBooks.append(Book.COLUMN_LARGE_IMAGE_URL + " text");
			createBooks.append(")");

			StringBuilder createRates = new StringBuilder();
			createRates.append("CREATE TABLE " + Rate.TABLE_NAME + "(");
			createRates.append(Rate.COLUMN_ID
					+ " integer primary key autoincrement not null,");
			createRates.append(Rate.COLUMN_ISBN + " text unique not null,");
			createRates.append(Rate.COLUMN_STATUS + " integer default 0");
			createRates.append(Rate.COLUMN_RATE + " integer default 0");
			createRates.append(")");

			db.execSQL(createBooks.toString());
			db.execSQL(createRates.toString());

		} finally {
			db.endTransaction();
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + Book.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Rate.TABLE_NAME);
		onCreate(db);
	}
}
