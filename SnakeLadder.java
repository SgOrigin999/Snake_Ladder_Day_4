package com.bridgelab.snakeladder.day4;

import java.util.Random;

public class SnakeLadder {
	
	public static int singlePlayeWithZeroPosition() {
		int player;
		int playerPosition = 0;
		player=playerPosition; 
		return player;
	}
	
	public int rollDice() {
		int n = 0;
		Random r = new Random();
		n = r.nextInt(7);
		System.out.println("DICEVALUE::" + n);
		return (n == 0 ? 1 : n);
	}
	
public static void main(String[] args) {
	SnakeLadder snake= new SnakeLadder();
	System.out.println("Snake Ladder Game Play With Single Player::");
	int singlePlaye=singlePlayeWithZeroPosition();
	System.out.println("Player Rool The die to get Number 1 to 6 Range only::");
	int n=snake.rollDice();
}
}
