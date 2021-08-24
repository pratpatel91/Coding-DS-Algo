public class DP_FriendPairing
{
	static int waysToBeAlone;
	static int waysToPairFriends;
	static int[] recursiveCacheArray = new int[500];

	public static void main(String[] args)
	{
		int[] friends = { 1, 2, 3, 4 };
		System.out.println("friendPairing(4)=" + friendPairing(friends.length));
		System.out.println("memo_friendPairing(4)=" + memo_friendPairing(friends.length));
		System.out.println("tab_friendPairing(4)=" + tab_friendPairing(friends.length));
		System.out.println("alternative_tab_friendPairing(4)=" + tab_friendPairing(friends.length));
	}

	public static int friendPairing(int numFriends)
	{
		if (numFriends == 1 || numFriends == 2)
		{
			return numFriends;
		}

		if (numFriends > 2)
		{
			waysToBeAlone = friendPairing(numFriends - 1);
			// System.out.println("waysToBeAlone=" + waysToBeAlone);
			waysToPairFriends = friendPairing(numFriends - 2) * (numFriends - 1);
			// System.out.println("waysToPairFriends=" + waysToPairFriends);
		}
		return waysToBeAlone + waysToPairFriends;
	}

	public static int memo_friendPairing(int numFriends)
	{
		// ----------setting cache to -1 ---------------------//
		for (int i = 0; i <= recursiveCacheArray.length - 1; i++)
		{
			recursiveCacheArray[i] = -1;
		}

		// ------ Base Cases ------//
		if (numFriends == 1 || numFriends == 2)
		{
			return numFriends;
		}

		// ------ Filling out the rest of the cacheArray ------//
		if (numFriends > 2)
		{
			waysToBeAlone = memo_friendPairing(numFriends - 1);
			waysToPairFriends = memo_friendPairing(numFriends - 2) * (numFriends - 1);
			recursiveCacheArray[numFriends] = waysToBeAlone + waysToPairFriends;
			return recursiveCacheArray[numFriends];
		}
		// returning the last element in the cacheArray
		return recursiveCacheArray[numFriends];
	}

	public static int tab_friendPairing(int numFriends)
	{
		// creating the cacheArray
		int[] cacheArray = new int[numFriends + 1];

		// ------ Base Cases ------//
		cacheArray[0] = 0; // for 0 friends we can pair 0 way
		cacheArray[1] = 1; // for 1 friend we can pair 1 way
		cacheArray[2] = 2; // for 2 friends we can pair 2 ways

		// ------ Filling out the rest of the cacheArray ------//
		for (int friends = 3; friends <= numFriends; friends++)
		{
			cacheArray[friends] = cacheArray[friends - 1] + cacheArray[friends - 2] * (friends - 1);
		}

		// returning the last element in the cacheArray
		return cacheArray[numFriends];
	}

	public static int alternative_tab_friendPairing(int numFriends)
	{
		// creating the cacheArray
		int[] cacheArray = new int[numFriends + 1];

		for (int friends = 0; friends <= numFriends; friends++)
		{
			// ------ Base Cases ------//
			if (friends <= 2)
			{
				cacheArray[friends] = friends;
			}
			// ------ Filling out the rest of the cacheArray ------//
			else // if i > 2
			{
				cacheArray[friends] = cacheArray[friends - 1] + cacheArray[friends - 2] * (friends - 1);
			}
		}

		// returning the last element in the cacheArray
		return cacheArray[numFriends];
	}

}
