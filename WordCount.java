import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WordCount {
    
    // Function to count frequency of
    // words in the given string
    static void count_freq(String[] arr)
    {
        Map<String,Integer> mp=new TreeMap<>();
 
        // Splitting to find the word
 
        // Loop to iterate over the words
        for(int i=0;i<arr.length;i++)
        {
            // Condition to check if the
            // array element is present
            // the hash-map
            if(mp.containsKey(arr[i]))
            {
                mp.put(arr[i], mp.get(arr[i])+1);
            }
            else
            {
                mp.put(arr[i],1);
            }
        }
        
        // Loop to iterate over the
        // elements of the map
        for(Map.Entry<String,Integer> entry:
                    mp.entrySet())
        {
            System.out.println(entry.getKey()+
                    " - "+entry.getValue());
        }
    }
 
    // Driver Code
    public static void main(String[] args) {
        String filePath = "/home/riztomo/hadoop/input/500MB.txt";
  
  	String contents = null;

	  	
   	try {
   		contents = new String(Files.readAllBytes(Paths.get(filePath)));
  	} catch (IOException e) {
   		e.printStackTrace();
  	}

  	System.out.println("##### Split string by multiple spaces");
	String[] str = contents.split("\\s+");
 
        // Function Call
        System.out.println("##### Counting words");
        count_freq(str);
    }
}
