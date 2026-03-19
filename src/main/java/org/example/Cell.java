package org.example;

public class Cell {
    char character;
    Color foreground, background;
    Style style;

    Cell (char character, Color foreground, Color background, Style style)
    {
        this.character = character;
        this.foreground = foreground;
        this.background = background;
        this.style = new Style(style.bold, style.italic, style.underline);
    }

    Cell (){
        this(' ', Color.WHITE, Color.BLACK, new Style());
    }
}
