# Game of Blobs

## Description

You are given a list of blobs, each having an initial position in a discrete grid, and a size. Blobs try to eat each other greedily and move around accordingly.

During each cycle, all blobs move one step (Moore neighborhood) towards another blob of smaller size (if any). This blob is chosen as the closest one, with a preference for larger ones, breaking ties as clockwise (11H < 12H > 01H).

At the end of each cycle, blobs merge (with summed size) if they are on the same location.

Return the final state of the blobs.

### Example:
Given: ```[(0,2,1),(2,1,2)]``` as a list of (x,y and size)

    ..1    ..1    ..3
    ...    ..2    ...
    .2.    ...    ...
Solution: ```[(0,2)]```

---

## Clarifications

There are a few clarifications to bear in mind:

* All blobs choose their destination at the same moment, move, and merge at the same moment 
* It's possible that you'll end up with more than one blob in the end 
* Larger blobs can merge with each other, for example if they collide when moving towards a common goal 
* Often one will end up trailing another for some time 
* As blobs try to minimise the distance there will be a preference for diagonal moves

The discussion in Reddit suggests breaking ties by selecting the first prey clockwise from 12 o'clock. Feel free to do so if you want to, but that adds a bit of complexity so we're bothering with that requirement.

If you complete the challenge and want to have a little fun, try adding the following rule:

* Instead of remaining static, if a blob has no prey smaller than it then it should move in a random direction (within the bounds of the world)

---

## Challenge

    [(0,1,2),
    (10,0,2)]

    [(4, 3, 4),
    (4, 6, 2),
    (8, 3, 2),
    (2, 1, 3)]

    [(-57, -16, 10),
    (-171, -158, 13),
    (-84, 245, 15),
    (-128, -61, 16),
    (65, 196, 4),
    (-221, 121, 8),
    (145, 157, 3),
    (-27, -75, 5)]

---

## Bonus Challenge 1

Help the blobs break out of flatland.

Given: ```[(1,2),(4,2)]```

    .1..2    .1.2.    .12..    .3...

A solution: ```[(1,3)]```

Given ```[(0,2,0,1),(1,2,1,2)]```

    ..1    .21    ..3
    ...    ...    ...
    /      /      /
    ...    ...    ...
    2..    ...    ...

A solution ```[(0,2,0)]```

---

## Bonus Challenge 2

Mind that the distances can be long. Try to limit run times.

---

## Additional Challenge Scenarios

    [(6,3),
    (-7,4),
    (8,3),
    (7,1)]

    [(-7,-16,-16,4),
    (14,11,12,1),
    (7,-13,-13,4),
    (-9,-8,-11,3)]


    [(-289429971, 243255720, 2),
    (2368968216, -4279093341, 3),
    (-2257551910, -3522058348, 2),
    (2873561846, -1004639306, 3)]

---

https://www.reddit.com/r/dailyprogrammer/comments/aldexk/20190130_challenge_374_intermediate_the_game_of/