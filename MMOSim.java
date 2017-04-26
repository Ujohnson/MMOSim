import java.util.Scanner;

abstract class Hero {
	//in warrior only
	private boolean member;
	public double atk;
	public double def; 

	Hero() {
		atk = 0;
		def = 0;
	}

	Hero(boolean x, double y, double z ) {
		member = x;
		atk = y;
		def = z;
	}

	Hero(double d, double k ) {
		atk = d;
		def = k;
	}

	boolean getMember() {
		
		return member;
	}
	void setMember(boolean h1) {
		member = h1;
	}

	abstract double attack();
	abstract double defend();
}

class Rogue extends Hero {
	
	Rogue(double r, double b) {
		super(true,r,b);
	}

	double attack() {

		return atk*3;
	}

	double defend() {
		return def*2;
	}


	boolean isMember() {
		return getMember();
	}
}
	
class Warrior extends Hero {
	
	Warrior(double j, double z) {
		super(false,j,z);
	}

	double attack() {
		return atk*2;
	}

	double defend() {
		return def*5;
	}


	boolean isMember() {
		return getMember();
	}	 
}

class Mage extends Hero {

	Mage(double f, double p) {
		super(true,f,p);
	}

	double attack() {
		return atk*3;
	}

	double defend() {
		return def*2;
	}

	boolean isMember() {
		return getMember();
	}	 
}

class PlayGame {

	static void playGame() {

		System.out.println("Player 1, Choose your class");
		String getText = input();
		Hero player1 = charCreate(getText);
		//System.out.println(player1);

		System.out.println("Player 2, Choose your class");
		getText = input();
		Hero player2 = charCreate(getText);
		//System.out.println(player2);
		boolean done = false;
		int turn = 0;
		while (!done) {
			turn++;
			System.out.println("This is turn: " + turn);
			
			if (turn % 2 == 1) {
				System.out.println("Player1's turn");
				battle(player1, player2);
			}

			else {
				System.out.println("Player2's turn");
				battle(player2, player1);
			}
			


			
			if (player1.def <= 0 || player2.def <= 0) {
				done = true;	
			}
			
		}	
	}

	static String input() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

	static Hero charCreate(String x) {
		Hero ob;
		System.out.println(x);

		if (x.equals("Warrior") ) {
			ob = new Warrior(4.5, 200);
		}
		else if (x.equals("Mage")) {
			ob = new Mage(11, 100);
		}
		else {
			ob = new Rogue(15, 50);
		}

		return ob;
	}

	static void battle(Hero x, Hero y) {
		System.out.println("Do you want to Attack or Defend");
		String atkOrDef = input();
		if (atkOrDef.equals("Attack")) {
			y.def = y.def - x.attack();
			x.atk = x.attack();
			System.out.println("Atk of attacker is now: " + x.atk);
			System.out.println("Def of attacked is now: " + y.def);
		}
		else {
			x.def = x.defend();
			System.out.println("Character defended, defense is now: " + x.def);
		}
	}
}

class HeroGame {
	public static void main(String[] args) {

		// Rogue theRealWiz = new Rogue(15,5);
		// Warrior subZer0 = new Warrior(4.5,20);
		// Mage krystal = new Mage(11,11);

		// System.out.println("'TheRealWiz' has joined the instance \n Current DMG: " + theRealWiz.attack() + " Current DEF: " + theRealWiz.defend()+ " Membership status: " + theRealWiz.isMember());
		// System.out.println();
		// System.out.println("'subZer0' has joined the instance \n Current DMG: " + subZer0.attack() + " Current DEF: " + subZer0.defend() + " Membership status: " + subZer0.isMember());
		// System.out.println();
		// System.out.println("'krystal' has joined the instance \n Current DMG: " + krystal.attack() + " Current DEF: " + krystal.defend() + " Membership status: " + krystal.isMember());

		

		

		PlayGame.playGame();
	}


}