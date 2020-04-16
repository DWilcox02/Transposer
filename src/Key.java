import java.util.ArrayList;

public class Key 
{
	private int numSharps;
	private int numFlats;
	private ArrayList<Note> key;
	private String name;
	
	public Key(String name)
	{
		key = new ArrayList<Note>();
		this.name = name;
	}
	
	public void addNote(Note note)
	{
		key.add(note);
	}
	
	public Note getNote(int index)
	{
		return key.get(index);
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		String total = "";
		for(int i = 0; i < key.size(); i++)
		{
			total += key.get(i) + " ";
		}
		return total;
	}
	
	public int indexOfString(String note)
	{
		for(int i = 0; i < key.size(); i++)
		{
			if(key.get(i).getName().equals(note))
			{
				return i;
			}
		}
		return -1;
	}
}
