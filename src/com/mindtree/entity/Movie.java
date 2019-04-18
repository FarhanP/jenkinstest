package com.mindtree.entity;

public class Movie 
{
	private int mid;
	private String mname;
	private int budget;
	private int tid;
	private String string2;
	private String string;
	private int int1;
	private String tname;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public Movie(int mid, String mname, int budget, int tid) {
		this.mid = mid;
		this.mname = mname;
		this.budget = budget;
		this.tid = tid;
	}
	public Movie(int mid, String mname, String tname) {
		this.mid=mid;
		this.mname=mname;
		this.tname=tname;
	}
	@Override
	public String toString() {
		return "Movie [mid=" + mid + ", mname=" + mname + ", tname=" + tname + "]";
	}
	
	
}
