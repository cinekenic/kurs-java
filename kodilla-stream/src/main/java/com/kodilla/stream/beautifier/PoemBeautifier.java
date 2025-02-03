package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String poem, PoemDecorator decorator) {
        String res = decorator.decorate(poem);
        System.out.println("Decorated text: " + res);
    }
}
