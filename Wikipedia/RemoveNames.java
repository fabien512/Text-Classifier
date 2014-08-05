import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class RemoveNames {

	public static void main(String[] args) {
	
	  //Encoding in UTF-8
		System.setProperty( "file.encoding", "UTF-8" );
		
		String filePath = "Path to Your File";
		String filePath2="Path to the writing file";
		
		
		try{
			BufferedReader buff = new BufferedReader(new FileReader(filePath));	
			String line;
			int i=0;
			while ((line = buff.readLine()) != null) {
				FileWriter fw = new FileWriter(filePath2,true);
				BufferedWriter output = new BufferedWriter(fw);
				i++;
				//System.out.println(i);
				if (i<6324) {
					output.write(line+ "\n");
					output.flush();
					output.close();
				}
				if (i>=6324 && i<=23400) {
				output.write(line.substring(15,line.length())+ "\n");
				//output.write(line.toLowerCase().replaceAll("\\?", " ").replaceAll("à", "a")
				output.flush();
				output.close();
				}
				if (i>=23401 && i<=53181) {
					output.write(line.substring(16,line.length())+ "\n");
					//output.write(line.toLowerCase().replaceAll("\\?", " ").replaceAll("à", "a")
					output.flush();
					output.close();
					}
				if (i>=53182 && i<=525133) {
					output.write(line.substring(17,line.length())+ "\n");
					//output.write(line.toLowerCase().replaceAll("\\?", " ").replaceAll("à", "a")
					output.flush();
					output.close();
					}
				if (i>=525134 && i<=683000) {
					output.write(line.substring(18,line.length())+ "\n");
					//output.write(line.toLowerCase().replaceAll("\\?", " ").replaceAll("à", "a")
					output.flush();
					output.close();
					}
				if (i>=683001 && i<=3489028) {
					output.write(line.substring(19,line.length())+ "\n");
					//output.write(line.toLowerCase().replaceAll("\\?", " ").replaceAll("à", "a")
					output.flush();
					output.close();
					}
			}
		}	catch (IOException ioe) {
			// erreur de fermeture des flux	
				System.out.println("Erreur --" + ioe.toString());
			}
	}
}
