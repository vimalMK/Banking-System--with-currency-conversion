package miniproject.swing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class databaseView {
	
	  static String fileName = "C:/Myworkspace/swingapp/src/miniproject/swing/temp.txt";
	  static  String fileNametemp = "C:/Myworkspace/swingapp/src/miniproject/swing/temp1.txt";
	  
	  static ArrayList al = new ArrayList(20); 
      static  String line = null;
     
	public static ArrayList disp()
	{
		
		return al;
	}
	
	public static void saveList(String s,String account) throws IOException
	{
		
		
		File inputFile = new File(fileName);
		File tempFile = new File(fileNametemp);
		FileReader fileReader =  new FileReader(inputFile);
		
		FileWriter os = new FileWriter(inputFile,true);
		FileWriter temp = new FileWriter(tempFile,true);;
            BufferedReader bufferedReader =   new BufferedReader(fileReader);
           
           
            
            while((line = bufferedReader.readLine()) != null) {
            
            	String arrayCheck[]=line.split("(:)|(\\,)");
            	String arraycheck1[]=arrayCheck[1].split("=");
               	if(account.equals(arraycheck1[1]))
            	{
            		
               	
               		temp.write(s+"\n");
            	}
               	else
               	{
               		temp.write(line+"\n");
               	}
            	
            	            	
            }  
            bufferedReader.close(); 
            temp.close();
            os.close();
            overwrite();
            
            

		
	}
	public static void overwrite()throws IOException
	{
		File inputFile = new File(fileName);
		File tempFile = new File(fileNametemp);
		FileReader fileReader1 =  new FileReader(tempFile);
		FileWriter os = new FileWriter(inputFile);
		FileWriter temp = new FileWriter(tempFile,true);
		 BufferedReader bufferedReader1 =  new BufferedReader(fileReader1);
		 while((line = bufferedReader1.readLine()) != null) {
	            
             
         	os.write(line+"\n");
         	            	
         } 
		 bufferedReader1.close(); 
         temp.close();
         os.close();
         tempFile.delete();
	}
	
	public databaseView() {

             
      

        try {
            
            FileReader fileReader = 
                new FileReader(fileName);
 
            
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            

            while((line = bufferedReader.readLine()) != null ) {
            
            	al.add(line);
            	            	
            }  
               
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
           
        }
    }
}
