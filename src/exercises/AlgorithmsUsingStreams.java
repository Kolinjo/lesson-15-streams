package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AlgorithmsUsingStreams {

	public static long countGoodEggs(List<String> eggs) {
		return eggs.stream()				// 1. create stream
		.filter(egg -> egg.equals("whole")) // 2. intermediate filter operation
		.count();							// 3. terminal operation: reduce to an int
	}

	public static Object findTallest(List<Double> peeps) {
//		return Collections.max(peeps);
		return peeps.stream().sorted(Comparator.reverseOrder()).findFirst().get();
	}

	public static long addStringOfNumbers(String numbers) {
		return numbers
		 	.chars()		
		 	.mapToObj(c -> Character.toString(c))	
			.mapToInt(num -> Integer.parseInt(num))
			.sum();
	}
	
	public static long countPearls(List<Boolean> oysters) {

		Predicate<? super Boolean> hasPearl = oyster -> oyster.booleanValue() == true;
		return oysters.stream().filter(hasPearl).count();
	}

	public static String findLongestWord(List<String> words) {

		return words.stream().max(Comparator.comparingInt(String::length)).get();
	}
	public static List<Double> sortScores(List<Double> results) {

		return results.stream().sorted().collect(Collectors.toList());
	}
	
	public static List<String> sortDNA(List<String> unsortedSequences) {

		return unsortedSequences.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
	}
	
	public static List<String> sortWords(List<String> words) {

		return words.stream().sorted().collect(Collectors.toList());

	}
	
	public static List<String> getDistinctSpellsInAlphabeticalOrder(List<String> spellsCastThisWeek) {

		return spellsCastThisWeek.stream().distinct().sorted().collect(Collectors.toList());

	}
	
	public static List<String> getBatPhrases(String[] batmanScript) {

		List<String> list = Arrays.asList(batmanScript);

		return list.stream().map(x -> x.replace(" ", "")).filter(x -> x.equalsIgnoreCase("bam") || x.equalsIgnoreCase("pow")).map(String::toUpperCase).collect(Collectors.toList());
	}
	
	public static long countXs(String xString) {

		return xString.chars().filter(x -> x == 'x' || x == 'X').count();
	}
	
	public static int addEven(String string) {

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < string.length(); i++) {

			list.add(Character.getNumericValue(string.charAt(i)));

		}
		return list.stream().filter(n -> n % 2 == 0).mapToInt(x -> x).sum();
	}
	
	public static double getAverage(int[] numbers) {

		return Arrays.stream(numbers).average().getAsDouble();

	}
	
	public static long countOccurrences(String[] strArr, String string) {

		return Arrays.stream(strArr).filter(x -> x.equalsIgnoreCase(string)).count();
	}
}
