package com.map;

public class Student implements Comparable<Student>{
	
	private int rollNo;
	private String name;
	private float percentage;
	public Student(int rollNo, String name, float percentage) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", percentage="
				+ percentage + "]";
	}
	
	public int compareTo(Student s)
	{
		return this.rollNo-s.rollNo;
	}
	public int getRollNo() {
		return rollNo;
	}
	public String getName() {
		return name;
	}
	public float getPercentage() {
		return percentage;
	}
	
}
