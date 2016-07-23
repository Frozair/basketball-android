## Basketball App

App to keep track of pick up basketball games. 

#### Features:
* Game modes: 
	* **2-N-Out:** Every team plays 2 games even if win or loses. On the first game this mode is enabled, then winner stays and plays 1 more game.
	* **Winner stays:** Winner place until loses.
	* **1-N-Done:** Picks a new set of teams after every game.
* Score board indicating time and score
* Add/Remove player from list
* Drag and drop player order in list
* Auto group players to form teams
* Tablet compatible

#### Entities
* Player
	* Name
	* Phone number (optional) 
	* Wins count
	* Loss count
* Game
	* Score
	* Time

## TODO
* Test realm repository implementation
* Build basic UI to add/delete players and show list of players
* Build basic UI for scoreboard