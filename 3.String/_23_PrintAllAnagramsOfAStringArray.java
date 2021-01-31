

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class _23_PrintAllAnagramsOfAStringArray 
{

	public static void main(String[] args) 
	{
		String[] words = { "act", "god", "cat", "dog", "tac" };
		printAllAnagramsOfAStringArray(words);
	}
	//Tc=O(n)
	//Sc=O(# of keys * Grouped anagrams)
	//worst case # of keys =length of array and # of cols=length of array so SC = O(n)
	public static void printAllAnagramsOfAStringArray(String[] words) 
	{
		//---------------------------------------populating the hashmap--------------------------//
		//key = string
		//value = list of string
		//creating the hashmap
		HashMap<String, List<String>> hashMap = new HashMap<>();
		
		//INTERFACE=IMPLEMENTATION CLASS
		List<List<String>> listOfLists = new ArrayList<>();
		
		
		// iterating the string array (populating the hashmap)
		for (int i = 0; i <= words.length - 1; i++) 
		{
			char[] wordsArray = new char[words[i].length()]; //creating an empty char array
			wordsArray = words[i].toCharArray(); // storing the string arrays element into a char array
			Arrays.sort(wordsArray); // sorting the char array (aka sorting the string element)

			String key = new String(wordsArray); // converted the sorted char array back into a string
		
			System.out.println("current key:" + key + ", current word:" + words[i]);
			
			if(hashMap.containsKey(key))
			{
				System.out.println("current key "+ key+" is present in the hashmap"+ ", current word:" + words[i]);
				hashMap.get(key).add(words[i]);
			}
			else //key isnt in the hashmap
			{
				System.out.println("current key " + key + " isnt present in the hashmap"+ ", current word:" + words[i]);
				List<String> groupedAnagrams = new ArrayList<>();
				groupedAnagrams.add(words[i]);//adding current word into the list
				hashMap.put(key,groupedAnagrams);//
				System.out.println("key:" + key + ", values:" + groupedAnagrams.toString());
			}
		}

		//---------------------------------------printing answer--------------------------//
		//iterating the hashmap
		for (Map.Entry<String, List<String>> element : hashMap.entrySet()) 
		{
			System.out.println("key:"+ element.getKey() + ", value:" + element.getValue().toString());
			listOfLists.add(element.getValue());
		}
	
	}

//	public static HashMap<String, Integer> hashMapGenerator(String[] words) 
//	{
//		// hashMap is part of Collection (can store negative values)
//		// hashMap uses datastructure (red-black trees)
//		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
//
//		// iterating the string array (populating the hashmap)
//		for (int i = 0; i <= words.length - 1; i++) 
//		{
//			char[] wordsArray = new char[words[i].length()]; //creating an empty char array
//			wordsArray = words[i].toCharArray(); // storing the string arrays element into a char array
//			Arrays.sort(wordsArray); // sorting the char array (aka sorting the string element)
//			String key = new String(wordsArray); // converted the sorted char array back into a string
//
//			//if the key is already in the hashMap then put it into the hash map and increase the existing value by 1
//			if (hashMap.containsKey(key)) 
//			{
//				int value = hashMap.get(key);//find the value linked to the key
//				hashMap.put(key, value + 1); 
//			} 
//			else // if the key is not in the hashMap then put it into the hash map and set the value to 1
//			{
//				hashMap.put(key, 1);
//			}
//		}
//
//		System.out.println("printing the hash map (MUST use an iterator (named element here)");
//		System.out.println("HashMap Entry Set: " + hashMap.entrySet());
//		for (Map.Entry element : hashMap.entrySet()) 
//		{
//			System.out.println("Key: " + element.getKey() + ", Value: " + element.getValue());
//		}
//
//		// creating object arrays because object arrays are mutuable
//		Object[] hashMapKeys = hashMap.keySet().toArray();
//		Object[] hashMapValues = hashMap.values().toArray();
//
//		//TC = O(n logn) due to sorting
//		Arrays.sort(hashMapKeys);// ascending order 
//		Arrays.sort(hashMapValues);// ascending order 
//
//		//TC=O(n) due to iterating a for loop
//		System.out.println("\nprinting the sorted hashMap Keys");
//		for (int i = 0; i <= hashMapKeys.length - 1; i++) 
//		{
//			System.out.print(hashMapKeys[i] + " ");
//		}
//
//		//TC=O(n) due to iterating a for loop
//		System.out.println("\n\nprinting the sorted hashMap Values");
//		for (int i = 0; i <= hashMapValues.length - 1; i++) 
//		{
//			System.out.print(hashMapValues[i] + " ");
//		}
//		return hashMap;
//	}

//	public static String[] anagram(String hashMapKeys, String[] words)
//	{
//		String[] answer = new String[words.length];
//
//		// iterating the string array
//		for (int i = 0; i <= words.length - 1; i++) 
//		{
//			char[] wordsArray = new char[words[i].length()];
//			wordsArray = words[i].toCharArray(); // storing current string into word array
//			Arrays.sort(wordsArray);
//			String currentWord = new String(wordsArray); // converted char array into string
//			
//			//if the hashmap keys are mismatching then the string is not an anagram
//			if (currentWord == hashMapKeys) 
//			{
//				answer[i] = currentWord;
//			}
//		}
//		return answer;
//	}
}
