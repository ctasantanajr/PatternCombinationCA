# PatternCombinationCA

#Singleton Pattern
The first choice was to use Singleton Pattern. The first reason is because is said
to be one of the simplest designer patterns. The second was to apply it in my 
DataSource in order to have only one instance of this class that connects with a Database.
According to some researches done, a single DB connection shared 
by multiple objects might be costly when creating a separate DB connection for every object. 

#Builder Pattern
After that I decided to use Builder pattern. It is a creational design pattern, it means its 
solves problem related to object creation. Thus, as I have a class Country that needes to 
receive a few parameters, that would be a good application of Builder Pattern. Once created, 
and invoked, there is no more need to worry about of all parameters to be passed because this 
pattern easily brings all parameters created in the constructor.
