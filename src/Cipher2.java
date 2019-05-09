import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;

public class Cipher2
{
	
	public static void main(String[] args) throws IOException
	{
		boolean encrypt;
		String cipher = "";
		String fileName;
		int shiftAmount = 0;
		PrintWriter outputFile;
		String ans;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Would you like to encrypt, decrypt, or crack a file?");
		String encdec = keyboard.nextLine();
		while((!encdec.equals("encrypt"))&&(!encdec.equals("decrypt"))&&(!encdec.equals("crack")))
		{
			System.out.println("Would you like to encrypt, decrypt, or crack a file?");
			encdec = keyboard.nextLine();
		}
		//######################################
		String cp;
		System.out.println("What algorithm would you like to use? ('c' for caesar or 'p'  for permutation");
		cp = keyboard.nextLine();
		if (cp.equals("c"))
		{
			
		}
		else if (cp.equals("p"))
		{
			char[] perm = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
			System.out.println("The following permuted alphabet will be used for encryption");
		}
		
		if (encdec.equals("encrypt"))
		{
			encrypt = true;
			System.out.println("How many places should the alphabet be shifted? ");
			shiftAmount = keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Enter a file name to encrypt: ");
			fileName = keyboard.nextLine();
			cipher = caesar_cipher(fileName, encrypt, shiftAmount);
			outputFile = new PrintWriter(fileName.substring(0, fileName.length()-4) + "_ENC.txt");
			System.out.print("Result written to " + fileName.substring(0, fileName.length()-4) + "_ENC.txt");
		}
		else if (encdec.equals("decrypt"))
		{
			encrypt = false;
			System.out.println("How many places should the alphabet be shifted? ");
			shiftAmount = keyboard.nextInt();
			shiftAmount *= -1;
			keyboard.nextLine();
			System.out.println("Enter a file name to decrypt: ");
			fileName = keyboard.nextLine();
			cipher = caesar_cipher(fileName, encrypt, shiftAmount);
			outputFile = new PrintWriter(fileName.substring(0, fileName.length()-4) + "_DEC.txt");
			System.out.print("Result written to " + fileName.substring(0, fileName.length()-4) + "_DEC.txt");
		}
		else// if (encdec.equals("crack"))
		{
			encrypt = false;
			System.out.print("Enter a file name to crack: ");
			fileName = keyboard.nextLine();
			outputFile = new PrintWriter(fileName.substring(0, fileName.length()-4) + "_DEC.txt");
			for (int i = 0; i < 25; i++)
			{
				cipher = caesar_cipher(fileName, encrypt, i);
				System.out.println("---");
				System.out.println(cipher.substring(0, 100));
				System.out.println("---");
				System.out.println("Does this look right?");
				ans = keyboard.nextLine();
				if (ans.equals("yes"))
					i += 26;
				else
				{
				}
			}
			System.out.print("Result written to " + fileName.substring(0, fileName.length()-4) + "_DEC.txt");
		}				
		outputFile.print(cipher);
		outputFile.close();
	}
	public static String perm_cipher(String fileName, boolean encrypt, char[] perm)
	{
		Random rand;
		for (int i = 0; i < 25; i++)
		{
			rand = new Random();
			int index  = rand.nextInt(25);
			char temp =  perm[i];
			perm[i] = perm[index];
			perm[index] = temp;
		}
		return perm[];
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