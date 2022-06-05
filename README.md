# Java-Graph-Algorithm
The program models the connections between the characters of the famous TV series: Game of Thrones. The data is available in the link below:
- https://github.com/melaniewalsh/sample-social-network-datasets/blob/master/sample-datasets/game-of-thrones/got-edges.csv#L1
----------------------
- Weighted graph will represent these data with edge-weights equal to the connection strength between two individual characters.
- SeriesCharacter is an object with name. The graph vertices are the Characters of this TV-Series.
---------------------
- isconnected(character1, character2): User gives two characters, the program searches and prints a message indicating if these two characters are connected to each other.
- pathTo(character1, character2): User gives two characters, then the program searches and prints the shortest path from character1 to character2. If there are several shortest paths, printing one of them is enough.
- delete(character1, character2): User gives two characters, and the program deletes the connection between them.
- change(character1, character2, newWeight): User gives two characters, and the program updates the connection strength between them by newWeight.
- NumberofcharacterGroups: Prints the connected components and Characters in each component. If there is only single group you can delete some links and test this functionality. 
