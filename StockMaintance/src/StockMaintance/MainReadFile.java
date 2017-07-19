/**
 * 
 */
/**
 * @author sriraman_d
 *
 */
package StockMaintance;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MainReadFile {
    private static Scanner sc;
    public static HashMap<String, Double> hash=new HashMap<String, Double>();
	public static void  main(String[] args)  {
    		sc = new Scanner(System.in);  
	    	String File=sc.next();
	    	ReadFile(File);
	}
	
	public static HashMap<Double, String> ReadFile(String Filename){
		HashMap< Double,String> versionString=null;
		try{
	    	if(Filename.contains(".txt")){
		    	hash=ReadingRate();
		    	versionString = readingLinesfromFiles(Filename);
		    	Set<Entry<Double, String>> entrySet = versionString.entrySet();
		    	List<Double> list= new ArrayList<Double>();
		    	   for (Entry<Double, String> entry : entrySet){
		    	     list.add(entry.getKey());
		    	   }
		    	   Collections.sort(list, Collections.reverseOrder());
		    	   for(Double D:list){
		    		  for (Entry<Double, String> entry : entrySet) 
			    	   {
		    			  if(D==entry.getKey()){
		    				  System.out.println(entry.getValue());
		    			  }
			    	   }
		    		  
		    	  }
	    	}else{
	    		System.out.println("Given document is not in prescribed extention");
	    	}
		}catch(NullPointerException e){
			System.out.println("Given document is not in prescribed fromat");
		}catch (FileNotFoundException e) {
			System.out.println("Given document is not found in location");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return versionString;
	}

	private static HashMap<String, Double> ReadingRate() throws IOException {
		 try {
	            FileReader reader = new FileReader("rate.txt");
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
	        }catch (NumberFormatException e) {
	            System.out.println("Please fill correct rate in rate document");
	        }
		 return hash;
	}

    public static  HashMap< Double,String> readingLinesfromFiles(String Filename) throws Exception {
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
	        	}catch(NullPointerException e) {
	        		    System.out.println("Without correct rate we cant proceed further");
	        	}
	return Valuehash;
    }
}
