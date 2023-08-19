package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

//Data Driven Testing
public class ManageDDT extends CommonOps{

    //Retrieves data from a CSV file and returns it as a 2D array
    @DataProvider(name="data-provider-searchKeyword")
    public static Object[][] getDataObject(){
        return getDataFromCSV(getData("DDTFile"));
    }


    public static List readCSV(String csvFile){
        List lines = null;
        File file = new File(csvFile);  // Creates a File object with the specified CSV file path
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);  // Reads all lines from the CSV file
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return lines;  // Returns the list of lines read from the CSV file
    }



    public static Object[][] getDataFromCSV(String filePath){
        Object[][] data = new Object[3][2]; // Creates a 2D array to store the CSV data
        List<String> csvData = readCSV(filePath); // Reads the CSV data from the specified file path
        for(int i=0;i<csvData.size();i++){
            data[i][0]= csvData.get(i).split(",")[0];
            data[i][1]= csvData.get(i).split(",")[1];
        }
        return data;
    }
}
