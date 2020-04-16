import java.util.Scanner;

public class Runner 
{
	private Transpose poser;
	private Scanner input;
	
	
	public static void main(String arg[])
	{
		Runner runner = new Runner();
	}
	
	public Runner()
	{
		input = new Scanner(System.in);
		poser = new Transpose();
		
		System.out.println("What instrument key");
		String instKey = input.nextLine();
		System.out.println("Key for next instrument");
		String nextKey = input.nextLine();
		
		Key currentInstKey = poser.getKey(Note.stringToNote(instKey));
		Key nextInstKey = poser.getKey(Note.stringToNote(nextKey));
		
		System.out.println("Key of piece");
		String pieceKeyString = input.nextLine();
		
		Note newKeyNote = transposeNote(currentInstKey, nextInstKey, pieceKeyString);
		
		Key newKey = poser.getKey(newKeyNote);
		
		System.out.println("New key is " + newKeyNote.toString() + " major");
		System.out.println("Enter notes with space between. Press enter to transpose. Type \"stop\" to stop");
		String note = input.nextLine();
		
		while(!note.equals("stop"))
		{
			int changing = 1;
			String total = "";
			for(int i = 0; i < note.length(); i += changing)
			{
				String temp = "";
				
				innerloop:
				for(int j = i; j < note.length(); j++)
				{
					String character = note.substring(j, j+1);
					if(character.equals(" "))
					{
						total += " ";
						break innerloop;
					}
					temp += character;
					changing++;
				}
				total += transposeNote(currentInstKey, nextInstKey, temp).toString();
			}
			note = input.nextLine();
		}
	}
	
	public Note transposeNote(Key current, Key next, String note)
	{
		Note newNote = poser.transpose(current, next, Note.stringToNote(note));
		System.out.println(newNote.toString());
		return newNote;
	}
}
