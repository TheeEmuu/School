import structure.QueueList;
import structure.StackList;

public class Palindrome {
    private static Boolean isPalindrome(String str){
        QueueList forward = new QueueList();
        StackList backward = new StackList();
        str = str.toLowerCase();

        for(int i = 0; i < str.length(); i++){
            Character letter = str.charAt(i);

            forward.add(letter);
            backward.add(letter);
        }

        for(int i =0; i < str.length(); i++){
            Character fLetter = (Character)forward.remove();
            Character bLetter = (Character)backward.remove();

            if(fLetter != bLetter){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("hat"));
        System.out.println(isPalindrome("RaCeCAr"));
        System.out.println(isPalindrome("OraNgEs"));
    }
}
