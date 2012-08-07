package prep.ownimplementations;

public class BoyerMooreGood {
    private char[] pattern, textstring;       // pattern, text
    private int m_patternlen, n_textlen;          // pattern length, text length
    private static int alphabetsize=256;
    private int[] occ_BC;         // occurence function 
    private String matches;    // string of match positions
    private char[] showmatches;// char array that shows matches
	private int[] f;
	private int[] s;
    private static String name="Boyer-Moore";
	
	public BoyerMooreGood()
	{
		occ_BC=new int[alphabetsize];
	}

    public void search(String tt, String pp)
    {
        setText(tt);
        setPattern(pp);
        bmSearch();
    }
    
    /** sets the text
     */ 
    private void setText(String tt)
    {
        n_textlen=tt.length();
        textstring=tt.toCharArray();
        initmatches();
    }
    
    /** initializes match positions and the array showmatches
     */ 
    private void initmatches()
    {
        matches="";
        showmatches=new char[n_textlen];
        for (int i=0; i<n_textlen; i++)
            showmatches[i]=' ';
    }
    
    /** sets the pattern
     */ 
    public void setPattern(String pp)
    {
    	m_patternlen=pp.length();
        pattern=pp.toCharArray();
        f=new int[m_patternlen+1];
        s=new int[m_patternlen+1];
        bmPreprocess();
    }
   
    /** preprocessing according to the pattern
     */ 
	private void bmPreprocess()
	{
		bmInitocc();
		bmPreprocess1();
		bmPreprocess2();
	}

    /** computation of the occurrence function - BAD character
     */ 
	private void bmInitocc()
	{
	    char a;
		int j;

	    for (a=0; a<alphabetsize; a++)
	    	occ_BC[a]=-1;

	    for (j=0; j<m_patternlen; j++)
	    {
	        a=pattern[j];
	        occ_BC[a]=j; // overwrites if there is the same character. (that gives the right most value when iterating from left to right
	    }
	}
	
    /** preprocessing according to the pattern (part 1)
     */ 
	private void bmPreprocess1()
	{
		int i=m_patternlen, j=m_patternlen+1;
		f[i]=j;
		while (i>0)
		{
			while (j<=m_patternlen && pattern[i-1]!=pattern[j-1])
			{
				if (s[j]==0) s[j]=j-i;
				j=f[j];
			}
			i--; j--;
			f[i]=j;
		}
	}
	
    /** preprocessing according to the pattern (part 2)
     */ 
	private void bmPreprocess2()
	{
		int i, j;
		j=f[0];
		for (i=0; i<=m_patternlen; i++)
		{
			if (s[i]==0) s[i]=j;
			if (i==j) j=f[j];
		}
	}
	
   

    
    
    /** searches the text for all occurences of the pattern
     */ 
	private void bmSearch()
	{
	    int i=0, j;
	    while (i<=n_textlen-m_patternlen)
	    {
	        j=m_patternlen-1;
	        while (j>=0 && pattern[j]==textstring[i+j]) j--;
	        if (j<0)
			{
				report(i);
				i+=s[0];
			}
			else
				i+=Math.max(s[j+1], j-occ_BC[textstring[i+j]]);
	    }
	}
	
    /** reports a match
     */
    private void report(int i)
    {
        matches+=i+" ";
        showmatches[i]='^';
    }

    /** returns the match positions after the search
     */ 
    public String getMatches()
    {
        return matches;
    }

    // only for test purposes
    public static void main(String[] args)
    {
    	BoyerMooreGood stm=new BoyerMooreGood();
        System.out.println(name);
        String tt, pp;
        tt="abcdabcd";
        pp="abc";
        stm.search(tt, pp);
        System.out.println(pp);
        System.out.println(tt);
        System.out.println(stm.showmatches);
        System.out.println(stm.getMatches());
        tt="abababaa";
        pp="aba";
        stm.search(tt, pp);
        System.out.println(pp);
        System.out.println(tt);
        System.out.println(stm.showmatches);
        System.out.println(stm.getMatches());
    }
    	
	
}	// end class BmStringMatcher

