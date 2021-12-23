package interpreter;

import java.util.StringTokenizer;

public class Context {
    private StringTokenizer tokenizer;
    private String currentToken;

    public Context(String text) {
        tokenizer = new StringTokenizer(text);
        nextToken();
    }

    /**
     * 将下一个 token 置为当前 token
     */
    public String nextToken() {
        if (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
        } else {
            currentToken = null;
        }
        return currentToken;
    }

    public String currentToken() {
        return currentToken;
    }

    /**
     * 检查当前的 token ,检查通过将下一个 token 置为当前 token ，检查不通过则抛出异常
     */
    public void skipToken(String token) throws ParseException {
        if (!token.equals(currentToken)) {
            throw new ParseException("Warning: " + token + " is expected, but "
                    + currentToken + " is found.");
        }
        nextToken();
    }

    public int currentNumber() throws ParseException {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        } catch (NumberFormatException e) {
            throw new ParseException("Warning: " + e);
        }
        return number;
    }
}
