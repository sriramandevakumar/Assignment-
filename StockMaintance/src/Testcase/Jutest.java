package Testcase;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Test;

import StockMaintance.MainReadFile; 
  
public class Jutest {  
  HashMap<Double,String> hash11=new HashMap<Double,String>();
 
  
    @Test  
    public void testFindMax() throws Exception{  
    	 hash11.put(12500.0,"GOOG - 100,AMZN - 90,MS - 80");
    	 hash11.put(2500.0, "AMZN - 90,MS - 80");
    	 hash11.put(900.0,"AMZN - 90" );
        assertEquals(hash11,MainReadFile.ReadFile("test"));
    }  
}  