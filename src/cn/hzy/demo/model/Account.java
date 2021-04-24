package cn.hzy.demo.model;

import java.util.Date;

public class Account {

	private int id;
	private String name;
	private Date createTime;
	private float balance;
	
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "[name:"+name+",balance:"+balance+",createTime:"+createTime.toString()+"]";
	}
	
}
