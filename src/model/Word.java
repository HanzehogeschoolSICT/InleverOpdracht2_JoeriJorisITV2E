package model;

public enum Word {
    NO_WORD(""),
    WORD_START("S"),
    WORD_COMPLETE("C");

    private String str;

    Word(String str){ this.str = str;}

    @Override
    public String toString() { return str; }

}
