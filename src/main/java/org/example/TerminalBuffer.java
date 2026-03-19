package org.example;

public class TerminalBuffer {
    int width, height, maxScrollBack;
    Color foreground, background;
    Style style;
    Cell[][] cells;
    Cursor cursor;

    TerminalBuffer(int width, int height, int maxScrollBack, Color background, Color foreground, Style style)
    {
        this.width = width;
        this.height = height;
        this.maxScrollBack = maxScrollBack;
        this.foreground = foreground;
        this.background = background;
        this.style = new Style(style.bold, style.italic, style.underline);
        cells = new Cell[height + maxScrollBack][width];
        cursor = new Cursor();
    }

    TerminalBuffer(){
        this(80, 24, 1000,  Color.BLACK, Color.WHITE, new Style());
    }

    public int getCursorRow(){
        return cursor.i;
    }

    public int getCursorCollumn(){
        return cursor.j;
    }

    public void moveCursor(String direction, int NCells){
        switch (direction){
            case "left":
                // must check if it gets out of the box
                if(cursor.j - NCells < 0)
                    cursor.j = width - (cursor.j - NCells);
                else
                    cursor.j -= NCells;
                break;
            case "right":
                // must check if it gets out of the box
                if(cursor.j + NCells > width)
                    cursor.j = NCells - (width - cursor.j);
                else
                    cursor.j += NCells;
                break;
            case "up":
                if(cursor.i - NCells < 0)
                    // take line from scrollback or block the cursor depends what you want
                    cursor.i = 0;
                else
                    cursor.i -= NCells;
            case "down":
                if(cursor.i + NCells > height)
                    // take line from scrollback or block the cursor depends what you want
                    cursor.i = height;
                else
                    cursor.i += NCells;
        }
    }
}
