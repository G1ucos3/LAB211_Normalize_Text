package model;

/**
 *
 * @author ASUS
 */
public class Text {
    StringBuilder para = new StringBuilder();

    public Text() {
    }

    public StringBuilder getText() {
        return para;
    }

    public void setText(StringBuilder text) {
        this.para = text;
    }
}
