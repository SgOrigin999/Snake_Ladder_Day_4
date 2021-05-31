package com.bridgelab.snakeladder.day4;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SnakeLadder {
	final static int WINPOINT = 100;
	static int GETLADDER = 0;
	
	static Map<Integer, Integer> snake = new HashMap<Integer, Integer>();
	static Map<Integer, Integer> ladder = new HashMap<Integer, Integer>();

	{
		snake.put(99, 54);
		snake.put(70, 55);
		snake.put(52, 42);
		snake.put(25, 2);
		snake.put(95, 72);

		ladder.put(6, 25);
		ladder.put(11, 40);
		ladder.put(60, 85);
		ladder.put(46, 90);
		ladder.put(17, 69);
	}
	
	public static int singlePlayeWithZeroPosition() {
		int player;
		int playerPosition = 0;
		player = playerPosition;
		return player;
	}

	public int rollDice() {
		int n = 0;
		Random r = new Random();
		n = r.nextInt(7);
		System.out.println("DICEVALUE::" + n);
		return (n == 0 ? 1 : n);
	}

	public int checkOptionThenPlay() {
		int n;
		Random r = new Random();
		n = r.nextInt(3);
		if (n == 0) {
			System.out.println("Player Stays in the Same Position::");
		} else if (n == 1) {
			System.out.println("Player Move ahead by the Number of position recived in die::");
		}else if (n == 2) {
			System.out.println("Player Move  behind by the Number of position recived in die::");
		}
		return n;
	}
	
	public boolean playerWin() {
		Scanner sc=new Scanner(System.in);
		String str;
		int diceValue;
		boolean result = false;
		int singlePlaye = singlePlayeWithZeroPosition();
		do {
			System.out.println("Press r to roll Dice");
			str = sc.next();
			diceValue = rollDice();
			if (singlePlaye <= 100) {
				singlePlaye = calculatePlayerValue(singlePlaye, diceValue);
				System.out.println("First Player :: " + singlePlaye);
				if (isWin(singlePlaye)) {
					System.out.println("player Wins");
					result= true;
				}
			}
		} while ("r".equals(str));
		return result;
	}
	
	public int calculatePlayerValue(int player, int diceValue) {
		
		player = player + diceValue;

		if (player > WINPOINT) {
			player = player - diceValue;
			return player;
		}

		if (null != snake.get(player)) {
			System.out.println("swallowed by snake");
			player = snake.get(player);
		}

		if (null != ladder.get(player)) {
			System.out.println("climb up the ladder");
			player = ladder.get(player);
		}
		return player;
	}

	public boolean isWin(int player) {
		return WINPOINT == player;
	}

	public static void main(String[] args) {
		SnakeLadder snake = new SnakeLadder();
		System.out.println("Snake Ladder Game Play With Single Player::");
		int singlePlaye = singlePlayeWithZeroPosition();
		System.out.println("Player Rool The die to get Number 1 to 6 Range only::");
		int n = snake.rollDice();
		System.out.println("Check Player Play Option::");
		int moveOfPlayer=snake.checkOptionThenPlay();
		System.out.println("Repeat Till Player Reach Wining Position 100::"+snake.playerWin());
		

	}
}
