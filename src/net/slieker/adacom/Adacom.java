package net.slieker.adacom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Adacom
{
    
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException
    {
            // In the example I provided 2 data files in /data directory filled with animal types
        
            // Check for 3 mandatory arguments to be provided, otherwise exit
            if(args.length != 3) {
                System.out.println("Please provide 3 arguments");
                System.exit(0);
            }

            // Initialize parameters;
            File file1 = null;
            File file2 = null;
            String filename1 = args[0]; // first file to read
            String filename2 = args[1]; // second file to read
            String filename3 = args[2]; // file to write

            // Ideally files should not only be checked for existence but also for Read/Write privileges
            
            // Check for existence of file1
            try {
                file1 = new File(filename1);
                if(!file1.exists()) {
                    System.out.println("File " + filename1 + " does not exist");
                    System.exit(0);
                }
            } catch(Exception ex) {
                System.err.println("Exception: " + ex.getMessage());
                System.exit(0);
            }

            // Check for existence of file2
            try {
                file2 = new File(filename2);
                if(!file2.exists()) {
                    System.out.println("File " + filename2 + " does not exist");
                    System.exit(0);
                }
            } catch(Exception ex) {
                System.err.println("Exception: " + ex.getMessage());
                System.exit(0);
            }

            // Read both files into Array
            List<String> file1List = readFile(filename1);
            List<String> file2List = readFile(filename2);
            List<String> file3List = new ArrayList<String>();
            
            System.out.println("File 1 contains " + file1List.size() + " unique words");
            System.out.println("File 2 contains " + file2List.size() + " unique words");
            
            for(int i=0; i<file1List.size(); i++) {
                String word = (String) file1List.get(i);
                if(file2List.contains(word)) {
                    System.out.println("Match found for word: " + word);
                    file3List.add(word);
                }
            }
            
            // Sort file alphabetically
            Collections.sort(file3List);
            
            // Write to file
            writeFile(file3List, filename3);
            
            // Done!
    }
    
    private static List<String> readFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            // Only read non-empty lines and ignore spaces
            if(!lines.contains(line) && !line.trim().isEmpty()) {
                lines.add(line);
            }
        }
        bufferedReader.close();
        return lines;
    }
    
    public static void writeFile (List<String> file3List, String filename) throws IOException{
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        
        // Loop through List and write lines to file
        for(int i=0; i<file3List.size(); i++) {
            String word = file3List.get(i);
            outputWriter.write(word); 
            outputWriter.newLine();
        }
        outputWriter.flush();  
        outputWriter.close();  
    }

}
