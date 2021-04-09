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
