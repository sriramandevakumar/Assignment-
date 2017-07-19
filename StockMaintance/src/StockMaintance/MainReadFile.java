/**
 * 
 */
/**
 * @author sriraman_d
 *
 */
package StockMaintance;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MainReadFile {
    private static Scanner sc;
    public static HashMap<String, Double> hash=new HashMap<String, Double>();
	public static void main(String[] args) throws IOException {
    	sc = new Scanner(System.in);  
    	String Filename=sc.next();
    	hash=ReadingRate();
    	HashMap< Double,String> versionString = readingLinesfromFiles(Filename);
    	Set<Entry<Double, String>> entrySet = versionString.entrySet();
    	   for (Entry<Double, String> entry : entrySet) 
    	   {
    	      System.out.println(entry.getValue());
    	   }
    }
	

	private static HashMap<String, Double> ReadingRate() throws IOException {
		 try {
	            FileReader reader = new FileReader("C:\\Users\\sriraman_d\\Desktop\\rate.txt");
	            BufferedReader bufferedReader = new BufferedReader(reader);
	            String line;
	            while ((line = bufferedReader.readLine()) != null) {
	            	if(line.contains("-")){
		            	List<String> LineSpliter = Arrays.asList(line.split("-"));
		            	if(LineSpliter.size()>=2){
			            	String Key=LineSpliter.get(0).trim();
			            	double VAlue=Double.parseDouble(LineSpliter.get(1).trim());
			            	hash.put(Key, VAlue);
		            	}
	            	}
	            }
	            reader.close();
	        }catch (IOException e) {
	            e.printStackTrace();
	        }
		 return hash;	
	}

    private static  HashMap< Double,String> readingLinesfromFiles(String Filename) throws IOException {
    	   HashMap< Double,String> Valuehash=new HashMap< Double,String>();
		   try {	
		            FileReader reader = new FileReader(Filename);
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            double Value=0;
		            String variable=null;
		            while ((line = bufferedReader.readLine()) != null){
		            		double total=0;
			            	List<String> LineSpliter = Arrays.asList(line.split(","));
			                for(int i=0;i<LineSpliter.size();i++){
			                	String[] Key=LineSpliter.get(i).split("-");
			                	if(Key.length>=2){
				                	variable =Key[0].trim();
				                	Value=Double.parseDouble(Key[1].trim())*hash.get(variable);
				                	total=total+Value;
			                	}
			                }
		                	Valuehash.put(total, line);
		            }
		            reader.close();
	        	}catch(IOException e) {
	        		e.printStackTrace();
	        	}
	return Valuehash;
    }
}
