package model;

import java.sql.Date;

public class OrderingVO {

	private int orderno;
	private int productno;
	private String productname;
	private int productprice;
	private int productamount;
	private Date orderdate;

	public OrderingVO() {
		super();
	}

	public OrderingVO(int orderno, int productno, String productname, int productprice, int productamount) {
		super();
		this.orderno = orderno;
		this.productno = productno;
		this.productname = productname;
		this.productprice = productprice;
		this.productamount = productamount;
	}

	public OrderingVO(int orderno, int productno, String productname, int productprice, int productamount,
			Date orderdate) {
		super();
		this.orderno = orderno;
		this.productno = productno;
		this.productname = productname;
		this.productprice = productprice;
		this.productamount = productamount;
		this.orderdate = orderdate;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
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

	public int getProductamount() {
		return productamount;
	}

	public void setProductamount(int productamount) {
		this.productamount = productamount;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

}
