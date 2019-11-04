##### Problem specification

The program is a prototype of a traffic simulator which aims to demonstrate traffic flow. The program consist of a 
set of roads, traffic lights and cars.  
The cars will drive according to traffic lights and respawn at road 0 when the end of the map is reached. 
There are collision handling for vehicles. 

Per this release the traffic is one way, and changes to the map has to be manually done by adding lines of code.
The current version is only good for simulating traffic flow in one direction. 


###### Program Description

TrafficSimulation.Java is used to draw the initial frame. It is also responsible for handling the thread that acts
as a timer and the eventhandler method that calls traffic light change and car spawn at different intervals. 
Roads.java is the most significant, as it handles pretty much everything. Most objects are called from Roads.java.class
The class handles methods responsible for vehicle movement, new vehicles, collision handling, traversal across roads & 
change in traffic lights.
Rest of the classes are helpers, that either sets new values and/or acts as object templates. 

The main principle is that each road holds an ID, which can be used to find coordinates and the traffic light that belongs
to that specific road. When the car is about to enter a new road, it will choose randomly between ID's linked to that 
road. To scale it further, with both directions, i originally planned to add a variable to vehicles that set the 
direction either west, east, north or south. That variable can be used to fine adjust which side of the road the car 
will appear on, and if x and y coordinates should decrease or increase depending on the way the vehicle is travelling. 
Some adjustment to the RoadConnections would also be necessary. 

##### Note

I probably should have investigated further, but since unit testing is not possible with private methods, i simply 
created a test.java class that i used to run bits of code before i implemented them. Test.java was deleted in the process 
of cleaning up the code, but should be in some of the older versions. 