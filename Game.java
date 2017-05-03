import java.util.InputMismatchException;
import java.util.Scanner;


public class Game {
	public static void main(String[] args) {
		int b1 = 100;
		int b2 = 100;
		boolean wantToPlay = true;
		Scanner scunner = new Scanner(System.in);
		while (wantToPlay) {
                        Deck deck = new Deck();
			int p = 0;
			int bet = 1;
			int mx = 20;
			System.out.println("This is a rudimentary, text-based simulation of five card draw poker, played by two parties.");
			System.out.println("To fold, bet a number lower than the minimum.");
			System.out.println("The ante is one chip.");
			System.out.println("The maximum bet is twenty chips.");
			System.out.println("No sandbagging.");
			/*boolean firstAnte = false;
			while (firstAnte == false) {
				System.out.println("Player One: Ante up");
				try {bet = scunner.nextInt();} catch (InputMismatchException ime) {System.out.println("That's not even a number, is it?  Take some time to think about what you've done."); System.exit(0);}
				if (bet < 1) System.out.println("Ante must be non-zero.");
				else if (bet > 1 && bet > b1) System.out.println("You're being way too optimistic here.");
				else if (bet > 1) System.out.println("Technically legal, but I'm afraid I can't do that.");
				else firstAnte = true;
			}
			if (bet > b1) bet = b1; */
			b1 -= bet;
			p += bet;
			Card[] h1 = new Card[5]; /*
			boolean secondAnte = false;
			while (secondAnte == false) {
				System.out.println("Player Two: Ante up");
				try {bet = scunner.nextInt();} catch (InputMismatchException ime) {System.out.println("That's not even a number, is it?  Take some time to think about what you've done."); System.exit(0);}
				if (bet < 1) System.out.println("Ante must be non-zero.");
				else if (bet > 1 && bet > b2) System.out.println("You're being way too optimistic here.");
				else if (bet > 1) System.out.println("Technically legal, but I'm afraid I can't do that.");
				else secondAnte = true;
			}
			if (bet > b2) bet = b2; */
			b2 -= bet;
			p += bet;
			Card[] h2 = new Card[5];
			for (int i = 0; i < 5; i++) {
				h1[i] = deck.draw();
				h2[i] = deck.draw();
			} 
			System.out.println("Player One's hand:");
			for (int i = 0; i < 5; i++) {
				System.out.println(h1[i]);
			}
			System.out.println("Player Two's hand:");
			for (int i = 0; i < 5; i++) {
				System.out.println(h2[i]);
			}
			/*System.out.println("Player One: Please bet now");
			bet = scunner.nextInt();
			if (bet > b1) {
				System.out.println("Player One goes all in with " + b1 + ".");
				bet = b1;
			}
			if (bet == minimum) {System.out.println("Player One checks."); s1 = 0;}
			else if (bet < minimum) {System.out.println("Player One folds."); s1 = -1;}
			else {System.out.println("Player One raises to " + bet + "."); s1 = 1;}
			if (s1 == 1) {
				b1 -= bet;
				p += bet;
				minimum = bet;
				System.out.println(p);
				System.out.println("Player Two: Please bet now");
				bet = scunner.nextInt();
				if (bet > b2) {
					System.out.println("Player Two goes all in with " + b2 + ".");
					bet = b2;
				} 
				if (bet == minimum) {System.out.println("Player Two calls."); s2 = 0;}
				else if (bet < minimum) {System.out.println("Player Two folds."); s2 = -1;}
				else {System.out.println("Player Two raises to " + bet + "."); s2 = 1;}
				if (s2 >= 0) {
					b2 -= bet;
					p += bet;
					minimum = bet;
					System.out.println(p);
				}
			} else if (s1 == 0) {
				System.out.println("Player Two: Please bet now");
				bet = scunner.nextInt();
				if (bet > b2) {
					System.out.println("Player Two goes all in with " + b2 + ".");
					bet = b2;
				} 
				if (bet == minimum) {System.out.println("Player Two checks."); s2 = 0;}
				else if (bet < minimum) {System.out.println("Player Two folds."); s2 = -1;}
				else {System.out.println("Player Two raises to " + bet + "."); s2 = 1;}
				if (s2 == 1) {
					b2 -= bet;
					p += bet;
					minimum = bet;
					System.out.println(p);
				}
			}*/
			int minimum = 0;
			int s1 = 1; //s1 == 0 -> player one checks or calls, s1 == 1 -> player one raises, s1 == -1 player one folds
			int s2 = 1; //s2 0 -> player two checks or calls, s2 1 -> player two raises, s2 == -1 player two folds
			int turn = 1;
			while (s1 == 1 && s2 == 1) {
				if (turn == 1) {
                                        if (b1 < minimum) {System.out.println("Player One can't match that."); s1 = -1;}
                                        else {
					System.out.println("Player One: Please bet now");
					try {bet = scunner.nextInt();} catch (InputMismatchException ime) {System.out.println("That's not even a number, is it?  Take some time to think about what you've done."); System.exit(0);}
					if (bet > b1 && bet < mx) {
						System.out.println("Player One goes all in with " + b1 + ".");
						bet = b1;
					} else if (bet > mx) {
						bet = mx;
					}
					if (bet == minimum && minimum == 0) {System.out.println("Player One checks."); s1 = 1;}
					else if (bet == minimum) {System.out.println("Player One calls."); s1 = 0;}
					else if (bet < minimum) {System.out.println("Player One folds."); s1 = -1;}
					else {System.out.println("Player One raises to " + bet + "."); s1 = 1;}
					if (s1 >= 0) {
						b1 -= bet;
						p += bet;
						minimum = bet;
						System.out.println(p);
					}
					turn = 2;
					}
				} else if (turn == 2) {
                                        if (b2 < minimum) {System.out.println("Player Two can't match that."); s2 = -1;}
                                        else {
					System.out.println("Player Two: Please bet now");
					try {bet = scunner.nextInt();} catch (InputMismatchException ime) {System.out.println("That's not even a number, is it?  Take some time to think about what you've done."); System.exit(0);}
					if (bet > b2 && bet < mx) {
						System.out.println("Player Two goes all in with " + b2 + ".");
						bet = b2;
					} else if (bet > mx) {
						bet = mx;
					}
					if (bet == minimum && minimum == 0) {System.out.println("Player Two checks."); s1 = 0;}
					else if (bet == minimum) {System.out.println("Player Two calls."); s1 = 0;}
					else if (bet < minimum) {System.out.println("Player Two folds."); s2 = -1;}
					else {System.out.println("Player Two raises to " + bet + "."); s2 = 1;}
					if (s2 >= 0) {
						b2 -= bet;
						p += bet;
						minimum = bet;
						System.out.println(p);
					}
					turn = 1;
					}
				}
			}
			if (s1 >= 0 && s2 >= 0) {
			int replace = 0;
			boolean afraidNot = false;
			System.out.println("Player One: How many cards would you like to replace?");
			try {replace = scunner.nextInt();} catch (InputMismatchException ime) {System.out.println("That's not even a number, is it?  Take some time to think about what you've done."); System.exit(0);}
			if (replace < 0) replace = 0;
			if (replace > 5) replace = 5;
			if (replace > 0) {
				int[] condemned = new int[replace];
				if (replace == 1) System.out.println("Which one?  Please enter a number between one and five (inclusive).");
				else System.out.println("Which ones?  Please enter " + replace + " numbers between one and five (inclusive).");
				for (int i = 0; i < replace; i++) {
					try {condemned[i] = scunner.nextInt() - 1;} catch (InputMismatchException ime) {System.out.println("That's not even a number, is it?  Take some time to think about what you've done."); System.exit(0);}
					if (condemned[i] < 0 || condemned[i] > 4) afraidNot = true;
				}
				if (afraidNot) System.out.println("I received a number outside of the valid range.  I'll take that as a \"0.\"");
				else {
					for (int i = 0; i < replace; i++) {
						h1[condemned[i]] = deck.draw();
					}
				}
				System.out.println("Player One's hand:");
				for (int i = 0; i < 5; i++) {
					System.out.println(h1[i]);
				}
			}
			replace = 0;
			afraidNot = false;
			System.out.println("Player Two: How many cards would you like to replace?");
			try {replace = scunner.nextInt();} catch (InputMismatchException ime) {System.out.println("That's not even a number, is it?  Take some time to think about what you've done."); System.exit(0);}
			if (replace < 0) replace = 0;
			if (replace > 5) replace = 5;
			if (replace > 0) {
				int[] condemned = new int[replace];
				if (replace == 1) System.out.println("Which one?  Please enter a number between one and five (inclusive).");
				else System.out.println("Which ones?  Please enter " + replace + " numbers between one and five (inclusive).");
				for (int i = 0; i < replace; i++) {
					try {condemned[i] = scunner.nextInt() - 1;} catch (InputMismatchException ime) {System.out.println("That's not even a number, is it?  Take some time to think about what you've done."); System.exit(0);}
					if (condemned[i] < 0 || condemned[i] > 4) afraidNot = true;
				}
				if (afraidNot) System.out.println("I received a number outside of the valid range.  I'll take that as a \"0.\"");
				else {
					for (int i = 0; i < replace; i++) {
						h2[condemned[i]] = deck.draw();
					}
				}
				System.out.println("Player Two's hand:");
				for (int i = 0; i < 5; i++) {
					System.out.println(h2[i]);
				}
			}
			minimum = 0;
			s1 = 1; //s1 == 0 -> player one checks or calls, s1 == 1 -> player one raises, s1 == -1 player one folds
			s2 = 1; //s2 0 -> player two checks or calls, s2 1 -> player two raises, s2 == -1 player two folds
			turn = 1;
			while (s1 == 1 && s2 == 1) {
				if (turn == 1) {
                                        if (b1 < minimum) {System.out.println("Player One can't match that."); s1 = -1;}
                                        else {
					System.out.println("Player One: Please bet now");
					try {bet = scunner.nextInt();} catch (InputMismatchException ime) {System.out.println("That's not even a number, is it?  Take some time to think about what you've done."); System.exit(0);}
					if (bet > b1 && bet < mx) {
						System.out.println("Player One goes all in with " + b1 + ".");
						bet = b1;
					} else if (bet > mx) {
						bet = mx;
					}
					if (bet == minimum && minimum == 0) {System.out.println("Player One checks."); s1 = 1;}
					else if (bet == minimum) {System.out.println("Player One calls."); s1 = 0;}
					else if (bet < minimum) {System.out.println("Player One folds."); s1 = -1;}
					else {System.out.println("Player One raises to " + bet + "."); s1 = 1;}
					if (s1 >= 0) {
						b1 -= bet;
						p += bet;
						minimum = bet;
						System.out.println(p);
					}
					turn = 2;
					}
				} else if (turn == 2) {
                                        if (b2 < minimum) {System.out.println("Player Two can't match that."); s2 = -1;}
                                        else {
					System.out.println("Player Two: Please bet now");
					try {bet = scunner.nextInt();} catch (InputMismatchException ime) {System.out.println("That's not even a number, is it?  Take some time to think about what you've done."); System.exit(0);}
					if (bet > b2 && bet < mx) {
						System.out.println("Player Two goes all in with " + b2 + ".");
						bet = b2;
					} else if (bet > mx) {
						bet = mx;
					}
					if (bet == minimum && minimum == 0) {System.out.println("Player Two checks."); s1 = 0;}
					else if (bet == minimum) {System.out.println("Player Two calls."); s1 = 0;}
					else if (bet < minimum) {System.out.println("Player Two folds."); s2 = -1;}
					else {System.out.println("Player Two raises to " + bet + "."); s2 = 1;}
					if (s2 >= 0) {
						b2 -= bet;
						p += bet;
						minimum = bet;
						System.out.println(p);
					}
					turn = 1;
					}
				}
			}
			}
			if (s1 < 0) {
				b2 += p;
				p = 0;
			} else if (s2 < 0) {
				b1 += p;
				p = 0;
			} else {
				int[] w1 = compress(h1);
				int[] w2 = compress(h2);
				if (showdown(w1, w2) > 0) {
					System.out.println("Player One wins.");
					b1 += p;
					p = 0;
				} else if (showdown(w1, w2) < 0) {
					System.out.println("Player Two wins.");
					b2 += p;
					p = 0;
				} else {
					System.out.println("Draw.");
					b1 += p / 2;
					b2 += p / 2;
					p = 0;
				}
			}
			wantToPlay = false;
			if (b1 < 1) System.out.println("Player One has been busted out!");
			else if (b2 < 1) System.out.println("Player Two has been busted out!");
			else {
				String answer = "fish";
				System.out.println("Would you like to play again? y/n");
				answer = scunner.next();
				wantToPlay = answer.equals("y");
			}
		}
		scunner.close();
	}
	
	public static int[] compress(Card[] hand) {
                int[] val = new int[6];
		int matchingNumber1 = 0;
		int numberCount1 = 0;
		int matchingNumber2 = 0;
		int numberCount2 = 0;
		boolean flush = true;
		boolean straight = true;
		int maximum = 0;
		int minimum = 14;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (hand[i].quantity == hand[j].quantity) {
					if (matchingNumber1 == hand[i].quantity) {
						numberCount1 += 1;
					} else if (matchingNumber1 == 0) {
						matchingNumber1 = hand[i].quantity;
						numberCount1 += 1;
					} else if (matchingNumber2 == 0) {
						matchingNumber2 = hand[i].quantity;
						numberCount2 += 1;
					} else if (matchingNumber2 == hand[i].quantity) {
						numberCount2 += 1;
					}
				}
				if (hand[i].suit != hand[j].suit){
					flush = false;
				}
			}
			if (hand[i].quantity < minimum) minimum = hand[i].quantity;
			if (hand[i].quantity > maximum) maximum = hand[i].quantity;
		}
		for (int i = 0; i < 5; i++) {
			int mv = 0;
			int mi = 8;
			char ms = '@';
			for (int j = i; j < 5; j++) {
				if (hand[j].quantity > mv) {
					mv = hand[j].quantity;
					mi = j;
					ms = hand[j].suit;
				}
			}
			int temp = hand[i].quantity;
			char alsoTemp = hand[i].suit;
			hand[i].quantity = mv;
			hand[i].suit = ms;
			hand[mi].quantity = temp;
			hand[mi].suit = alsoTemp;
		}
		for (int i = 0; i < 5; i++) {System.out.print(hand[i] + " ");} System.out.println();
		int st = maximum;
		for (int i = 1; i < 5; i++) {
			if (hand[i].quantity != st - 1)
				straight = false;
		}
		
		if (straight && flush) {
			if (maximum == 13 && minimum == 9 && flush == true) {System.out.println("Oh, with a royal flush...");}
			val[0] = 8;
			for (int i = 0; i < 5; i++) {
				val[i + 1] = hand[i].quantity;
			}
		}
		else if (numberCount1 == 4) {
			val[0] = 7;
			val[1] = matchingNumber1; val[2] = matchingNumber1; val[3] = matchingNumber1; val[4] = matchingNumber1;
			for (int i = 0; i < 5; i++) {
				if (hand[i].quantity != matchingNumber1) val[5] = hand[i].quantity;
			}
		}
		else if (numberCount1 == 3 && numberCount2 == 2) {
			val[0] = 6;
			val[1] = matchingNumber1; val[2] = matchingNumber1; val[3] = matchingNumber1;
			val[4] = matchingNumber2; val[5] = matchingNumber2;
		}
		else if (numberCount1 == 2 && numberCount2 == 3) {
			val[0] = 6;
			val[1] = matchingNumber2; val[2] = matchingNumber2; val[3] = matchingNumber2;
			val[4] = matchingNumber1; val[5] = matchingNumber1;
		}
		else if (flush) {
			val[0] = 5;
			for (int i = 0; i < 5; i++) {
				val[i + 1] = hand[i].quantity;
			}
		}
		else if (straight) {
			val[0] = 4;
			for (int i = 0; i < 5; i++) {
				val[i + 1] = hand[i].quantity;
			}
		}
		else if (numberCount1 == 3) {
			val[0] = 3;
			val[1] = matchingNumber1; val[2] = matchingNumber1; val[3] = matchingNumber1;
			int n = 4;
			for (int i = 0; i < 5; i++) {
				if (hand[i].quantity != matchingNumber1) {
					val[n] = hand[i].quantity;
					n++;
				}
			}
		}
		else if (numberCount2 == 3) {
			val[0] = 3;
			val[1] = matchingNumber2; val[2] = matchingNumber2; val[3] = matchingNumber2;
			int n = 4;
			for (int i = 0; i < 5; i++) {
				if (hand[i].quantity != matchingNumber2) {
					val[n] = hand[i].quantity;
					n++;
				}
			}
		}
		else if (numberCount2 != 0 && matchingNumber1 > matchingNumber2) {
			val[0] = 2;
			val[1] = matchingNumber1; val[2] = matchingNumber1;
			val[3] = matchingNumber2; val[4] = matchingNumber2;
			for (int i = 0; i < 5; i++) {
				if (hand[i].quantity != matchingNumber1 && hand[i].quantity != matchingNumber2) val[5] = hand[i].quantity;
			}
		}
		else if (numberCount2 != 0 && matchingNumber2 > matchingNumber1) {
			val[0] = 2;
			val[1] = matchingNumber2; val[2] = matchingNumber2;
			val[3] = matchingNumber1; val[4] = matchingNumber1;
			for (int i = 0; i < 5; i++) {
				if (hand[i].quantity != matchingNumber1 && hand[i].quantity != matchingNumber2) val[5] = hand[i].quantity;
			}
		}
		else if (numberCount1 != 0) {
			val[0] = 1;
			val[1] = matchingNumber1; val[2] = matchingNumber1;
			int n = 3;
			for (int i = 0; i < 5; i++) {
				if (hand[i].quantity != matchingNumber1) {
					val[n] = hand[i].quantity;
					n++;
				}
			}
		}
		else {
			val[0] = 0;
			for (int i = 0; i < 5; i++) {
				val[i + 1] = hand[i].quantity;
			}
		}
		for (int i = 0; i < 6; i++) {System.out.print(val[i] + " ");} System.out.println();
		return val;
	}
	
	public static int showdown (int[] left, int[] right) {
		for (int i = 0; i < 6; i++) {
			if (left[i] > right[i]) return 1;
			else if (left[i] < right[i]) return -1;
		}
		return 0;
	}
}
