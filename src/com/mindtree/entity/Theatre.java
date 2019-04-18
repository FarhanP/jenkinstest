package com.mindtree.entity;

public class Theatre
{
	private int tid;
	private String tname,address;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Theatre(int tid, String tname, String address) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Theatre [tid=" + tid + ", tname=" + tname + ", address=" + address + "]";
	}
	
}
