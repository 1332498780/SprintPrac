package cn.hzy.demo.model;

import java.util.List;

public class Product {
	
	private int id;
	private String name;
	private List<Items> items;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	
	@Override
	public String toString() {
		return "[name:"+this.name+"]";
	}
}
