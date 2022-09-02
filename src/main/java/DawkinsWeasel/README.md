# Dawkins' Weasel

In his book The Blind Watchmaker, Richard Dawkins says:

> I don’t know who it was first pointed out that, given enough time, a monkey bashing away at random on a typewriter could produce all the works of Shakespeare. The operative phrase is, of course, given enough time. Let us limit the task facing our monkey somewhat. Suppose that he has to produce, not the complete works of Shakespeare but just the short sentence ‘Methinks it is like a weasel’, and we shall make it relatively easy by giving him a typewriter with a restricted keyboard, one with just the 26 (capital) letters, and a space bar. How long will he take to write this one little sentence?

(All of our quotes are shamelessly stolen from Wikipedia.) Then Dawkins suggests that this is a bad analogy for evolution, and proposes this alternative:

> We again use our computer monkey, but with a crucial difference in its program. It again begins by choosing a random sequence of 28 letters, just as before … it duplicates it repeatedly, but with a certain chance of random error – ‘mutation’ – in the copying. The computer examines the mutant nonsense phrases, the ‘progeny’ of the original phrase, and chooses the one which, however slightly, most resembles the target phrase, METHINKS IT IS LIKE A WEASEL.

Then he discusses a computer program that simulates his monkey, which he says took half an hour to run because it was written BASIC; when he rewrote his program in Pascal the runtime dropped to eleven seconds. His program used this algorithm:

1. Start with a random string of 28 characters
2. Make 100 copies of the string (reproduce)
3. For each character in each of the 100 copies, with a probability of 5%, replace (mutate) the character with a new random character
4. Compare each new string with the target string “METHINKS IT IS LIKE A WEASEL”, and give each a score (the number of letters in the string that are correct and in the correct position)
5. If any of the new strings has a perfect score (28), halt. Otherwise, take the highest scoring string, and go to step 2

Your task is to write a program to simulate Dawkins’ monkey. When you are finished, you are welcome to read or run a suggested solution, or to post your own solution or discuss the exercise in the comments below.

https://programmingpraxis.com/2014/11/14/dawkins-weasel/