# AventurasdeMarcosyLuis

"Aventuras de Marcos y Luis" is an RPG where two italo-latin-american cousins try to
save their beloved countess from the clutches of vile enemies. This proyect is been build
in the context of the course "CC3002 - Metodologías de Diseño y Programación" at the
"Universidad de Chile".

## Version 0.2

### Characters
Marcos, Luis, Goomba, Spiny and Boo have been implemented.

### Items
Honey Syrup, Red Mushroom and Star have been implemented.

All items are usable only by Marcos or Luis.

### Combat

All attack methods are working fine, but there is no combat instance yet. Restrictions 
have been applied, such as Luis unable to damage Boo. Players can only attack enemies
and vice versa.

## Version 0.6

### Assumptions
The order of turns is: Marcos, Luis and then the enemies.

### Items
Star has been removed.

A new feature, Chest, has been added replacing the inventory. The Chest is shared by 
Marcos and Luis.

### Controller
Following the MCV software architecture pattern, we added a controller to prepare the
way to the visual interface. Named "GameController", it handles all the functionalities
of the Model, decoupling the View.

### Turn Testing
We have implemented a "Mock-Turn" to test all functionalities. Please refer to it 
at test->TurnTest.

### Attack Testing
When calling the playerAttackTest on ControllerTest battery tests, when a Boo character
is created if Luis is attacking, an error will rise. This is by design. The idea is to
catch that error on the last version and prompt a message to the player telling him
that Luis is too afraid to attack Boo.

## Version 1.0
This is the final version of the game, we didn't implement visual elements. Tu run the game
simply run the main class. All interactions are made through the console using numbers.

### Fixes
We included the comment of the last review and also, corrected a few bugs.

### Phases
To handle the flow of the game, we are using a State Pattern to keep track of the moment
of the game that we are in. For this purpose, we defined several phases which are described
below.

#### Load Phase
Here, we load Players and Items.

#### BattleStart Phase
BattleStart creates enemies for each new battle.

#### WaitChoice Phase
This is the first phase where the user interacts, she can choose between: Attack, Use Item
or Pass. The first choice leads to WaitAttack, the second to WaitItem and the third to
EndTurn.

#### WaitAttack Phase
On WaitAttack, the user chooses between attack types.

#### Attack Phase
Finally, with the type of attack ready, the user chooses an enemy.

#### WaitItem Phase
Here, the user chooses a player on which apply an item.

#### Item Phase
On the Item Phase, the user chooses an item to use.

#### EnemyAttack Phase
There is no interaction on this phase. Here, an enemy attacks randomly between the players
that are still alive.

#### EndTurn Phase
EndTurn removes the dead characters from the battle and checks if the conditions for
winning or losing a battle are met. If they are, it leads to EndBattle, if they don't
then it leads to WaitChoice for another turn.

#### EndBattle Phase
After finishing a battle, EndBattle checks if the players won, lost or are still playing.
In the first and second case it leads to EndGame. On the last scenario, it goes to
BattleStart to commence another battle.

#### EndGame Phase
This, the last phase, congratulates or pities the player for winning or losing.

#### Diagram of phases
![alt text](phasesDiagram.png)

### Exceptions
For this game we created three custom Exceptions:

#### InvalidChoice Exception
If an input is invalid, this exception is raised asking for a valid one.

#### InvalidTarget Exception
There are some constrains on which enemies and players can be attacked. If such constrains
are violated, this exception is raised. The player or enemy will lose its turn.

#### InvalidTransition Exception
Even though the flow of the game is restricted by its construction, this exception protects
the game from code injections that could force a change of phase that is not allowed.
