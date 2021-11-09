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

### Last minute remarks
The attack method in the controller was design to make the game more extendable.
So, there is only one method for each attack-type (jump, hammer and enemy attack).
Given the attack restrictions of Luis and Boo, to reach the final method (the one 
that lives in Luis) an auxiliary private method is used to handle the conversion 
via a cast. I thought that, given a strong argument, we could use casting. Note that
this casting casts from Wicked to AttackableByLuis, which is contained in Wicked.
So. this configuration when Luis attacks Boo, an error is raised. This is by design.
The idea is to catch this error and show the player a message like "Luis is too afraid to 
attack Boo", improving the lore of the game. As people say, **"this is not a bug,
is a feature"**.

Other alternatives require a lot more code (complex one at that) and are less 
extensible. Think of adding one character or a new type of attack, what about 
items that change the attack pattern? It would basically kill any effort to 
extend/upgrade the game.

