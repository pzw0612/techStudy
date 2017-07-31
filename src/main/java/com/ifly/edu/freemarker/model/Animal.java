package com.ifly.edu.freemarker.model;

/**
 *
 * @Description: TODO
 * @author pangzhw
 * @date 2015年2月28日
 */
public class Animal {

	private String name;
	
	private String size;
	
	private Integer price;
	
	private boolean protecte=true;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public boolean getProtected() {
		return protecte;
	}

	public void setProtecte(boolean protecte) {
		this.protecte = protecte;
	}

	/**
	 * @param size
	 * @param price
	 */
	public Animal(String size, Integer price,String name,boolean protecte) {
		this.size = size;
		this.price = price;
		this.name = name;
		this.protecte =protecte;
	}
	
	/**
	 * @param size
	 * @param price
	 */
	public Animal(String size, Integer price,String name) {
		this(size,price,name,true);
	}
	
	/**
	 * @param size
	 * @param price
	 */
	public Animal(String size, Integer price) {
		this(size,price,null);
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Animal [size=" + size + ", price=" + price + "]";
	}
	
	
}
