package charsequence;

class Gnirts implements CharSequence {
    String string;

    Gnirts(String string) {
        this.string = string;
    }

    private String getReverseString() {
        return new StringBuilder(string).reverse().toString();
    }

    @Override
    public char charAt(int index) {
        return getReverseString().charAt(index);
    }

    @Override
    public int length() {
        return string.length();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return getReverseString().subSequence(start, end);
    }

    @Override
    public String toString() {
        return getReverseString();
    }
}
