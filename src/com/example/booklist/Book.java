package com.example.booklist;

import java.io.Serializable;

/**
 * <p>
 * Book Class
 * 
 * @author sh0hei
 */
public class Book implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String TABLE_NAME = "books";
	
	// todo
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_TITLE = "title";
	public static final String COLUMN_TITLE_KANA = "title_kana";
	public static final String COLUMN_SUBTITLE = "subtitle";
	public static final String COLUMN_SUBTITLE_KANA = "subtitle_kana";
	public static final String COLUMN_SERIES_NAME = "series_name";
	public static final String COLUMN_SERIES_NAME_KANA = "series_name_kana";
	public static final String COLUMN_AUTHOR = "author";
	public static final String COLUMN_AUTHOR_KANA = "author_kana";
	public static final String COLUMN_PUBLISHER_NAME = "publisher_name";
	public static final String COLUMN_SIZE = "size";
	public static final String COLUMN_ISBN = "isbn";
	public static final String COLUMN_ITEM_CAPTION = "item_caption";
	public static final String COLUMN_SALES_DATE = "sales_date";
	public static final String COLUMN_ITEM_PRICE = "item_price";
	public static final String COLUMN_ITEM_URL = "item_url";
	public static final String COLUMN_SMALL_IMAGE_URL = "small_image_url";
	public static final String COLUMN_MEDIUM_IMAGE_URL = "medium_image_url";
	public static final String COLUMN_LARGE_IMAGE_URL = "large_image_url";
			
	// 書籍タイトル
	private String title;

	// 書籍タイトルカナ
	private String titleKana;

	// 書籍サブタイトル
	private String subtitle;

	// 書籍サブタイトルカナ
	private String subtitleKana;

	// 叢書名
	private String seriesName;

	// 叢書名カナ
	private String seriesNameKana;

	// 著者名
	private String author;

	// 著者名カナ
	private String authorKana;

	// 出版社名
	private String publisherName;

	// 書籍のサイズ
	private String size;

	// ISBNコード
	private String isbn;

	// 商品説明文
	private String itemCaption;

	// 発売日
	private String salesDate;

	// 税込販売価格
	private Integer itemPrice;

	// 商品URL
	private String itemUrl;

	// 商品画像 (64x64) URL
	private String smallImageUrl;

	// 商品画像 (128x128) URL
	private String mediumImageUrl;

	// 商品画像 (200x200) URL
	private String largeImageUrl;

	
	public Book(String title, String isbn, String author, String publisherName, Integer itemPrice, String salesDate, String itemCaption) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.publisherName = publisherName;
		this.itemPrice = itemPrice;
		this.salesDate = salesDate;
		this.itemCaption = itemCaption;
				
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the titleKana
	 */
	public String getTitleKana() {
		return titleKana;
	}

	/**
	 * @param titleKana
	 *            the titleKana to set
	 */
	public void setTitleKana(String titleKana) {
		this.titleKana = titleKana;
	}

	/**
	 * @return the subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * @param subtitle
	 *            the subtitle to set
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	/**
	 * @return the subtitleKana
	 */
	public String getSubtitleKana() {
		return subtitleKana;
	}

	/**
	 * @param subtitleKana
	 *            the subtitleKana to set
	 */
	public void setSubtitleKana(String subtitleKana) {
		this.subtitleKana = subtitleKana;
	}

	/**
	 * @return the seriesName
	 */
	public String getSeriesName() {
		return seriesName;
	}

	/**
	 * @param seriesName
	 *            the seriesName to set
	 */
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	/**
	 * @return the seriesNameKana
	 */
	public String getSeriesNameKana() {
		return seriesNameKana;
	}

	/**
	 * @param seriesNameKana
	 *            the seriesNameKana to set
	 */
	public void setSeriesNameKana(String seriesNameKana) {
		this.seriesNameKana = seriesNameKana;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the authorKana
	 */
	public String getAuthorKana() {
		return authorKana;
	}

	/**
	 * @param authorKana
	 *            the authorKana to set
	 */
	public void setAuthorKana(String authorKana) {
		this.authorKana = authorKana;
	}

	/**
	 * @return the publisherName
	 */
	public String getPublisherName() {
		return publisherName;
	}

	/**
	 * @param publisherName
	 *            the publisherName to set
	 */
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn
	 *            the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the itemCaption
	 */
	public String getItemCaption() {
		return itemCaption;
	}

	/**
	 * @param itemCaption
	 *            the itemCaption to set
	 */
	public void setItemCaption(String itemCaption) {
		this.itemCaption = itemCaption;
	}

	/**
	 * @return the salesDate
	 */
	public String getSalesDate() {
		return salesDate;
	}

	/**
	 * @param salesDate
	 *            the salesDate to set
	 */
	public void setSalesDate(String salesDate) {
		this.salesDate = salesDate;
	}

	/**
	 * @return the itemPrice
	 */
	public Integer getItemPrice() {
		return itemPrice;
	}

	/**
	 * @param itemPrice
	 *            the itemPrice to set
	 */
	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * @return the itemUrl
	 */
	public String getItemUrl() {
		return itemUrl;
	}

	/**
	 * @param itemUrl
	 *            the itemUrl to set
	 */
	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}

	/**
	 * @return the smallImageUrl
	 */
	public String getSmallImageUrl() {
		return smallImageUrl;
	}

	/**
	 * @param smallImageUrl
	 *            the smallImageUrl to set
	 */
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}

	/**
	 * @return the mediumImageUrl
	 */
	public String getMediumImageUrl() {
		return mediumImageUrl;
	}

	/**
	 * @param mediumImageUrl
	 *            the mediumImageUrl to set
	 */
	public void setMediumImageUrl(String mediumImageUrl) {
		this.mediumImageUrl = mediumImageUrl;
	}

	/**
	 * @return the largeImageUrl
	 */
	public String getLargeImageUrl() {
		return largeImageUrl;
	}

	/**
	 * @param largeImageUrl
	 *            the largeImageUrl to set
	 */
	public void setLargeImageUrl(String largeImageUrl) {
		this.largeImageUrl = largeImageUrl;
	}

	@Override
	public String toString() {
		return title;
	}

}
