# Parking Lot Simluator

## What it does
Implementing linked queues, this program simulates a full 24 hour day in a parking lot and finds the optimal parking lot capacity for a certain rate of incoming number of cars per hour. 

## How it works
1. The rate of incoming cars is defined and the program starts (e.g. running "java Capacity 3" in your terminal will run the simulation with a rate of 3 incoming cars per simulated hour).
2. An instance of the ParkingLot class with capacity of 1 and an incoming and outgoing linked queue are instantiated.
3. The simulation of a 24 hour day is run 10 times using tringular ditributino to decide if a car leaves a a given second.
4. The output shows how many cars are still in the incoming queue at the end of each day.
5. If the average number of cars in the incoming queue across 10 simulations is inferior or equal to 5 then the optimized number of parking spots has been found.
6. Otherwise, the simulation runs again but with a parking lot with an increased capacity.

## How it looks
![](screenshot/rate5.txt)
