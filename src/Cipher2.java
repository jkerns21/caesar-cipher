import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cipher2
{
	
	public static void main(String[] args) throws IOException
	{
		boolean encrypt;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Would you like to encrypt, decrypt, or crack a file?");
		String encdec = keyboard.nextLine();
		
		while((!encdec.equals("encrypt"))&&(!encdec.equals("decrypt"))&&(!encdec.equals("crack")))
		{
			System.out.println("Would you like to encrypt, decrypt, or crack a file?");
			encdec = keyboard.nextLine();
		}
		
		
		if (encdec.equals("encrypt"))
		{
			encrypt = true;
		}
		else if (encdec.equals("decrypt"))
		{
			encrypt = false;
		}
		else// if (encdec.equals("crack"))
		{
			encrypt = true;
		}
		
		int shiftAmount = 0;
		System.out.println("How many places should the alphabet be shifted? ");
		shiftAmount = keyboard.nextInt();
		if (!encrypt)
			shiftAmount *= -1;
		keyboard.nextLine();
		System.out.println("Enter a file name to ecrypt: ");
		String fileName = keyboard.nextLine();
		//String cipher = "";
		if ((encdec.equals("encrypt"))||(encdec.equals("decrypt")))
			String cipher = caesar_cipher(fileName, encrypt, shiftAmount);
		PrintWriter outputFile;
		if (!encrypt)
		{
			outputFile = new PrintWriter(fileName.substring(0, fileName.length()-4) + "_DEC.txt");
			System.out.print("Result written to " + fileName.substring(0, fileName.length()-4) + "_DEC.txt");
		}
		else
		{
			outputFile = new PrintWriter(fileName.substring(0, fileName.length()-4) + "_ENC.txt");
			System.out.print("Result written to " + fileName.substring(0, fileName.length()-4) + "_ENC.txt");
			
		}
		
		outputFile.print(cipher);
		outputFile.close();
	}
	
	public static String caesar_cipher(String fileName, boolean encrypt, int shiftAmount) throws IOException
	{
		String message  = "";
		String line;
		Scanner inputFile = new Scanner(new File(fileName));
		PrintWriter outputFile;
				
		while(inputFile.hasNext())
		{
			line = inputFile.nextLine();
			line+="\n";
			
			for (int i = 0; i < line.length(); i++)
			{
				String let;
				char letter = line.charAt(i);
				if (letter >= 'a' && letter <= 'z')
				{
					int number = letter -'a';
					number = (number + shiftAmount) % 26;
					if (number < 0)
					{
						number = number + 26;
					}
					char bean = ((char)(number + 'a'));
					message+= (bean);
				}
				else if (letter >= 'A' && letter <= 'Z')
				{
					int number = letter -'A';
					number = (number + shiftAmount) % 26;
					if (number < 0)
					{
						number = number + 26;
					}
					char bean = ((char)(number + 'A'));
					message+= (bean);
				}
				else
				{
					message+= (letter);
				}			
				//message+= "\n";
				
			}
		}
	return message;

}
}