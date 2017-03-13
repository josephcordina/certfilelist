package filelist;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class CertFileList {
	/**
     * List all the files under a directory
     * @param directoryName to be listed
	 * @throws IOException 
     */
    public static void listFiles(String directoryName) throws IOException{
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        System.out.printf("Name, CreationTime, LastModified, Size\n");
        for (File file : fList){
            if (file.isFile()){
            	String path = file.getAbsolutePath();
            	BasicFileAttributes attr = Files.readAttributes(Paths.get(path), BasicFileAttributes.class);
                System.out.printf("%s, %s, %s, %s\n",file.getName(),attr.creationTime(),attr.lastModifiedTime(),attr.size() );
            }
        }
    }
	
	 public static void main (String[] args) throws IOException{
	        
	        final String directoryLinuxMac ="/etc/ssl/certs";
	        //Windows directory example
	        listFiles(directoryLinuxMac);
	    }
}
