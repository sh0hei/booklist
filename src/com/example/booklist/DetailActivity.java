package com.example.booklist;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		Bundle extras = getIntent().getExtras();
		Book book = (Book) extras.getSerializable("book");

		setBookInfo(book);

		// スピナーのアイテムが選択された時に呼び出されるコールバックリスナーを登録します
		Spinner spinner = (Spinner) this.findViewById(R.id.spinner1);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			// Spinnerのドロップダウンアイテムが選択された時
			public void onItemSelected(AdapterView<?> parent, View viw,
					int arg2, long arg3) {
				Spinner spinner = (Spinner) parent;
				String item = (String) spinner.getSelectedItem();
				Toast.makeText(DetailActivity.this, item, Toast.LENGTH_LONG)
						.show();
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

	private void setBookInfo(Book book) {
		
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
