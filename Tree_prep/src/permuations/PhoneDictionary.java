package permuations;

import java.util.ArrayList;


//still need to implement range phones - put phones and get phones.. and optimize
public class PhoneDictionary {

    static TrieNode createTree()
    {
        return(new TrieNode('\0', false));
    }
    
    static void insertWord(TrieNode root, String word)
    {
        int offset = 97; //ascii value of a - 97
        int l = word.length();
        char[] letters = word.toCharArray();
        TrieNode curNode = root;
        
        for (int i = 0; i < l; i++)
        {
            if (curNode.links[letters[i]-offset] == null)
                curNode.links[letters[i]-offset] = new TrieNode(letters[i], i == l-1 ? true : false);
            curNode = curNode.links[letters[i]-offset];
        }
    }

    static boolean find(TrieNode root, String word)
    {
        char[] letters = word.toCharArray();
        int l = letters.length;
        int offset = 97;
        TrieNode curNode = root;
        
        int i;
        for (i = 0; i < l; i++)
        {
            if (curNode == null)
                return false;
            curNode = curNode.links[letters[i]-offset];
        }
        
        if (i == l && curNode == null)
            return false;
        
        if (curNode != null && !curNode.fullWord)
            return false;
        
        return true;
    }
    
    static void printTree(TrieNode root, int level, char[] branch)
    {
        if (root == null)
            return;
        
        for (int i = 0; i < root.links.length; i++)
        {
            branch[level] = root.letter;
            printTree(root.links[i], level+1, branch);    
        }
        
        if (root.fullWord)
        {
            for (int j = 1; j <= level; j++)
                System.out.print(branch[j]);
            System.out.println();
        }
    }
    
    public static void main(String[] args)
    {
        TrieNode tree = createTree();
        
        String[] words = {"an", "ant", "all", "allot", "alloy", "aloe", "are", "ate", "be"};
        for (int i = 0; i < words.length; i++)
            insertWord(tree, words[i]);
        
        char[] branch = new char[50];
        printTree(tree, 0, branch);
        
        String searchWord = "all";
        if (find(tree, searchWord))
        {
            System.out.println("The word was found");
        }
        else
        {
            System.out.println("The word was NOT found");
        }
    }
}

class TrieNode
{
    char letter;
    TrieNode[] links;
    boolean fullWord;
    ArrayList<String> phonenums = new ArrayList<String>();
    
    TrieNode(char letter, boolean fullWord, String phonenum)
    {
        this.letter = letter;
        links = new TrieNode[26];
        this.fullWord = fullWord;
        phonenums.add(phonenum);
    }
    
    TrieNode(char letter, boolean fullWord)
    {
        this.letter = letter;
        links = new TrieNode[26];
        this.fullWord = fullWord;
    }
    
    public void addPhonenum(String phone){
    	this.phonenums.add(phone);
    }
    
    public ArrayList<String> getPhonenums(){
    	return this.phonenums;
    }
}

/*
 * Algorithms for inserting a a word into a Trie:

1. Set current node to root node. The root node does not contain any letter (initialized to the null character for convenience).
2. Set the current letter to the first letter in the word. 
3. If the current node already has an existing reference to the current letter (through one of the elements in the "links" field) then set current node to that referenced node; else create a new node, set the letter to current letter, and set current node to this new node.
4. Repeat step 3 until all letters in the current word has been processed.

Algorithm for searching for a word in the Trie:

1. Set current node to root node. Set the current letter to the first letter in the word. 
2. If the current node is null then the word does not exist in the Trie.
3. If the current node reference to a valid node containing the current letter then set current node to that referenced node and set current letter to the letter in the new current node.
4. Repeat steps 2 and 3 until all letters in the word has been processed.
5. Now there are two possibilities that may indicate the letter is not there in the tree: a) the current letter is the last letter and there is no valid node containing this letter, and b) there is a valid node containing the last letter but the node does not indicate it contains a full word (marked with the "fullWord" boolean field.
6. If step the conditions in step 5 are not met, then we have a match for the word in the Trie.


The following are the main advantages of tries over binary search trees (BSTs):
Looking up keys is faster. Looking up a key of length m takes worst case O(m) time. A BST performs O(log(n)) comparisons of keys, where n is the number of elements in the tree, because lookups depend on the depth of the tree, which is logarithmic in the number of keys if the tree is balanced. Hence in the worst case, a BST takes O(m log n) time. Moreover, in the worst case log(n) will approach m. Also, the simple operations tries use during lookup, such as array indexing using a character, are fast on real machines.
Tries are more space-efficient when they contain a large number of short keys, since nodes are shared between keys with common initial subsequences.
Tries facilitate longest-prefix matching.
The number of internal nodes from root to leaf equals the length of the key. Balancing the tree is therefore of no concern.
The following are the main advantages of tries over hash tables:
Tries support ordered iteration, whereas iteration over a hash table will result in a pseudorandom order given by the hash function (and further affected by the order of hash collisions, which is determined by the implementation).
Tries facilitate longest-prefix matching, but hashing does not, as a consequence of the above. Performing such a "closest fit" find can, depending on implementation, be as quick as an exact find.
Tries tend to be faster on average at insertion than hash tables because hash tables must rebuild their index when it becomes full - a very expensive operation. Tries therefore have much better bounded worst-case time costs, which is important for latency-sensitive programs.
Since no hash function is used, tries are generally faster than hash tables for small keys.


As mentioned, a trie has a number of advantages over binary search trees.[4] A trie can also be used to replace a hash table, over which it has the following advantages:
Looking up data in a trie is faster in the worst case, O(m) time, compared to an imperfect hash table. An imperfect hash table can have key collisions. A key collision is the hash function mapping of different keys to the same position in a hash table. The worst-case lookup speed in an imperfect hash table is O(N) time, but far more typically is O(1), with O(m) time spent evaluating the hash.
There are no collisions of different keys in a trie.
Buckets in a trie which are analogous to hash table buckets that store key collisions are necessary only if a single key is associated with more than one value.
There is no need to provide a hash function or to change hash functions as more keys are added to a trie.
A trie can provide an alphabetical ordering of the entries by key.
Tries do have some drawbacks as well:
Tries can be slower in some cases than hash tables for looking up data, especially if the data is directly accessed on a hard disk drive or some other secondary storage device where the random-access time is high compared to main memory.[5]
Some keys, such as floating point numbers, can lead to long chains and prefixes that are not particularly meaningful. Nevertheless a bitwise trie can handle standard IEEE single and double format floating point numbers.
 */