package com.example.booklist;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.booklist.db.Book;
import com.example.booklist.db.DataBaseHelper;
import com.example.booklist.db.Rate;

//import android.support.v4.app.DialogFragment;

public class DetailActivity extends Activity {

	private DataBaseHelper dbHelper;

	private Book book;

	private Rate rate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		Bundle extras = getIntent().getExtras();
		book = (Book) extras.getSerializable("book");

		setTitle(book.getTitle());
		setBookInfo();

		getRateStatus();

		// ダイアログを表示する
		DialogFragment newFragment = new FireMissilesDialogFragment();
		newFragment.show(getFragmentManager(), "dialog");

		ArrayAdapter<EnumRate> adapter = new ArrayAdapter<EnumRate>(this,
				android.R.layout.simple_spinner_dropdown_item,
				EnumRate.values());
		Spinner spinnerRate = (Spinner) this.findViewById(R.id.spinner2);
		spinnerRate.setAdapter(adapter);

		// TODO:
		spinnerRate.setSelection(rate.getRate().getId().intValue());

		spinnerRate.setOnItemSelectedListener(new OnItemSelectedListener() {
			// Spinnerのドロップダウンアイテムが選択された時
			public void onItemSelected(AdapterView<?> parent, View viw,
					int arg2, long arg3) {
				Spinner spinner = (Spinner) parent;
				EnumRate hoge = (EnumRate) spinner.getSelectedItem();
				Integer rate = hoge.getId();

				setRate(rate.intValue());
				// String item = (String) spinner.getSelectedItem().toString();
				// Toast.makeText(DetailActivity.this, hogehoge + " : " + item,
				// Toast.LENGTH_SHORT).show();
			}

			// Spinnerのドロップダウンアイテムが選択されなかった時
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		//
		ArrayAdapter<EnumStatus> adapterStatus = new ArrayAdapter<EnumStatus>(
				this, android.R.layout.simple_spinner_dropdown_item,
				EnumStatus.values());
		Spinner spinnerStatus = (Spinner) this.findViewById(R.id.spinner1);
		spinnerStatus.setAdapter(adapterStatus);

		spinnerStatus.setSelection(rate.getStatus().getId().intValue());

		// スピナーのアイテムが選択された時に呼び出されるコールバックリスナーを登録します

		spinnerStatus.setOnItemSelectedListener(new OnItemSelectedListener() {
			// Spinnerのドロップダウンアイテムが選択された時
			public void onItemSelected(AdapterView<?> parent, View viw,
					int arg2, long arg3) {

				Spinner spinner = (Spinner) parent;
				EnumStatus foo = (EnumStatus) spinner.getSelectedItem();
				Integer status = foo.getId();

				setStatus(status.intValue());
				// String item = (String) spinner.getSelectedItem().toString();
				// Toast.makeText(DetailActivity.this, bar + " : " + item,
				// Toast.LENGTH_SHORT).show();
			}

			// Spinnerのドロップダウンアイテムが選択されなかった時
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
		return true;
	}

	public static class FireMissilesDialogFragment extends DialogFragment {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the Builder class for convenient dialog construction
			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			builder.setTitle(R.string.delete);
			builder.setMessage(R.string.confirm_delete)
					.setPositiveButton(R.string.delete,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// FIRE ZE MISSILES!
									DetailActivity activity = (DetailActivity) getActivity();
									activity.deleteBook();
								}
							})
					.setNegativeButton(R.string.cancel,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// User cancelled the dialog
								}
							});
			// Create the AlertDialog object and return it
			return builder.create();
		}
	}

	/**
	 * ブックを削除します
	 */
	private void deleteBook() {

	}

	/**
	 * ブックのユーザ設定レート・ユーザ設定ステータスを取得します
	 */
	private void getRateStatus() {

		// queryメソッドでデータを取得
		String[] cols = { Rate.COLUMN_ID, Rate.COLUMN_ISBN, Rate.COLUMN_RATE,
				Rate.COLUMN_STATUS };
		String selection = Rate.COLUMN_ISBN + " = ?";
		String[] selectionArgs = { book.getIsbn() };

		String groupBy = null;
		String having = null;
		String orderBy = null;
		dbHelper = new DataBaseHelper(this);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		try {
			Cursor cursor = db.query(Rate.TABLE_NAME, cols, selection,
					selectionArgs, groupBy, having, orderBy);

			// TODO:

			if (cursor.moveToFirst()) {

				rate = new Rate();
				
				rate.setStatus(EnumStatus.get((Integer) cursor.getInt(2)));
				rate.setRate(EnumRate.get((Integer) cursor.getInt(3)));
				
			}
			
		} finally {
			db.close();
			dbHelper.close();
		}
	}

	/**
	 * ユーザ設定ステータスを保存します
	 */
	private void setStatus(int status) {
		ContentValues values = new ContentValues();

		values.put(Rate.COLUMN_ISBN, book.getIsbn());
		values.put(Rate.COLUMN_STATUS, status);

		dbHelper = new DataBaseHelper(this);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		db.beginTransaction();
		try {
			db.insertWithOnConflict(Rate.TABLE_NAME, null, values,
					SQLiteDatabase.CONFLICT_REPLACE);
			db.setTransactionSuccessful();
		} finally {
			db.endTransaction();
			db.close();
			dbHelper.close();
		}
	}

	/**
	 * ユーザ設定レートを保存します
	 */
	private void setRate(int rate) {
		ContentValues values = new ContentValues();

		values.put(Rate.COLUMN_ISBN, book.getIsbn());
		values.put(Rate.COLUMN_RATE, rate);

		dbHelper = new DataBaseHelper(this);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		db.beginTransaction();
		try {
			db.insertWithOnConflict(Rate.TABLE_NAME, null, values,
					SQLiteDatabase.CONFLICT_REPLACE);
			db.setTransactionSuccessful();
		} finally {
			db.endTransaction();
			db.close();
			dbHelper.close();
		}
	}

	/**
	 * ブック情報を設定します
	 * 
	 * @param book
	 */
	private void setBookInfo() {

		TextView tv1 = (TextView) findViewById(R.id.book_title_text);
		tv1.setText(book.getTitle());

		TextView tv2 = (TextView) findViewById(R.id.book_author_text);
		tv2.setText(book.getAuthor());

		TextView tv3 = (TextView) findViewById(R.id.book_publisher_text);
		tv3.setText(book.getPublisherName());

		TextView tv4 = (TextView) findViewById(R.id.book_price_text);
		tv4.setText(book.getItemPrice().toString());

		TextView tv5 = (TextView) findViewById(R.id.book_sales_date_text);
		tv5.setText(book.getSalesDate());

		TextView tv6 = (TextView) findViewById(R.id.book_caption_text);
		tv6.setText(book.getItemCaption());
	}
}
