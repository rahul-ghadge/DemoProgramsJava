package pack1;

abstract public class Instrument {
	
	abstract void play();
	
	public static void main(String[] args) {
		Instrument i[] = new Instrument[10];
		i[0]=new Piano();
		i[1]=new Flute();
		i[2]=new Guitar();
		i[3]=new Piano();
		i[4]=new Flute();
		i[5]=new Guitar();
		i[6]=new Piano();
		i[7]=new Flute();
		i[8]=new Guitar();
		i[9]=new Piano();
		
		for(int j=0;j<10;j++)
		{
			i[j].play();
		}
		
		for(int j=0;j<i.length;j++)
		{
			if(i[j] instanceof Piano)
			{
				System.out.println("Instance of Piano");
			}
			
			else if(i[j] instanceof Flute)
			{
				System.out.println("Instance of Flute");
			}
			
			else
			{
				System.out.println("Instance of Guitar");
			}
			
		}
	}	

}


class Piano extends Instrument
{
	void play()
	{
		System.out.println("Piano is Playing tan tan tan tan");
	}
}

class Flute extends Instrument
{
	void play()
	{
		System.out.println("Flute is Playing toot toot toot tot");
	}
}

class Guitar extends Instrument
{
	void play()
	{
		System.out.println("Guitar is Playing tin tin tin tin");
	}
}


