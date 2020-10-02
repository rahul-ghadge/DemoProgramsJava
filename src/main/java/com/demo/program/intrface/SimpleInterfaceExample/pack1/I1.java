package pack1;

public interface I1 {

	int z=64;
	void show();
}

interface I2
{
	void show();
	void display();
}

interface I3 extends I1,I2
{
	void myMethod();
	void show();
}

