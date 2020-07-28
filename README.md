# search_filter_sort_earthquake_data
Program to implement search, filter and sort data from earthquakes.

##Searching Earthquake Data

<b>Location</b> - class from the Android platform and revised for this program, a data class representing a geographic location. One of the constructors has parameters latitude and longitude, and one of the public methods is distanceTo.

<b>QuakeEntry</b> - class which has a constructor that requires latitude, longitude, magnitude, title, and depth. It has several get methods and a toString method.

<b>EarthQuakeParser</b> - class which has a read method with one String parameter that represents an XML earthquake data file and returns an ArrayList of QuakeEntry objects. Contains the following methods:
* <b>read</b>
* <b>main</b>

<b>EarthQuakeClient</b> - class which creates an EarthQuakeParser to read in an earthquake data file, creating an ArrayList of QuakeEntrys. You can test the program with the method createCSV to store an ArrayList of the earthquake data and print a CSV file. Contains the following methods:
* <b>filterByMagnitude</b> - has two parameters, an ArrayList of type QuakeEntry named quakeData, and a double named magMin. Returns an ArrayList of type QuakeEntry of all the earthquakes from quakeData that have a magnitude larger than magMin.
* <b>filterByDistanceFrom</b> - has three parameters, an ArrayList of type QuakeEntry named quakeData, a double named distMax, and a Location named from. This method returns an ArrayList of type QuakeEntry of all the earthquakes from quakeData that are less than distMax from the location from.
* <b>filterByDepth</b> - has three parameters, an ArrayList of type QuakeEntry named quakeData, a double named minDepth and a double named maxDepth. This method returns an ArrayList of type QuakeEntry of all the earthquakes from quakeData whose depth is between minDepth and maxDepth, exclusive. (Does not include quakes with depth exactly minDepth or maxDepth.)
* <b>filterByPhrase</b> - has three parameters, an ArrayList of type QuakeEntry named quakeData, a String named where that indicates where to search in the title and has one of three values: (“start”, ”end”, or “any”), and a String named phrase, indicating the phrase to search for in the title of the earthquake. The title of the earthquake can be obtained through the getInfo() method. The <b>filterByPhrase</b> method returns an ArrayList of type QuakeEntry of all the earthquakes from quakeData whose titles have the given phrase found at location where (“start” means the phrase must start the title, “end” means the phrase must end the title and “any” means the phrase is a substring anywhere in the title.)
* <b>dumpCSV</b>
* <b>quakesOfDepth</b> - has no parameters, uses filterByDepth and prints all the earthquakes from a data source whose depth is between a given minimum and maximum value, and prints out the number of earthquakes found.
* <b>quakesByPhrase</b> - uses <b>filterByPhrase</b> and prints all the earthquakes from a data source that have phrase in their title in a given position in the title. Also prints out the number of earthquakes found
* <b>bigQuakes</b> -  reads data on earthquakes from a file, stores a QuakeEntry for each earthquake read in the ArrayList named list, and prints out the number of earthquakes read in. Use <b>filterByMagnitude</b> to print earthquakes above a certain magnitude, and also print the number of such earthquakes.
* <b>closeToMe</b> - calls <b>filterByDistance</b> to print out the earthquakes within 1000 Kilometers to a specified city (such as Durham, NC). For each earthquake found, prints the distance from the earthquake to the specified city, followed by the information about the city (using getInfo()). This method reads data on earthquakes from a URL or file, stores a QuakeEntry for each earthquake read in the ArrayList named list, and prints out the number of earthquakes read in. 
* <b>createCSV</b>

<b>ClosestQuakes</b> - class which finds the ten closest quakes to a particular location. Contains the following methods:
* <b>getClosest</b> - has three parameters, an ArrayList of type QuakeEntry named quakeData, a Location named current, and an int named howMany. This method finds the closest number of howMany earthquakes to the current Location and return them in an ArrayList of type QuakeEntry. The earthquakes are in the ArrayList in order with the closest earthquake in index position 0. If there are fewer then howMany earthquakes in quakeData, then the ArrayList returned would be the same size as quakeData.
* <b>findClosestQuakes</b> - reads in data on earthquakes storing them in the ArrayList list and prints how many quakes there are. For example, it sets a location variable named jakarta to the location of the city Jakarta. It then calls the method getClosest to determine the ten closest earthquakes in list and prints information about those quakes and how close they are to Jakarta.

<b>LargestQuakes</b> - class to determine the N biggest earthquakes, those with largest magnitude. Contains the following methods:
* <b>findLargestQuakes</b> - reads in earthquake data from a source and storing them into an ArrayList of type QuakeEntry. Then it prints all the earthquakes and how many earthquakes that were from the source. 
* <b>indexOfLargest</b> -  has one parameter, an ArrayList of type QuakeEntry named data. This method returns an integer representing the index location in data of the earthquake with the largest magnitude.
* <b>getLargest</b> - has two parameters, an ArrayList of type QuakeEntry named quakeData and an integer named howMany. This method returns an ArrayList of type QuakeEntry of the top howMany largest magnitude earthquakes from quakeData. The quakes returned are in the ArrayList in order by their magnitude, with the largest magnitude earthquake in index position 0. If quakeData has fewer than howMany earthquakes, then the number of earthquakes returned in the ArrayList is equal to the number of earthquakes in quakeData. This method calls the method <b>indexOfLargest</b>.

##Filtering Earthquake Data

Links to exercises:
* https://www.coursera.org/learn/java-programming-design-principles/supplement/3RkuE/programming-exercise-searching-earthquake-data
* https://www.coursera.org/learn/java-programming-design-principles/supplement/yzFlm/programming-exercise-filtering-data
