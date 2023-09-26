package common;

/**
 *
 * @author ASUS
 */
public class Normalize {

    public void normalize(StringBuilder s) {
        removeBlankSpace(s);
        lowerAll(s);
        addBlank(s);
        toUpper(s);
    }

    public void removeBlankSpace(StringBuilder s) {
        int current = -1;
        int count = 0;
        String matchStr = ".,:;";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isWhitespace(s.charAt(i))) {
                if (current == -1) {
                    current = i;
                }
            } else {
                if (current != -1) {
                    if (matchStr.contains(String.valueOf(s.charAt(current + 1)))) {
                        current++;
                    }
                    s.delete(i + 1, current);
                    current = -1;
                }
            }
        }
        int i = s.indexOf("\"");
        while (i >= 0) {
            count++;
            if (count == 1) {
                s.deleteCharAt(i + 1);
                i = s.indexOf("\"", i + 1);
            } else {
                count = 0;
                s.deleteCharAt(i - 1);
                i = s.indexOf("\"", i);
            }
        }
    }

    public void lowerAll(StringBuilder s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            s.setCharAt(i, Character.toLowerCase(c));
        }
    }

    public void toUpper(StringBuilder s) {
        if ("\"".contains(String.valueOf(s.charAt(0)))) {
            s.setCharAt(1, Character.toUpperCase(s.charAt(1)));
        } else {
            s.setCharAt(0, Character.toUpperCase(s.charAt(0)));
        }
        for (int i = 2; i < s.length(); i++) {
            if ('.' == (s.charAt(i - 2))) {
                s.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            }
        }
    }

    public void addBlank(StringBuilder s) {
        String matchStr = ".,:;";
        for (int i = 0; i < s.length() - 1; i++) {
            if (matchStr.contains(String.valueOf(s.charAt(i)))) {
                if (!Character.isWhitespace(s.charAt(i + 1))) {
                    s.insert(i + 1, ' ');
                }
            }
        }
        if (!s.toString().endsWith(".")) {
            s.append(".");
        }
    }
}
