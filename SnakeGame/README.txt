=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: adengold
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. 2D Array
  		I used a 2D array in the Grid class to model the board. The array was of 
  		type GridSquare. The grid squares in the 2D array were the objects that 
  		were actually drawing the board. They kept track of a color field and 
  		would draw themselves at every tick of the game. There would really be no
  		way to model a board like this without a 2D array.
  		
  2. Collections
		I used a Set (dynamic type HashSet) in the Snake class to keep track of 
		the spots on the board currently occupied by the snake. The set was of 
		type Coordinate, which is just an object that I created to keep track 
		of an x field and a y field (x and y corresponded to a spot in the 2D
		array). This allowed me do 2 important checks. The first is when the 
		front of the snake was about to go to a new square, I would check to see
		if the coordinates of that square were in the set of coordinates that the
		snake currently occupied. If so, then the snake has hit itself and the 
		game terminates. The second check was for when I had to place a new apple.
		I would just generate the coordinates for the new apple at random, but
		then I had to check to make sure those coordinates weren't in the set of 
		coordinates that the snake already occupied (or else the apple would be 
		on the snake). This set basically allowed me to keep track of already 
		occupied spaces.
		
  3. Linked Data Structure
  		I created my own version of a singly linked list, where each SnakeLink
  		was basically a node. Also I kept track of a head and a tail pointer, 
  		not just head. The structure was also used backwards. So the first
  		SnakeLink in the structure was actually the back of the snake. This 
  		allowed me to update positions for the snake from the back forward, 
  		where each link just takes the position of the link that its next 
  		pointer points to. Then when we get to the front of the snake (the 
  		tail of the data structure) we use the current direction of the snake
  		to determine where this link goes. I could not have done this with the 
  		Library linked list since the built in Linked List doesn't expose the
  		next pointer for each node.

  4. JUnit Testing
  		I wasn't able to to do JUnit testing for all of my back-end code, but
  		I was able to test the Snake class, specifically the move() method which
  		is where much of the complex back-end logic was. I tested for the the 4
  		main events that could occur when the snake moves: hitting a wall, 
  		changing direction, eating an apple, and hitting yourself. These test 
  		allowed me to confirm that my logic and implementation for the Snake 
  		class was sound.


=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.

Game - Sets up and begins the game
GameCourt - handles all the interactions between the 
	different components of the game
Grid - An object to represent the board. Basically just a 2D array of 
	Grid Square's
Grid Square - A single box of the grid. Keeps track of it there is an
	 apple at this spot, and what color it should draw itself
Snake - represents the snake itself. Is implemented as a linked data
	structure of SnakeLink's. Is responsible for moving the snake and 
	keeping track of the snake's direction, updating internal position,
	keeping track of the score, and checking to see it the game should
	end.
SnakeLink - just keeps track of the position of each link and a next 
	pointer that points to the next link in the linked data structure.
Direction - an enum that contains the 4 directions, and has an 
	opposite method that checks if 2 directions are opposite each 
	other.
Coordinate - a class just for keeping an x and y field to store 
	locations and easily check equality between 2 locations.
SnakeTest - tests the functionality of the snake (I put this in the src,
	it was the only way it would work. So I don't have a test folder).

- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?

It was hard to figure out how all of the pieces fit together. Implementing 
the actual logic for the game wasn't that hard, but it was hard to know 
what classes were needed and then to put them together. 

- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?

I think the private state is fairly well encapsulated. I definitely did a good
job of breaking my code down into small pieces. Some of the classes are probably
not necessary, but it is nice to break things up. I wouldn't change much because 
the code works and it broken up enough so that it is not that hard to understand.

========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.
  
Not sure if this is what is being referred to but I used a Set (initialized 
as a HashSet)
