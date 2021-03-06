package W4.ParsingMovieRentals.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import Model.Movie;


public class FileParser {
      //this function sorts the input CSV, creates a stringBuilder we learned about around it, and then sorts it, returning the stringbuilder
      public static StringBuilder ParseCSVAndPopulateData(String filePath) throws Exception{
        File inputFile = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(inputFile));

        String header = br.readLine();
        String contents;

        while((contents = br.readLine()) != null){
            var splitLine = contents.split(",");
            Movie movie = new Movie(splitLine[2].trim(), Integer.parseInt(splitLine[0].trim()));
        }

        //using stringbuilder to define a string we'll use to print our results and create the report
        StringBuilder sb = new StringBuilder();
        for (var customer : Customer.getCustomerList()) {
            sb.append(customer.rentalRecords());
            sb.append("-------------------------------------------------------------\n");
        }
        br.close();
        return sb;
    }
}
