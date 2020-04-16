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
		String note = input.nextLine();
		while(!note.equals("stop"))
		{
			transposeNote(note);
			note = input.nextLine();
		}
	}
	
	public void transposeNote(String note)
	{
		Note newNote = poser.transpose(poser.getKey(Note.stringToNote("Bb")), poser.getKey(Note.stringToNote("C")), Note.stringToNote(note));
		System.out.println(newNote.toString());
	}
}
