public class RemoveCharacter {
    public static void main(String[] args) {
        String input = "Hello World";
        char charToRemove = 'l';
        
        String result = removeCharacter(input, charToRemove);
        System.out.println("Modified String: " + result);
    }

    public static String removeCharacter(String str, char charToRemove) {
        StringBuilder modifiedStr = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar != charToRemove) {
                modifiedStr.append(currentChar);
            }
        }
        
        return modifiedStr.toString();
    }
}
