package W5.CustomComparableInterface.src.Sorters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collections;

import W5.CustomComparableInterface.src.Model.Customer;
import W5.CustomComparableInterface.src.Model.Movie;
import W5.CustomComparableInterface.src.Model.Rental;


public class DaysRentedParser {
      //this function sorts the input CSV, creates a stringBuilder we learned about around it, and then sorts it, returning the stringbuilder
      public static StringBuilder SortCSVByDaysRented(String filePath) throws Exception{
        File inputFile = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(inputFile));

        String header = br.readLine();
        String contents;

        while((contents = br.readLine()) != null){
            var splitLine = contents.split(",");
            Movie movie = new Movie(splitLine[1].trim(), splitLine[2].trim().charAt(0));
            Rental rental = new Rental(movie, Integer.parseInt(splitLine[3].trim()));
        }

        //using stringbuilder to define a string we'll use to print our results and create the report
        StringBuilder sb = new StringBuilder();
        sb.append("Days Rented, Movie Title, Movie Price Code\n");
        var rentalList = Rental.getRentalList();
        Collections.sort(rentalList);
        for (var rental : rentalList) {
            sb.append(rental.getDaysRented() + ", " + rental.getMovie().getTitle() + ", " + rental.getMovie().getPriceCode() + "\n");
        }
        br.close();
        return sb;
    }

    //creates the report, and stores it using the stringbuilder from the other function and a filePath
    public static void CreateReport(StringBuilder report, String filePath){

        try {
            File inputFile = new File(filePath);
            if(!inputFile.exists()){
                System.out.println("File not found, preparing to create one.");
                inputFile.createNewFile();
            }
            
            FileWriter fileWriter = new FileWriter(inputFile);
            PrintWriter pw = new PrintWriter(fileWriter, false);
            pw.flush();

            fileWriter.write(
             "***************************************************************************\n" +
             "                                 MOVIE REPORT\n" + 
             "                          (sorted by name of movie)\n" + 
             "***************************************************************************\n");
            
            fileWriter.write(report.toString());
            fileWriter.close();
            System.out.println("The report was successfully created: " + inputFile.getAbsolutePath());

            pw.close();
            fileWriter.close();

        } catch (Exception e) {
            System.out.println("An error has occured and the program will not continue.");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }


    }
}
