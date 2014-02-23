package com.example.booklist;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * List Activity
 * 
 * @author sh0hei
 */
public class ListActivity extends Activity {

	private ListView listView;
	private List<Book> bookList;
	private ArrayAdapter<Book> arrayAdapter;

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
			String title = (String) ((Book)listView.getItemAtPosition(position)).getTitle();
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
		bookList = new ArrayList<Book>();
		bookList.add(new Book("エキスパート C プログラミング", "111", "sh0hei shimomura", "Fizz出版", 2800, "2013/03/10", "じゅげむじゅげむ"));
		bookList.add(new Book("Effective Java 2nd Edition", "111", "sh0hei shimomura", "Buzz出版", 4200, "2013/04/12", "ごこうのすりきれ"));
		bookList.add(new Book("いかにして問題を解くか", "111", "sh0hei shimomura", "Foo出版", 3200, "2012/12/30", "しょうひんせつめいぶん"));
		bookList.add(new Book("プログラミングの心理学", "222", "sh0hei shimomura", "Bar出版", 3800, "2009/01/03", "わいんばーぐ"));
		bookList.add(new Book("K&R 第2版", "333", "sh0hei shimomura", "Ascii出版", 2700, "1984/01/01", "ばいぶるばいぶる"));
		bookList.add(new Book("デザインパターン徹底攻略", "444", "sh0hei shimomura", "でざぱた出版", 3300, "2002/04/23", "でざぱたー"));
		bookList.add(new Book("計算機プログラムの構造と解釈", "444", "sh0hei shimomura", "MIT出版", 4800, "1992/01/30", "魔術師本！！"));
	}

	/**
	 * 
	 */
	protected void addItem() {
		arrayAdapter.add(new Book("The Hacker Delight", "1400987234", "Sh0hei Shimomura", "いんぷれすじゃぱん", 2800, "2004/10/07", "はっかーのたのしみ"));
	}
}
