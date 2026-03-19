package org.example;

public class Style {
    boolean bold, italic, underline;

    Style(boolean bold, boolean italic, boolean underline)
    {
        this.bold = bold;
        this.underline = underline;
        this.italic = italic;
    }

    Style(){
        this(false, false, false);
    }


}
