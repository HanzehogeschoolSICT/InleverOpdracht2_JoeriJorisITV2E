package model;

public enum Word {
    NO_WORD("              No_word"),
    WORD_START("               Start"),
    WORD_COMPLETE("               Complete");

    private String str;

    Word(String str){ this.str = str;}

    @Override
    public String toString() { return str; }
}
