package org.example;

public class TerminalBuffer {
    int width, height, maxScrollBack;
    Color foreground, background;
    Style style;
    Cell[][] cells;

    TerminalBuffer(int width, int height, int maxScrollBack, Color background, Color foreground, Style style)
    {
        this.width = width;
        this.height = height;
        this.maxScrollBack = maxScrollBack;
        this.foreground = foreground;
        this.background = background;
        this.style = new Style(style.bold, style.italic, style.underline);
        cells = new Cell[height + maxScrollBack][width];
    }

    TerminalBuffer(){
        this(80, 24, 1000,  Color.BLACK, Color.WHITE, new Style());
    }


}
