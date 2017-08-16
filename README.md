# Table Tennis Score Keeper

For this project, I had to implement a score keeper app which gives a user the ability to keep track of the score
for two different teams (or players) playing a game of my choice.

I decided to create the score keeper app for table tennis.

On the first screen, you can start a new game or read some basic rules of the game.
I’ve used AlertDialog for this small modal window with the rules:

<img src="/readme_imgs/tabletennis1" width="300">

<img src="/readme_imgs/tabletennis2" width="300">

I've implemented an activity with the game settings, where the user can set players names,
choose the amount of games per match and the amount of points per game. All these fields also have default values.

<img src="/readme_imgs/tabletennis3" width="300">

The score changes automatically when you reach the highest score and the difference between players scores is 2 points.
After each game user gets a toast message with the winner announcement and the game score resets.
The same happens when the match ends.

<img src="/readme_imgs/tabletennis4" width="300">
