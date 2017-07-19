package Testcase;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import StockMaintance.MainReadFile; 
  
public class Jutest {  
  HashMap<Double,String> hash1=new HashMap<Double,String>();
  HashMap<Double,String> hash2=new HashMap<Double,String>();

 
  
    @Test  
    public void testFindMax() throws Exception{  
    	 hash1.put(12740.0,"GOOG - 100,AMZN - 90,MS - 80");
    	 hash1.put(2740.0, "AMZN - 90,MS - 80");
    	 hash1.put(900.0,"AMZN - 90" );
    	 assertEquals(hash1,MainReadFile.ReadFile("test1.txt"));
         hash2.put(1000000.0,"SGI-10000");
         hash2.put(12740.0,"GOOG - 100,AMZN - 90,MS - 80");
         hash2.put(5100.0,"GOOG - 20,SGI-20,GOOG -11");
         assertEquals(hash2,MainReadFile.ReadFile("test.txt"));
         assertEquals(null,MainReadFile.ReadFile("test"));//This will thrown as exception for extension
         assertEquals(null,MainReadFile.ReadFile("test.txxxt"));//This will thrown as exception for correct extension
         assertEquals(null,MainReadFile.ReadFile("txxxt.txt"));//This will thrown as exception for file not in location
         
         
    }  
}  
