public class ReplaceWord {
    public static void main(String[] args) {
        String sentence = "Java is fun and Java is powerful.";
        String oldWord = "Java";
        String newWord = "Python";
        
        String result = replaceWord(sentence, oldWord, newWord);
        System.out.println("Modified Sentence: " + result);
    }

    public static String replaceWord(String sentence, String oldWord, String newWord) {
        return sentence.replace(oldWord, newWord);
    }
}
