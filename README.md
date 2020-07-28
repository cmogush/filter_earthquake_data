# filter_earthquake_data
Program to implement various Filters on earthquake data

<b>Location</b> - class from the Android platform and revised for this program, a data class representing a geographic location. One of the constructors has parameters latitude and longitude, and one of the public methods is distanceTo.

<b>QuakeEntry</b> - class which has a constructor that requires latitude, longitude, magnitude, title, and depth. It has several get methods and a toString method.

<b>EarthQuakeParser</b> - class which has a read method with one String parameter that represents an XML earthquake data file and returns an ArrayList of QuakeEntry objects. Contains the following methods:
* <b>read</b>
* <b>main</b>

<b>EarthQuakeClient</b> - class which creates an EarthQuakeParser to read in an earthquake data file, creating an ArrayList of QuakeEntrys. You can test the program with the method createCSV to store an ArrayList of the earthquake data and print a CSV file. Contains the following methods:
* <b>filterByMagnitude</b> - has two parameters, an ArrayList of type QuakeEntry named quakeData, and a double named magMin. Returns an ArrayList of type QuakeEntry of all the earthquakes from quakeData that have a magnitude larger than magMin.
* <b>filterByDistanceFrom</b>
* <b>filterByDepth</b>
* <b>filterByPhrase</b>
* <b>dumpCSV</b>
* <b>quakesOfDepth</b>
* <b>quakesByPhrase</b>
* <b>bigQuakes</b>
* <b>closeToMe</b>
* <b>createCSV</b>

<b>ClosestQuakes</b> - class which finds the ten closest quakes to a particular location. Contains the following methods:
* <b>getClosest</b>
* <b>findClosestQuakes</b>

<b>LargestQuakes</b> - class to determine the N biggest earthquakes, those with largest magnitude. Contains the following methods:
* <b>findLargestQuakes</b>
* <b>indexOfLargest</b>
* <b>getLargest</b>

Links to exercises:
* https://www.coursera.org/learn/java-programming-design-principles/supplement/3RkuE/programming-exercise-searching-earthquake-data
* https://www.coursera.org/learn/java-programming-design-principles/supplement/yzFlm/programming-exercise-filtering-data
