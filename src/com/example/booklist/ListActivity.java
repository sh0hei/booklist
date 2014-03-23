package com.example.booklist;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booklist.db.Book;
import com.example.booklist.db.DataBaseHelper;

/**
 * List Activity
 * 
 * @author sh0hei
 */
public class ListActivity extends Activity {

	private ListView listView;
	private List<Book> bookList;
	private ArrayAdapter<Book> arrayAdapter;
	private DataBaseHelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		addItems();

		findViews();

		setAdapters();

		setEventListener();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void setEventListener() {
		listView.setOnItemClickListener(new DetailForwarder());
		listView.setOnItemLongClickListener(new ContextViewer());
	}

	public class ContextViewer implements OnItemLongClickListener {

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, long id) {
			// 今回は、トースト表示
			ListView listView = (ListView) parent;
			String title = (String) ((Book) listView
					.getItemAtPosition(position)).getTitle();
			Toast.makeText(ListActivity.this, "title: " + title,
					Toast.LENGTH_SHORT).show();

			return true;
		}

	}

	public class DetailForwarder implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {

			ListView listView = (ListView) parent;

			Book book = (Book) listView.getItemAtPosition(position);

			Intent intent = new Intent(ListActivity.this, DetailActivity.class);
			intent.putExtra("book", book);

			startActivity(intent);
		}
	}

	protected void findViews() {
		listView = (ListView) findViewById(R.id.list);
	}

	protected void setAdapters() {
		arrayAdapter = new ArrayAdapter<Book>(this,
				android.R.layout.simple_list_item_1, bookList);
		listView.setAdapter(arrayAdapter);
	}

	/**
	 * 
	 */
	protected void addItems() {

		// queryメソッドでデータを取得
		String[] cols = { Book.COLUMN_TITLE, Book.COLUMN_ISBN,
				Book.COLUMN_AUTHOR, Book.COLUMN_PUBLISHER_NAME,
				Book.COLUMN_ITEM_PRICE, Book.COLUMN_SALES_DATE,
				Book.COLUMN_ITEM_CAPTION };
		// String selection = "No = ?";
		String selection = null;
		// String[] selectionArgs = { "5" };
		String[] selectionArgs = null;
		String groupBy = null;
		String having = null;
		String orderBy = "_id desc";
		dbHelper = new DataBaseHelper(this);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		try {
			bookList = new ArrayList<Book>();

			Cursor cursor = db.query(Book.TABLE_NAME, cols, selection,
					selectionArgs, groupBy, having, orderBy);

			while (cursor.moveToNext()) {
				bookList.add(new Book(cursor.getString(0), cursor.getString(1),
						cursor.getString(2), cursor.getString(3), cursor
								.getInt(4), cursor.getString(5), cursor
								.getString(6)));

			}
		} finally {
			db.close();
			dbHelper.close();
		}

	}

	/**
	 * 
	 */
	protected void addItem() {
		arrayAdapter.add(new Book("The Hacker Delight", "1400987234",
				"Sh0hei Shimomura", "いんぷれすじゃぱん", 2800, "2004/10/07",
				"はっかーのたのしみ"));
	}
}
