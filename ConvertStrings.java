class ConvertStrings {
	
	static boolean checkString(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
	
		boolean dp[][] = new boolean[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				dp[i][j] = false;
			}
		}
		dp[0][0] = true;
	
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (dp[i][j]) {
					if (j < s2.length() && Character.toUpperCase(s1.charAt(i)) == s2.charAt(j))
						dp[i + 1][j + 1] = true;
					if (!Character.isUpperCase(s1.charAt(i)))
						dp[i + 1][j] = true;
				}
			}
		}
	
		return dp[n][m];
	}
	
	public static void main(String[] args) {
		String s1 = "daBcd";
		String s2 = "ABC";
	
		if (checkString(s1, s2))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
