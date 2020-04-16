
public class Note 
{
	private String name;
	private int value;
	
	public Note(String name, int value)
	{
		this.name = name;
		this.value = value;
	}
	
	public Note(String name)
	{
		this.name = name;
		this.value = 0;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void incValue(int value)
	{
		this.value += value;
	}
	
	public String getName()
	{
		return name;
	}
	
	public static Note stringToNote(String note)
	{
		int value = 0;
		String letter = note.substring(0, 1);
		
		if(note.length() > 1)
		{
			if(note.substring(1).equals("##"))
			{
				value = 2;
			}
			if(note.substring(1).equals("#"))
			{
				value = 1;
			}
			if(note.substring(1).equals("b"))
			{
				value = -1;
			}
			if(note.substring(1).equals("bb"))
			{
				value = -2;
			}
		}
		
		return new Note(letter, value);
	}
	
	public String toString()
	{
		String returning = name;
		if(value == 2)
		{
			returning += "##";
		}
		else if(value == 1)
		{
			returning += "#";
		}
		else if(value == -1)
		{
			returning += "b";
		}
		else if(value == -2)
		{
			returning += "bb";
		}
		return returning;
	}
	
	public boolean equals(Note other)
	{
		if(this.getName().equals(other.getName()))
		{
			if(this.getValue() == other.getValue())
			{
				return true;
			}
		}
		return false;
	}
}
