public class BOOYAH {
    public static void main(String[] args){
        String filename = "";
        String fileContents = "";
        String commonWord = "";
        String replacement = "";

        //open text file and read contents
        fileContents = openTextFile(filename);

        //Find the most used word
        commonWord = commonWord(fileContents);

        //Replace most used word with "BOOYAH"
        fileContents = replaceWithWord(fileContents, commonWord, replacement);

        //Output fileContents
    }

    //Opens and reads the text file
    //Returns the text of the file
    static String openTextFile(String filename){
        String fileContents = "";
        return fileContents;
    }

    //Finds the most common word in the fileContents
    static String commonWord(String fileContents){
        String commonWord;
        //alphabetize fileContents

        //loop through alphabetized list and find most common word
        //if word's frequency is higher than the previous record, it is the new commonWord
        return commonWord = "";
    }
    //Finds every instance of commonWord in fileContents and replace it with replacementWord
    static String replaceWithWord(String fileContents, String commonWord, String replacementWord){
        //loop until end of fileContents
        //replace commonWord with replacementWord
        return fileContents;
    }
}
