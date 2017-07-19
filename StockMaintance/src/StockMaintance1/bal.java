package StockMaintance1;


	
	/**
	 * 
	 */
	/**
	 * @author sriraman_d
	 *
	 */


	import java.io.IOException;
	import java.nio.charset.StandardCharsets;
	import java.nio.file.Files;
	import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

	public class bal {
		public static HashMap<String, Double> hash=new HashMap<String, Double>();
	    public static void main(String[] args) throws IOException {
	        String versionString = readStreamOfLinesUsingFiles();
	        System.out.println(versionString);
	    }

	    private static String readStreamOfLinesUsingFiles() throws IOException {
	    
	    List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\sriraman_d\\Desktop\\test.txt"), StandardCharsets.UTF_8);
	   
	    for(String IterateLines: lines){
		  System.out.println(IterateLines);
		  List<String> LineSpliter = Arrays.asList(IterateLines.split("-"));
		  for(String IterateCommaSeperate: LineSpliter){
			  String[] SplitByMinus = IterateCommaSeperate.split("-");
			  String Var=SplitByMinus[0];
			  double duo=Double.parseDouble(SplitByMinus[1]);
			  hash.put(Var, duo);
          	  System.out.println("total"+hash); 
		 
		  }
	  
	    }
	    System.out.println(lines);
	return null;
	    }
	}


