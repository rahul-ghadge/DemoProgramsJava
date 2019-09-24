package com.demo.program.java8;

public class SuperHero {

	private String name;
	private String superName;
	private String profession;
	private int age;
	private boolean canFly;

	public SuperHero(String name, String superName, String profession, int age,
			boolean canFly) {
		super();
		this.name = name;
		this.superName = superName;
		this.profession = profession;
		this.age = age;
		this.canFly = canFly;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuperName() {
		return superName;
	}

	public void setSuperName(String superName) {
		this.superName = superName;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}

	@Override
	public String toString() {
		return "SuperHero [name=" + name + ", superName=" + superName
				+ ", profession=" + profession + ", age=" + age + ", canFly="
				+ canFly + "]";
	}

}
