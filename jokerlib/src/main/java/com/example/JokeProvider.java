package com.example;

import java.util.Random;

public class JokeProvider {


    private String[] jokeArray = {
            "Q: How do you tell an introverted computer scientist from an extroverted computer scientist?\n A: An extroverted computer scientist looks at your shoes when he talks to you.",
            "Q: Why do programmers always mix up Halloween and Christmas?\nA: Because Oct 31 == Dec 25!",
            "“Knock, knock.”\n" +
                    "\n" +
                    "“Who’s there?”\n" +
                    "\n" +
                    "very long pause….\n" +
                    "\n" +
                    "“Java.”\n" +
                    "\n" +
                    ":-o",
            "A SQL query goes into a bar, walks up to two tables and asks, \"Can I join you?\"",
            "Q: how many programmers does it take to change a light bulb?\n" +
                    "A: none, that's a hardware problem",

            "If you put a million monkeys at a million keyboards, one of them will eventually write a Java program.\n" +
                    "\n" +
                    "The rest of them will write Perl programs.",
            "Q: \"Whats the object-oriented way to become wealthy?\"\n" +
                    "\n" +
                    "A: Inheritance"
    };

    public String getJoke() {
        Random random = new Random();
        return (jokeArray[random.nextInt(jokeArray.length)]);
    }

}
