import java.util.*;

public class Transpose 
{
	private ArrayList<Key> circleOfFifths = new ArrayList<Key>();
	
	private KeyFormer former = new KeyFormer();
	
	public Transpose()
	{
		setUpCircle();
	}
	
	public void setUpCircle()
	{
		Key currentKey = former.formKey(0, 6, Note.stringToNote("Gb"));
		circleOfFifths.add(currentKey);
		for(int i = -5; i <= 6; i++)
		{
			int currValue = i;
			if(currValue <= 0)
			{
				currValue *= -1;
				Note nextNote = currentKey.getNote(4);
				Key newKey = former.formKey(0, currValue, nextNote);
				circleOfFifths.add(newKey);
				currentKey = newKey;
			}
			else
			{
				Note nextNote = currentKey.getNote(4);
				Key newKey = former.formKey(currValue, 0, nextNote);
				circleOfFifths.add(newKey);
				currentKey = newKey;
			}
		}
		
//		for(int i = 0; i < circleOfFifths.size(); i++)
//		{
//			System.out.println(circleOfFifths.get(i).toString());
//		}
	}
	
	public Note transpose(Key current, Key next, Note note)
	{
		int firstIndex = next.indexOfString(note.getName());
		Note newNote = new Note(current.getNote(firstIndex).getName(), current.getNote(firstIndex).getValue());
		int value1 = note.getValue();
		Note note2 = next.getNote(firstIndex);
		int value2 = note2.getValue();
		if(value1 != value2)
		{
			int diff = value1 - value2;
			newNote.incValue(diff);
		}
		return newNote;
	}
	
	public Key getKey(Note leading)
	{
		for(int i = 0; i < circleOfFifths.size(); i++)
		{
			if(leading.equals(circleOfFifths.get(i).getNote(0)))
			{
				return circleOfFifths.get(i);
			}
		}
		return null;
	}
}
