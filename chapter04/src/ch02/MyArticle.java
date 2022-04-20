package ch02;

// 호출 하는 객체 ( 호출자 )
public class MyArticle {

	String article;
	WriteArticle onWriteArticle;

	public MyArticle(String article, WriteArticle onwriteArticle) {
		this.article = article;
		this.onWriteArticle = onwriteArticle;
	}
	
	public void complete() {
		onWriteArticle.printArticle(article);
	}
}
