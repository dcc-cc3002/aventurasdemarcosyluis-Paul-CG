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