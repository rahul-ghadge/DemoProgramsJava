package com.demo.program.copy;


public class DeepCopyUsingClone {

	public static void main(String[] args) {
		
		SuperHeroNew thorOriginal = new SuperHeroNew("Thor", "Thor", 500,
				new ProfessionNew("King", "Ruling Kingdom", true)
		);

		
		try {
			SuperHeroNew thorCopy = (SuperHeroNew) thorOriginal.clone();

			System.out.println("Before copy :: " + thorOriginal.profession.name);

			thorCopy.profession.name = "Protecting his kingdome";

			System.out.println("After copy Obj-1 :: " + thorOriginal.profession.name);

			System.out.println("After copy Obj-2:: " + thorCopy.profession.name);

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}


class ProfessionNew implements Cloneable {
	public String category;
	public String name;
	public boolean isGoodJob;
	
	public ProfessionNew(String category, String name, boolean isGoodJob) {
		super();
		this.category = category;
		this.name = name;
		this.isGoodJob = isGoodJob;
	}
	
	//Default clone() method creates shallow copy of an object.
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
    }
}

class SuperHeroNew implements Cloneable {
	
	public String name;
	public String superName;
	public int age;
	
	public ProfessionNew profession;
	
	public SuperHeroNew(String name, String superName, int age, ProfessionNew profession) {
		super();
		this.name = name;
		this.superName = superName;
		this.age = age;
		this.profession = profession;
	}
	
	//Default clone() method creates shallow copy of an object.
	@Override
	protected Object clone() throws CloneNotSupportedException {
        
		SuperHeroNew cloned = (SuperHeroNew) super.clone();
		cloned.profession = (ProfessionNew) cloned.profession.clone();
		
		return cloned;
        
    }
}



//	Output
	
//	Before copy :: Ruling Kingdom
//	After copy Obj-1 :: Ruling Kingdom
//	After copy Obj-2:: Protecting his kingdome
