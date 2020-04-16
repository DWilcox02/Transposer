import java.util.*;

public class KeyFormer
{
	private ArrayList<Note> notes = new ArrayList<Note>();
	
	private ArrayList<String> sharpList = new ArrayList<String>();
	private ArrayList<String> flatList = new ArrayList<String>();
	
	public KeyFormer()
	{
		initialiseNotes();
	}
	
	private void initialiseNotes()
	{
		notes.add(new Note("C"));
		notes.add(new Note("D"));
		notes.add(new Note("E"));
		notes.add(new Note("F"));
		notes.add(new Note("G"));
		notes.add(new Note("A"));
		notes.add(new Note("B"));
		
		sharpList.add("F");
		sharpList.add("C");
		sharpList.add("G");
		sharpList.add("D");
		sharpList.add("A");
		sharpList.add("E");
		sharpList.add("B");
		
		flatList.add("B");
		flatList.add("E");
		flatList.add("A");
		flatList.add("D");
		flatList.add("G");
		flatList.add("C");
		flatList.add("F");
	}
	
	
	public Key formKey(int numSharps, int numFlats, Note leading)
	{
		String leadingName = leading.getName();
		Key newKey = new Key(leading.toString());
		int index = -1;
		for(int i = 0; i < notes.size(); i++)
		{
			String notesLetter = notes.get(i).getName();
			if(leadingName.equals(notesLetter))
			{
				index = i;
				break;
			}
		}
		newKey.addNote(leading);
		for(int i = 1; i < 7; i++)
		{
			int newIndex = i + index;
			if(newIndex >= 7)
			{
				newIndex -= 7;
			}
			Note temp = new Note(notes.get(newIndex).getName());
			temp = flattenOrSharpen(numSharps, numFlats, temp);
			if(numSharps == 6)
			{
				int noteValue = leading.getValue();
				temp.incValue(noteValue);
			}
			
			newKey.addNote(temp);
		}
		
		return newKey;
	}
	
	public Note flattenOrSharpen(int numSharps, int numFlats, Note note)
	{
		if(numSharps > 0)
		{
			int index = sharpList.indexOf(note.getName());
			if(index < numSharps)
			{
				note.incValue(1);
			}
		}
		if(numFlats > 0)
		{
			int index = flatList.indexOf(note.getName());
			if(index < numFlats)
			{
				note.incValue(-1);
			}
		}
		return note;
	}
}
