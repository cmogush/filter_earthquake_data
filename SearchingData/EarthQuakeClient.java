import java.util.*;
import edu.duke.*;
import java.util.Scanner;

public class EarthQuakeClient {
    //creates an EarthQuakeParser to read in an earthquake data file
    //creating an ArrayList of QuakeEntrys
    //You will complete the methods that filter magnitude and distance in this class 
    //and add additional methods to it.
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData){
            if(qe.getMagnitude() > magMin){
                answer.add(qe);
            }
        }
        /* should return an ArrayList (answer) of type QuakeEntry of all the  
        earthquakes from quakeData that have a magnitude larger than magMin.*/
        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
    double distMax,
    Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        /* For each earthquake found, print the distance from the earthquake to the 
         * specified city, followed by the information about the city (use getInfo()). */
        for(QuakeEntry qe : quakeData){
            double distance = qe.getLocation().distanceTo(from);
            if(distance < distMax){
                answer.add(qe);
                System.out.println(Math.floor(distance)/1000 + " km " + qe);
            }
        }
        
        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData,
    double minDepth, double maxDepth) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        /* should return an ArrayList of type QuakeEntry of all the earthquakes from quakeData 
         * whose depth is between minDepth and maxDepth, exclusive */
        for(QuakeEntry qe : quakeData){
            if(qe.getDepth() > minDepth && qe.getDepth() < maxDepth){
                answer.add(qe);
            }
        }
        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String where, String phrase){
        /* start = phrase must start the title
           any = anywhere in the title
           end = phrase must end the title */
        int length = phrase.length();
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData){
            String info = qe.getInfo();
            if(where.equals("start")){
                String sub = info.substring(0,length);
                if(sub.equals(phrase)){
                    answer.add(qe);
                }
            }
            if(where.equals("end")){
                String sub = info.substring(info.length() - length, info.length());
                if(sub.equals(phrase)){
                    answer.add(qe);
                }
            }
            if(where.equals("any")){
                if(info.contains(phrase)){
                    answer.add(qe);
                }
            }
        }
        return answer;
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }
    
    public void quakesOfDepth(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        System.out.println("Enter min depth:");
        Scanner scan = new Scanner(System.in);
        double depthMin = scan.nextDouble();
        System.out.println("Enter max depth:");
        double depthMax = scan.nextDouble();
        ArrayList<QuakeEntry> filteredDepth = filterByDepth(list, depthMin, depthMax);
        int count = 0;
        for(QuakeEntry qe : filteredDepth){
            System.out.println(qe);
            count+=1;
        }
        System.out.println("Found " + count + " quakes matched the depth criteria.");
    }
    
    public void quakesByPhrase(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter phrase to check: ");
        String phrase = scan.nextLine();
        System.out.println("Enter phrase location (start/any/end):");
        String where = scan.nextLine();
        ArrayList<QuakeEntry> filteredPhrase = filterByPhrase(list, where, phrase);
        int count = 0;
        for(QuakeEntry qe : filteredPhrase){
            System.out.println(qe);
            count+=1;
        }
        System.out.println("Found " + count + " quakes matched the phrase criteria.");
    }

    public void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        /*
         * for(QuakeEntry qe : list){
            if(qe.getMagnitude() > 5.0){
                System.out.println(qe);
            }
        }
        */
        ArrayList<QuakeEntry> listBig = filterByMagnitude(list, 5.0);
        int count = 0;
        for(QuakeEntry qe : listBig){
            System.out.println(qe);
            count+=1;
        }
        System.out.println("Found " + count + " quakes that match that criteria");
    }

    public void closeToMe(){
        /* call filterByDistance to print out the earthquakes 
        within 1000 Kilometers to a specified city (such as Durham, NC). */
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        // This location is Durham, NC
        // Location city = new Location(35.988, -78.907);

        // This location is Bridgeport, CA
        Location city =  new Location(38.17, -118.82);
        double km = 1000 * 1000;
        filterByDistanceFrom(list, km, city);
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    
}
