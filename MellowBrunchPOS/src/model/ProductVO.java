package model;

public class ProductVO {
	private int productno;
	private String productname;
	private int productprice;
	private String productpicpath;

	public ProductVO() {
		super();
	}

	public ProductVO(int productno, String productname, int productprice) {
		super();
		this.productno = productno;
		this.productname = productname;
		this.productprice = productprice;
	}

	public ProductVO(int productno, String productname, int productprice, String productpicpath) {
		super();
		this.productno = productno;
		this.productname = productname;
		this.productprice = productprice;
		this.productpicpath = productpicpath;
	}

	public String getProductpicpath() {
		return productpicpath;
	}

	public void setProductpicpath(String productpicpath) {
		this.productpicpath = productpicpath;
	}

	public int getProductno() {
		return productno;
	}

	public void setProductno(int productno) {
		this.productno = productno;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getProductprice() {
		return productprice;
	}

	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}

}
