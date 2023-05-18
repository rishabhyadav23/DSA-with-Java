public class Impelement{

    class TrieNode{
        char data;
        TrieNode arr[] = new TrieNode[26];
        boolean isTerminal;
    
        TrieNode(char ch){
            this.data = ch;
            for(int i=0;i<26;i++){
                arr[i] = null;
            }
            isTerminal = false;
        }
    }

    TrieNode root;
    Impelement(){
        root = new TrieNode('\0');
    }
    void insertUtil (TrieNode root , String word){
        if(word.length()==0){
            root.isTerminal = true;
            return;
        }
        int index = word.charAt(0) - 'A';
        TrieNode child;

        if(root.arr[index] != null)child = root.arr[index];  
        else{
            child = new TrieNode(word.charAt(0));
            root.arr[index] = child;
        }
        insertUtil(child, word.substring(1,word.length()));
    }
    void insertWord (String word){
        insertUtil(root, word);
    }

    boolean searchUtil(TrieNode root,String word){
        if(word.length()==0){
            return root.isTerminal;
        }
        int index = word.charAt(0) - 'A';
        TrieNode child;

        if(root.arr[index] != null)child = root.arr[index]; 

        return false;
    }
    boolean search(String word){
        return searchUtil(root, word);
    }
    public static void main(String[] args) {
        Impelement t = new Impelement();
        t.insertWord("ARM");
        t.insertWord("DO");
        t.insertWord("TIME");

        System.out.println(t.search("TIME"));
    }
}