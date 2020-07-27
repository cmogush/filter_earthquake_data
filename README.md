# filter_earthquake_data
Program to implement various Filters on earthquake data

<b>Location</b> - class from the Android platform and revised for this course, a data class representing a geographic location. One of the constructors has parameters latitude and longitude, and one of the public methods is distanceTo.

<b>QuakeEntry</b> - class which has a constructor that requires latitude, longitude, magnitude, title, and depth. It has several get methods and a toString method.

<b>EarthQuakeParser</b> - class which has a read method with one String parameter that represents an XML earthquake data file and returns an ArrayList of QuakeEntry objects.

<b>EarthQuakeClient</b> - class which creates an EarthQuakeParser to read in an earthquake data file, creating an ArrayList of QuakeEntrys. You can test the program with the method createCSV to store an ArrayList of the earthquake data and print a CSV file.

<b>ClosestQuakes</b> - class which finds the ten closest quakes to a particular location. 
