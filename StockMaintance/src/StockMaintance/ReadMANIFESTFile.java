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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ReadMANIFESTFile {
    private static Scanner sc;
    public static HashMap<String, Double> hash=new HashMap<String, Double>();
	public static void main(String[] args) throws IOException {
		
    	sc = new Scanner(System.in);  
    	String Filename=sc.next();
    	hash=ReadingRate();
    	System.out.println("hash"+hash);
    	String versionString = readingLinesfromFiles(Filename);
        System.out.println(versionString);
    }
	
	
	
	private static HashMap<String, Double> ReadingRate() throws IOException {
		 try {
	            FileReader reader = new FileReader("C:\\Users\\sriraman_d\\Desktop\\rate.txt");
	            BufferedReader bufferedReader = new BufferedReader(reader);
	            String line;
	            while ((line = bufferedReader.readLine()) != null) {
	            	if(line.contains("-")){
		            	System.out.println("Line given"+line);
		            	List<String> LineSpliter = Arrays.asList(line.split("-"));
		            	System.out.println("LineSpliter given"+LineSpliter);
		            	if(LineSpliter.size()>=2){
			            	String Key=LineSpliter.get(0).trim();
			            	double VAlue=Double.parseDouble(LineSpliter.get(1).trim());
			            	hash.put(Key, VAlue);
			            	System.out.println("total"+hash);
		            	}
	            	}
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }catch(ArrayIndexOutOfBoundsException e){
	        	e.printStackTrace();
	        }
		 return hash;	
	}

    private static  String readingLinesfromFiles(String Filename) throws IOException {
		   try {
		            FileReader reader = new FileReader(Filename);
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            double Value=0;
		            String variable=null;
		            double total=0;
		            while ((line = bufferedReader.readLine()) != null){
		            	if(line.contains(",")){
			            	List<String> LineSpliter = Arrays.asList(line.split(","));
			                System.out.println(LineSpliter);
			                for(int i=0;i<LineSpliter.size();i++){
			                	String[] Key=LineSpliter.get(i).split("-");
			                	if(Key.length>=2){
				                	variable =Key[0].trim();
				                	Value=Double.parseDouble(Key[1].trim());
				                	System.out.println("sriiiiii"+variable+"*"+Value);
			                	}
			                }
		            	}
		                System.out.println("total"+total); 
		            }
		            reader.close();
	        	}catch(IOException e) {
	        		e.printStackTrace();
	        	}
	return null;
    }
}