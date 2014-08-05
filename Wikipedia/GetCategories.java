	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.OutputStreamWriter;
	import java.util.ArrayList;
	import java.util.List;

	import org.jsoup.Jsoup;
	import org.jsoup.nodes.Document;
	import org.jsoup.nodes.Element;
	import org.jsoup.nodes.Node;


	public class GetCategorie {

		public static void main(String[] args) throws IOException,org.jsoup.HttpStatusException {
		
		 //Choose your encoding file option
		//	System.setProperty( "file.encoding", "ANSI" );
			String filePath = "Your file Path to article list";
			String filePath2="Your file Path to the new file";
			
			//Count the line treatment
			int j=0;
			
			try{
		  
		  //Choose depend on the encoding system
				//BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF8")));	
				BufferedReader buff = new BufferedReader(new FileReader(filePath));	
				String line;
			while ((line = buff.readLine()) != null) {
				  j++;

		  //Print Line, print article name  
			 //	System.out.println(j);
			 //	System.out.println(line);
					
					
				//Connection to wikipedia url
				Document doc = Jsoup.connect("http://fr.wikipedia.org/wiki/" +line).timeout(0).ignoreHttpErrors(true).ignoreContentType(true).get();
				
				//Get the div of category
				Element titles = doc.select("div .mw-normal-catlinks").first();
				
				//Put the result in a list
				List<Node> al = new ArrayList<Node>(); 
				al = titles.childNodes().get(2).childNodes();
			//System.out.println(al.size());
			
			//Scan the list
				for (int i=0;i<al.size();i++) {
						Node test = titles.childNodes().get(2).childNode(i);
						Element test2 = (Element)(test);
						
						//Get the text of the element
						String res = test2.text();
						
						
						//Write the result in the new file
						if (i == 0) {
						  FileWriter fw = new FileWriter(filePath2,true);
						  BufferedWriter output = new BufferedWriter(fw);	
						//BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath2,true),"UTF-8"));

						  output.write(line+","+ res);
						  output.flush();
						  output.close();
						  //System.out.print(line+","+ res);
						} else {
							FileWriter fw = new FileWriter(filePath2,true);
							BufferedWriter output = new BufferedWriter(fw);
						//System.out.print(","+ res);
							output.write("," + res);
							output.flush();
							output.close();
						}
				  }
				
				FileWriter fw = new FileWriter(filePath2,true);
				BufferedWriter output = new BufferedWriter(fw);
				output.write("\n");
				output.flush();
				output.close();
				//System.out.println();
					
				}
			}
		  }	catch (IOException ioe) {
			// erreur de fermeture des flux	
				System.out.println("Erreur --" + ioe.toString());
			}
		}
	}

