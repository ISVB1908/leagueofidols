/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.leagueofidols.adt.tree;

import edu.upb.leagueofidols.models.Player;
import edu.upb.queue.LinkedQueue;

/**
 *
 * @author cahuc
 */
public class PlayerTree implements ITree<Player>{

    private TreeNode<Player> root = null;
    private LinkedQueue preorder;
    private LinkedQueue postorder;
    private LinkedQueue inorder;
    
    public TreeNode<Player> getRoot() {
		return root;
	}



	public void setRoot(TreeNode<Player> root) {
		this.root = root;
	}



	@Override
    public void add(Player object) {
    	 root = addRecursive(object, root);
    	 
    	 
    } 
    public TreeNode addRecursive(Player value, TreeNode current) {

        if (current == null) {
            return new TreeNode(value);
        }

        if (value.compareTo((Player) current.getValue())==-1) {
            current.setLeft(addRecursive(value, current.getLeft()));
        } else if (value.compareTo((Player) current.getValue())==1) {
            current.setRight(addRecursive(value, current.getRight()));
        } else {
            System.out.println("¡El valor ya existe!");
            return current;
        }

        return current;
    }
    @Override
    public void find(Player object) {
      
    }

    @Override
    public boolean contains(Player object) {
    	 return containsRecursive(object, root);
    }

    @Override
    public void delete(Player object) {
    	 root = deleteRecursive(object, root);
    }
    public TreeNode deleteRecursive(Player value, TreeNode current) {

        if (current == null) {
            return null;
        } else if (((Player) current.getValue()).compareTo(value)==0) {

            // Case 1: Doesn't have children
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            // Case 2: It has at least ONE children
            if (current.getRight() == null) {
                return current.getLeft();
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }

            // Case 3: Does have 2 children
            Player smallestValue = findSmallestValue(current.getRight());
            current.setValue(smallestValue);
            current.setRight(deleteRecursive(smallestValue, current.getRight()));
            return current;

        }

        if (value.compareTo((Player) current.getValue())==-1) {
            current.setLeft(deleteRecursive(value, current.getLeft()));
            return current;
        } else {
            current.setRight(deleteRecursive(value, current.getRight()));
            return current;
        }
    }
    private Player findSmallestValue(TreeNode current) {
        return current.getLeft() == null ? (Player) current.getValue(): findSmallestValue(current.getLeft());
    }

    @Override
    public void traverse() {
    	traverseInOrder(root);
    }
    public void traverseInOrder(TreeNode current) {

        if (current != null) {
            traverseInOrder(current.getLeft());
            Player p = (Player) current.getValue();


            System.out.println( p.getPlayerName()+ "\n");
            traverseInOrder(current.getRight());
        }
    
    }

    public void traversePreOrder(TreeNode current) {
    	if (current != null) {
            Player p= (Player) current.getValue();
            System.out.println(p.getPlayerName()+"\n");
            traversePreOrder(current.getLeft());
            traversePreOrder(current.getRight());
        
        }
    }
    public void traversePostOrder(TreeNode current) {
      /*postorder = new LinkedQueue();
        if (current != null) {
            traversePostOrder(current.getLeft());
            traversePostOrder(current.getRight());
            postorder.enqueue(current.getValue());
        }*/
    	if (current != null) {
            traversePostOrder(current.getLeft());
            traversePostOrder(current.getRight());
            System.out.println(""+current.getValue());
        }
    }
    public boolean containsRecursive(Player value, TreeNode current) {
      
        if (current == null) {
            return false;
        } else if (((Player) current.getValue()).compareTo(value)==0) {
            
        	return true;
        }

        if (value.compareTo((Player) current.getValue())==-1) {
        	
        	return containsRecursive(value, current.getLeft());
        } else {
        	
            return containsRecursive(value, current.getRight());
        }

        /*
        return value < current.getValue()
                ? containsRecursive(value, current.getLeft())
                : containsRecursive(value, current.getRight());
         */
    }

    @Override
    public void inverse() {

        traversePreOrder(root);
        
    }


    
}