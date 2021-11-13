# Addons:
1) `Multiple Levels` (Including win and lost place)
2) `Moving Objects` (enemies)
3) `Map Follows the Player in 2D Maze` - If this addon does not count because this won't affect the 3D maze in any way, then: `Level Countdown`


<br> <br> <br>

# NOTE
    This is not a bug in my opinion but I will note it: Enemy should be on the same tile as Player. Sometimes while player moving, you could miss the enemy because the player and the enemy moved to the different tile at the same time. 

    example:
        frame 1:
            Player (0, 4)
            Enemy (0, 5)

        frame 2:
            Player (0, 5)
            Enemy (0, 4)

        In this case both never reached the same tile, hence the enemy was not captured. 



