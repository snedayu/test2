
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class Test2 
{
   public static void main(String[] args) 
   {
        
        System.out.println("Fetching....data is saved in Result.txt");
        Document document;
        
	try 
        {
            PrintStream txt = new PrintStream(new File("Result.txt")); 
            PrintStream con= System.out; 
            //PHP WIKI
            document = Jsoup.connect("https://en.wikipedia.org/wiki/PHP").get();
            
            System.setOut(txt);
            //TABLE OF CONTENT
            System.out.println("\nTABLE OF CONTENT\n");
            Elements contentNum = document.select("span.tocnumber"); //Get table of contents number
            Elements contentE = document.select("span.toctext"); //Get table of contents 
            int length=contentNum.size();
            for(int i=0;i<length;i++)
            {
                    System.out.println(contentNum.get(i).text()+"\t"+contentE.get(i).text());  //Print table of contents
            }
            
            //PICTURE
            System.out.println("\nPICTURE\n");        
            Elements media = document.select("[src]");//Get pictures
            
           
            int j=0;
            
            for (Element src : media) 
            {
                if (src.tagName().equals("img"))
                    System.out.println((j+1)+"\t"+ src.tagName()+ src.attr("abs:src")+ src.attr("width")+ src.attr("height"));
                else
                    System.out.println((j+1)+"\t"+ src.tagName() + src.attr("abs:src"));
               
                j++;
            }
            
              
            //REFERENCE
            System.out.println("\nREFERENCE\n"); 
            Elements refText = document.select("span.reference-text");//Get reference
            
            int num=refText.size();
            for(int i=0;i<num;i++)
            {
                    System.out.println((i+1)+"\t"+refText.get(i).text());  //Print references
            }   
            
	} 
        catch (IOException e) 
        {
	}
        		
    }
    
}
