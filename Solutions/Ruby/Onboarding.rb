STDOUT.sync = true # DO NOT REMOVE
# CodinGame planet is being attacked by slimy insectoid aliens.


# game loop
loop do
    $enemy1 = gets.chomp # name of enemy 1
    $dist1 = gets.to_i # distance to enemy 1
    $enemy2 = gets.chomp # name of enemy 2
    $dist2 = gets.to_i # distance to enemy 2
    
    if $dist1 < $dist2
        puts $enemy1
    else
        puts $enemy2
    end
    
end