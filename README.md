# OOP Fundamentals Lab

## Learning Goals

- Create a class hierarchy using inheritance
- Override methods in the subclass
- Call superclass methods from the subclass
- Create classes that implement an interface

## Instructions

Fork and clone this lab.


## Task #1 - Do not alter the `Athlete` class

You will implement the following class hierarchy:

- Every athlete has a jersey number.
- Football players are athletes that make touchdowns.
- Hockey players are athletes that score goals and get penalties.
- An athlete's performance rating is calculated based on the type of athlete:
    - The rating for a football player is calculated as (touchdowns * 5).
    - The rating for a hockey player is calculated as (goals * 4 - penalties * 2).

![task1 uml](https://curriculum-content.s3.amazonaws.com/6677/pillars/task1_uml.png)

The starter code contains an abstract class named `Athlete`
with concrete methods `setJerseyNumber()`
and `getJerseyNumber()`, along with an abstract method `getRating()`.

```java
public abstract class Athlete {
    private int jerseyNumber;

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public abstract int getRating() ;

}
```


1. Create a subclass of `Athlete` named `FootballPlayer`.
    - Add an instance variable `touchdowns` and get/set methods.
    - Override the `getRating()` method to calculate the football player's rating based on the number of touchdowns.

2. Create a subclass of `Athlete` named `HockeyPlayer`.
    - Add instance variables `goals` and `penalties` and get/set methods.
    - Override the `getRating()` method to calculate the hockey player's rating based on the number of goals and penalties.

3. Edit the `Task1Main` class with the following `main` method:

```java
public class Task1Main {

    public static void printAthleteInfo(Athlete athlete) {
        System.out.printf("Jersey# %d has rating of %d%n",
                athlete.getJerseyNumber(),
                athlete.getRating());
    }

    public static void main(String[] args) {

        FootballPlayer athlete1 = new FootballPlayer();
        athlete1.setJerseyNumber(22);
        athlete1.setTouchdowns(6);
        printAthleteInfo(athlete1);   //6 * 5 = 30

        FootballPlayer athlete2 = new FootballPlayer();
        athlete2.setJerseyNumber(57);
        athlete2.setTouchdowns(2);
        printAthleteInfo(athlete2);   //2 * 5 = 10

        HockeyPlayer athlete3 = new HockeyPlayer();
        athlete3.setJerseyNumber(22);
        athlete3.setGoals(5);
        athlete3.setPenalties(3);
        printAthleteInfo(athlete3);   //5 * 4 - 3 * 2 = 14

        HockeyPlayer athlete4 = new HockeyPlayer();
        athlete4.setJerseyNumber(17);
        athlete4.setGoals(1);
        printAthleteInfo(athlete4);   //1 * 4 - 0 * 2 = 4

    }
}
```

Run `Task1Main.main` and confirm the output:

```text
Jersey# 22 has rating of 30
Jersey# 57 has rating of 10
Jersey# 22 has rating of 14
Jersey# 17 has rating of 4
```


## Task #2 - Do not alter the `Question` class.

You will implement the following class hierarchy that represents questions on a written quiz or exam:

![task2 uml](https://curriculum-content.s3.amazonaws.com/6677/pillars/task2_uml.png)

The starter code contains the class named `Question` with the fields `text` (contains the actual question)
and `points` (number of points the question is worth), get/set methods,
and the default implementation of `displayQuestion` (prints the question text and points).

```java
public class Question {
	private String text;
	private int points;

	public void setText(String text) {this.text = text;}

	public void setPoints(int points) {this.points = points;}

	public void displayQuestion() {
		System.out.println(text + " ("+points+" points)");
	}
	
}
```

The `Task2Main` creates a sample question and displays it:

```java
public class Task2Main {
	public static void main(String []args)  {
		Question q1 = new Question();
		q1.setText("Which sport has been played on the moon?");
		q1.setPoints(7);
		q1.displayQuestion();
	}
}
```

Run `Task2Main` to confirm the output:

```text
Which sport has been played on the moon? (7 points)
```

Create a subclass of `Question` named `TrueFalseQuestion`.
The `TrueFalseQuestion` class should override the `displayQuestion()` method using the following logic:

- Call the superclass `displayQuestion()` method to print the question text and points on one line.
- Add two additional print statements to print true and false choices on separate lines as shown:

```text
NFL refs receive Super Bowl rings. (2 points)
(1) True
(2) False
```

Edit `Task2Main` to create two `TrueFalseQuestion` instances as shown:

```java
public static void main(String []args){
    Question q1=new Question();
    q1.setText("Which sport has been played on the moon?");
    q1.setPoints(7);
    q1.displayQuestion();

    System.out.println();
    TrueFalseQuestion q2 = new TrueFalseQuestion();
    q2.setText("NFL refs receive Super Bowl rings.");
    q2.setPoints(2);
    q2.displayQuestion();

    System.out.println();
    TrueFalseQuestion q3 = new TrueFalseQuestion();
    q3.setText("Olympic gold metals are made of silver.");
    q3.setPoints(3);
    q3.displayQuestion();
}
```

Confirm the output:

```text
Which sport has been played on the moon? (7 points)

NFL refs receive Super Bowl rings. (2 points)
(1) True
(2) False

Olympic gold metals are made of silver. (3 points)
(1) True
(2) False
```

Create a subclass of `Question` named `MultipleChoiceQuestion`.

- Add an instance variable named `choices` that stores an array of strings representing the multiple choices. Add set/get methods for `choices`.
- Override the `displayQuestion()` method with the following logic:
    - Call the superclass `displayQuestion()` method to print the question text and points on one line
    - Use a loop to print each array element as a numbered choice on a separate line as shown:

```text
Which team scored the most points in the 2018 season? (5 points)
(1) Patriots
(2) Broncos
(3) Browns
(4) Steelers
```

Edit `Task2Main` to create two `MultipleChoiceQuestion` objects and display as shown:

```java
public class Task2Main {
	public static void main(String []args)  {
		Question q1 = new Question();
		q1.setText("Which sport has been played on the moon?");
		q1.setPoints(7);
		q1.displayQuestion();

		System.out.println();
		TrueFalseQuestion q2 = new TrueFalseQuestion();
		q2.setText("NFL refs receive Super Bowl rings.");
		q2.setPoints(2);
		q2.displayQuestion();

		System.out.println();
		TrueFalseQuestion q3 = new TrueFalseQuestion();
		q3.setText("Olympic gold metals are made of silver.");
		q3.setPoints(3);
		q3.displayQuestion();

		System.out.println();
		MultipleChoiceQuestion q4 = new MultipleChoiceQuestion();
		q4.setText("Which team scored the most points in the 2018 season?");
		q4.setPoints(5);
		q4.setChoices(new String[]{"Patriots", "Broncos", "Browns", "Steelers"});
		q4.displayQuestion();

		System.out.println();
		MultipleChoiceQuestion q5 = new MultipleChoiceQuestion();
		q5.setText("What sport did James Naismith invent?");
		q5.setPoints(10);
		q5.setChoices(new String[]{"Football", "Basketball", "Baseball"});
		q5.displayQuestion();
	}
}
```

Confirm the output:

```text
Which sport has been played on the moon? (7 points)

NFL refs receive Super Bowl rings. (2 points)
(1) True
(2) False

Olympic gold metals are made of silver. (3 points)
(1) True
(2) False

Which team scored the most points in the 2018 season? (5 points)
(1) Patriots
(2) Broncos
(3) Browns
(4) Steelers

What sport did James Naismith invent? (10 points)
(1) Football
(2) Basketball
(3) Baseball
```


## Task #3

You will implement the following interface hierarchy:

![task3 uml](https://curriculum-content.s3.amazonaws.com/6677/pillars/task3_uml.png)

Create a new interface named `Flippable` with one abstract method named `flip()` that
takes no parameters and has a `void` return type.

Create a new class named `Coin` that implements `Flippable`.  The `flip()` method should
print a random string of "Heads" or "Tails" each time it is called.

Create a new class named `Mattrest` that implements `Flippable`. Add a boolean instance
variable named `labelSideUp` that should be initialized to `true`.  Implement the `flip()`
method to toggle the value of `labelSideUp` and print the value as shown in the sample output below:

```text
Label side up is false
```

Edit the `Task3Main` driver to instantiate an instance of each class and call the flip method 5 times in a
loop:

```java
public class Task3Main {
	public static void main(String []args)  {
		Flippable coin = new Coin();
		for (int i = 0; i<5; i++) {
			coin.flip();
		}

		Flippable mattress = new Mattress(); 
		for (int i = 0; i<5; i++) {
			mattress.flip();
		}
	}
}
```

Confirm the output (random values may differ):

```text
Tails
Tails
Heads
Heads
Tails
Label side up is false
Label side up is true
Label side up is false
Label side up is true
Label side up is false
```
