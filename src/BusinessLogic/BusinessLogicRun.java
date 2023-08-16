package BusinessLogic;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import CustomException.CheckedExceptionForBusiness;

public class BusinessLogicRun {

	public void retrieveFiles() {
		
		 String[] pathnames;

		 	String path = System.getProperty("user.dir");
	        File f = new File(path+ "\\Root\\");
	        System.out.println("\n Accessing the files \n");
	        if(f.isDirectory()) {
	        	if(f.list().length>0) {
		        pathnames = f.list();
		        Arrays.sort(pathnames);
		        for (String pathname : pathnames) {
		            System.out.println(pathname);
		         }
		        }
			  else { 
				  System.out.println("\n No Files found in the directory "); 
			  }
			 
	        }
	        else {
	        	
	        	f.mkdir();
	        	
	        }
	}
	
	public  void addFile(String name) throws IOException {
		
		String file = name;
		file= file + ".txt";
		String path = System.getProperty("user.dir");
		File f = new File(path+ "\\Root\\" + file);
		
			
			if (!f.exists()) {
			
			f.createNewFile();
			System.out.println(" Created file " + file);
			}
			else {
				System.out.println(" File exists, please give diferent name.");
			}
	
	}
	
	public void deleteFile(String name) throws CheckedExceptionForBusiness {
		
		String file = name;
		file= file + ".txt";
		String path = System.getProperty("user.dir");
		File f = new File(path+ "\\Root\\"+file);
		if(!f.exists()) {
			throw new CheckedExceptionForBusiness(" File not found.");
		}
		else {
		if(file.equals(f.getName())) {
			f.delete();
			System.out.println(" Successfully deleted file = " + file);
		}else {
			System.out.println(" File not match with the provided name.");
		}
		}
	}
	
	public void searchFile(String name) {
		
		String file = name;
		int i;
		file= file + ".txt";
		String path = System.getProperty("user.dir");
		File f = new File(path+ "\\Root\\");
		
		String[] list = f.list();
		
		if(list==null) {
	         System.out.println(" Directory not exists or is empty."); 
	      } else { 
	          for ( i=0;i<list.length;i++)
	          {
	              if (file.equals(list[i]))
	              {
	                  System.out.println(" The file with the name "+ name + " is available.");
	                  break;
	              }
	             
	          }
	          if(i==list.length) {
	        	  
	        	  System.out.println(" File not available.");
	          }
	          
	}
	
	}
}
