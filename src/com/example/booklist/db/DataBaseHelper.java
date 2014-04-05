package com.example.booklist.db;

import android.content.ContentValues;
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

	// Test Data
	private String[][] testBooks = new String[][] {
			{ "たいとる１", "タイトル", "さぶたいとる", "サブタイトルカナ", "シリーズ", "シリーズカナ", "著者",
					"チョシャ", "出版社", "文庫", "478992381", "説明文", "2012/12/12",
					"700", "http://www.google.com", "small.google.com",
					"medium.google.com", "large.google.com" },
			{ "たいとる２", "タイトル", "さぶたいとる", "サブタイトルカナ", "シリーズ", "シリーズカナ", "著者",
					"チョシャ", "出版社", "文庫", "478992382", "説明文", "2012/12/12",
					"700", "http://www.google.com", "small.google.com",
					"medium.google.com", "large.google.com" },
			{ "たいとる３", "タイトル", "さぶたいとる", "サブタイトルカナ", "シリーズ", "シリーズカナ", "著者",
					"チョシャ", "出版社", "文庫", "478992383", "説明文", "2012/12/12",
					"700", "http://www.google.com", "small.google.com",
					"medium.google.com", "large.google.com" },
			{ "たいとる４", "タイトル", "さぶたいとる", "サブタイトルカナ", "シリーズ", "シリーズカナ", "著者",
					"チョシャ", "出版社", "文庫", "478992384", "説明文", "2012/12/12",
					"700", "http://www.google.com", "small.google.com",
					"medium.google.com", "large.google.com" } };

	private String[][] testRates = new String[][] { { "478992381", "0", "0" },
			{ "478992382", "0", "0" }, { "478992383", "0", "0" },
			{ "478992384", "0", "0" } };

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

			db.execSQL(createBooks.toString());

			StringBuilder createRates = new StringBuilder();
			createRates.append("CREATE TABLE " + Rate.TABLE_NAME + "(");
			createRates.append(Rate.COLUMN_ID
					+ " integer primary key autoincrement not null,");
			createRates.append(Rate.COLUMN_ISBN + " text unique not null,");
			createRates.append(Rate.COLUMN_STATUS + " integer default 0,");
			createRates.append(Rate.COLUMN_RATE + " integer default 0");
			createRates.append(")");

			db.execSQL(createRates.toString());

			// サンプルデータの投入

			for (String[] data : testBooks) {
				ContentValues values = new ContentValues();
				values.put(Book.COLUMN_TITLE, data[0]);
				values.put(Book.COLUMN_TITLE_KANA, data[1]);
				values.put(Book.COLUMN_SUBTITLE, data[2]);
				values.put(Book.COLUMN_SUBTITLE_KANA, data[3]);
				values.put(Book.COLUMN_SERIES_NAME, data[4]);
				values.put(Book.COLUMN_SERIES_NAME_KANA, data[5]);
				values.put(Book.COLUMN_AUTHOR, data[6]);
				values.put(Book.COLUMN_AUTHOR_KANA, data[7]);
				values.put(Book.COLUMN_PUBLISHER_NAME, data[8]);
				values.put(Book.COLUMN_SIZE, data[9]);
				values.put(Book.COLUMN_ISBN, data[10]);
				values.put(Book.COLUMN_ITEM_CAPTION, data[11]);
				values.put(Book.COLUMN_SALES_DATE, data[12]);
				values.put(Book.COLUMN_ITEM_PRICE, data[13]);
				values.put(Book.COLUMN_ITEM_URL, data[14]);
				values.put(Book.COLUMN_SMALL_IMAGE_URL, data[15]);
				values.put(Book.COLUMN_MEDIUM_IMAGE_URL, data[16]);
				values.put(Book.COLUMN_LARGE_IMAGE_URL, data[17]);

				db.insert(Book.TABLE_NAME, null, values);

			}

			for (String[] rate : testRates) {
				ContentValues values = new ContentValues();
				values.put(Rate.COLUMN_ISBN, rate[0]);
				values.put(Rate.COLUMN_STATUS, rate[1]);
				values.put(Rate.COLUMN_RATE, rate[2]);

				db.insert(Rate.TABLE_NAME, null, values);
			}

			db.setTransactionSuccessful();

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
