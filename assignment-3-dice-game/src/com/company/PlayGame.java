package com.company;

//-----------------------------------------------------------------------------
//  This is the application that uses the NoDoubleOnes class to have the game
//  played between the computer and the user.  This app simply creates
// the game object, initializes the game, then tell the object to play the game.
//-----------------------------------------------------------------------------

import java.util.*;

public class PlayGame {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        //  Create the game object
        NoDoubleOnes noOnesGame = new NoDoubleOnes();
        // Get name of user, a.k.a., the human player
        System.out.print("Who is playing against the computer? ");
        String name = kb.next();

        // Perform some initialization of the game object
        noOnesGame.init(name);

        // Let the game be played
        noOnesGame.playGame();
    }
}