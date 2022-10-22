# Actor-sMovieWall
Program where user searches up an Actor's name and program returns a list of movies that actor appeared in from a top 5000 movie list.
The program first reads in a data set of 5000 movies that include a movie ID file, title of movie, names of characters, and names of cast.
This reading in is done through buffered reader. The data file is a combination of CSV and JSON formats.
The program then adds all of the data into different arraylists. From there, the program lexicographically sorts the actor's names through quicksort.
The program asks the user to input an actor's name. Binary Search is used to find the actor's name in a quick fashion.
The program returns the actor and all of the movies/roles the actor has played in. 
The program will keep asking user for actor names until the user chooses to "EXIT" the program. 
