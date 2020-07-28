//2017 Christopher Mogush
//LargestQuakes class

import java.util.*;
import edu.duke.*;
import java.util.Scanner;

public class LargestQuakes {
    public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter # of highest quakes to return (howMany): ");
        int howMany = scan.nextInt();
        ArrayList<QuakeEntry> largestMag = getLargest(list, howMany);
        int count = 0;
        for(QuakeEntry qe : largestMag){
            System.out.println(qe);
            count+=1;
        }
        System.out.println("Found " + count + " quakes which match the criteria");
        indexOfLargest(list);
    }
    
    public int indexOfLargest(ArrayList<QuakeEntry> quakeData){
        //returns an integer representing the index location in data of 
        //the earthquake with the largest magnitude
        int answer = 0; //index location of 
        double largest = 0;
        int index = 0;
        for(QuakeEntry qe : quakeData){
            if(qe.getMagnitude() > largest){
                answer = index;
                largest = qe.getMagnitude();
            }
            index+=1;
        }
        System.out.println("The quake with the largest magnitude occurs at index " + answer + " with Magnitude of: " + largest);
        return answer;
    }
    
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        //returns an ArrayList of type QuakeEntry of the top howMany 
        //largest magnitude earthquakes from quakeData
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        
        int maxIndex = 0;
        if(howMany > quakeData.size()){
            howMany = quakeData.size();
        }
        for(int j=0; j < howMany; j++){
            for(int k=0; k < copy.size(); k++){
                QuakeEntry quake = copy.get(k);
                if(quake.getMagnitude() > copy.get(maxIndex).getMagnitude()){
                    maxIndex = k;
                }
            }
            answer.add(copy.get(maxIndex));
            copy.remove(maxIndex);
        }
        
        return answer;
    }
}
