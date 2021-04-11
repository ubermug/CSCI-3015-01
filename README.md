CSCI-3015-01

TimeTester.java
Invokes the methods to begin the list generation process, telling those methods how many tolls to add to those data structures, and times their generation.

Toll.java
Object built to set and get data for each individual toll.

TollAccumulator 
Generates random price, license plate, and starting time stamp.  Calls those methods in a loop and adds them to a list, array or hashmap. 

TollSearch.java
  -> Performs a search for a random element for all three data structures 
  -> Records the time needed to perform the search operation 
  -> Ranks the three data structure based on the time taken  
Observation: When the datastructures are kept to a size between 10-1000, LinkedList takes less time on average than Array and Hashmap. However, as the data structure size is increased above 10,000 Hashmap wins convincingly every time. Note that, Array finishes last regardless of the size of the data.  

TollDelete.java 
->Ranks the three datastructures based on the time taken to delete a randomly chosen element 

A snapshot of the output console: 

THE DATA GENERATION TIMES ARE SORTED BELOW IN LOW TO HIGH (TIME IN NANOSEC.)
1.LinkedList, Time(ns): 701413282
2.Hashmap, Time(ns): 740858526
3.Array, Time(ns): 1443508972  

THE SEARCH TIME FOR A RANDOM ELEMENT ARE SORTED BELOW IN LOW TO HIGH (TIME IN NANOSEC.)
1.Hashmap, Time(ns): 847567
2.LinkedList, Time(ns): 39906490
3.Array, Time(ns): 112571706 

THE DELETION TIME FOR A RANDOM ELEMENT ARE SORTED BELOW IN LOW TO HIGH (TIME IN NANOSEC.)
1.Hashmap, Time(ns): 24160
2.Array, Time(ns): 10811944
3.LinkedList, Time(ns): 17439485


