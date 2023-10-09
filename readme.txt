Student: Igor Risteski
Matriculation number: 7219281
Solution short description:

-I created an abstract Engine class which derives 3 classes (CombustionEngine, Electric Engine, Hybrid Engine).
Each of them has it's own characteristics and a method showCharacteristics which prints all of the characteristics.
After that, I created a Manifacture class, which contains name and location.
Afterwards, I created a Vehicle super class that has an abstract method showCharacteristics.
The class has the shared properties of the 3 types of vehicles, from which
it derives 3 other classes (ICEV, BEV, HybridV). Each of these classes contain an object of the class
Manifacture and an object of the according type of engine.
All of these 3 subclasses implement the abstract method showCharacteristics from it's parent Vehicle. The 
implementation calls showCharacteristics of Engine and Manifacture.
After that, I created an array which contains 10 vehicles and for each of them I called the showCharacteristics
method to print out all of the information.

Development environment: Eclipse IDE