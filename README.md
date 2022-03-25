# Probablity-and-Statistics
Contains Probability and Statistic Java classes 

Branchs:
 - Main
      Contains:
    - **README.md** - Location of desired code
    - **Project Two.docx** - Description of the project
    - **Stats Formulas.docx** - Formulas from textbook
    - **Graphs.xlsx** - Graphs for the datawriting programs

 - DataWriting
      Contains:
    - **Plotter.java** - Creates a csv file with the x,y values for function y = x^2
    - **GraphSalter.java** - Accepts the csv file of Plotter.java and salts the data
    - **GraphSmoother.java** - Accepts the csv file of GraphSmoother and smooths the data
    - **PlotTester.java** - Runs all three previous java files
    - **Graphs.xlsx** - Graph of the resulting csv data from Plotter,GraphSalter, and GraphSmoother.java
    - **RegularData.csv** - File created by Plotter.java
    - **SalterData.csv** - File created by GraphSalter.java
    - **SmootherData.csv** - File created by GraphSmoother.java
 - Distributions
      Contains:
    - **BinomialDistribution.java** - Binomial probability distribution calculator
    - **DistributionTester.java** - Tests all the distributions in the branch
    - **Distributions Screenshot.jpg** - Screenshot of the results after running each distribution calculator
    - **FactorialSolver.java** - Helper class for certain distribution classes that require factorial
    - **GeometricDistribution.java** - Geometric probability distribution calculator
    - **HypergeometricDistribution.java** - Hypergeometric probability distribution calculator
    - **PoissonDistribution.java** - Poisson probability distribution calculator
    - **TchebysheffTheorem.java** - Finds the probablity in which data is likely to fall within a 
                                certain number of standard deviations
                                
 - PokerHand
      Contains:
    - **Card.java** - A pseudo card that contains a number and suite
    - **CardDeckTester.java** - Tests HandEvaulator.java hand checks 10,000 times
    - **Deck.java** - A pseudo deck that contains 52 cards
    - **HandEvaluator.java** - Evaluates a pseudo poker hand for several poker hands 
                           (Checks pair, two pairs, Three of a kind, Straight, Full House, Flush, Four of a Kind)
    - **PokerHand Screenshot.jpg - Screenshot of the results after shuffling a hand 10,000 times

 - ProjectOne
      Contains: Code from **ProjectOne** 
    - **BirthdayProgram.java** - Stores the number of people and runs to be done to check birthdays
    - **MeanMedianModeStandDevVariance.java** - Mean, Median, Mode, Standard Deviation and Variance calculator
    - **MonteCarloSimulation.java** - Simulates the Monte Hall Game and can run it multiple times
    - **PermutationsAndCombinations.java** - A permutations and and combinations calculator
    - **Person.java** - Evaluates a given group size the probability of two people sharing the same birthday
    - **SetOperations.java** - A set operations calculator
    - **TestOne.java** - Tests MeanMedianModeStandDevVariance.java, PermutationsAndCombinations.java and SetOperations.java
    - **TestTwo.java** - Tests WriteData.java, Person.java, MonteCarloSimulation.java
    - **WriteData.java** - Creates a csv file that has 1000 people's favorite number
                           Left side number 1 - 1000 | Right side a random number 1-1000

