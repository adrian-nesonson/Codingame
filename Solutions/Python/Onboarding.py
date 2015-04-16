import sys, math

# CodinGame planet is being attacked by slimy insectoid aliens.


# game loop
while 1:
    enemy1 = raw_input() # name of enemy 1
    dist1 = int(raw_input()) # distance to enemy 1
    enemy2 = raw_input() # name of enemy 2
    dist2 = int(raw_input()) # distance to enemy 2
    
    if dist1 < dist2:
        print enemy1
    else:
        print enemy2