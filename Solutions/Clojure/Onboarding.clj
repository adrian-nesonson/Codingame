(ns Player
  (:gen-class))

; CodinGame planet is being attacked by slimy insectoid aliens.
; <---
; Hint:To protect the planet, you can implement the pseudo-code provided in the statement, below the player.

(defn -main [& args]
  (while true
    (let [enemy1 (read) dist1 (read) enemy2 (read) dist2 (read)]
      (if (< dist1 dist2)
          (println enemy1)
          (println enemy2)))))
