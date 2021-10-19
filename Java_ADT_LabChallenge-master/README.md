# Java Abstract Data Types Challenge*

Syllabus -  Week 11 - ADT Material and examples

### Challenge  

- Implement a solution for League of Idols case
- Optional: add a Queue ADT for In-Pre-Post order traverse in PlayerTree

### Some features

The group of students designs the structure for a new game they have 
designed: **League of Idols**, and define some rules:

- The game consists of players distributed by Levels (**TierLevel**) of which there can only be 3 
  levels (although more are expected in the future). For this reason 
  an **Enum** called **TierLevel** was created with three possible 
  values (**HERO, MASTER, IDOL**).
- They want to organize players by Tiers, for this they have 
  decided to create a collection called **TierCollection** that behaves like 
  a Linked List. Each node is a **CustomEntry** and instead of having a single 
  <T> value, it contains a **<Key, Value>** pair,  with **TierLevel** for key 
  and a Binary Tree structure named **PlayerTree** for values.
- Hence, there should only be a single key for **CustomEntry** on **TierCollection**,
  for example, there can only be a single **CustomEntry** 
  with the **TierLevel.HERO** key and a PlayerTree tree with the 
  respective players of that TierLevel.
- The **Player** class implements the **Comparable** interface to define how 
  insertion works on the **PlayerTree** binary tree, players will 
  be added to the tree using their player name as ID, without 
  allowing inserting two players with the same name.
- For the moment, the tree traversal prints the values contained in its nodes 
  through the console, but they want to include the implementation of a Queue, which 
  adds the elements obtained by traversing the tree for future iteration.
- The project seeks to encapsulate the behaviors, regardless of its 
  internal organization in lists, Queues or Trees. The **ILeague** interface serves as 
  a definition of the expected use cases of the project.
- The **TierCollection** structure implements an Iterator, through the implementation of the
  **Iterable** interface that allows traversing the structure in a simple and orderly way.

### Test cases

- Add players in each tier
- Remove players from tier  
- Print players per tier


