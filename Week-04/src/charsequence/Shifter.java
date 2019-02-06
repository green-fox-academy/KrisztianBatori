package charsequence;

class Shifter implements CharSequence {
    String string;
    int shifts;

    Shifter(String string, int shifts) {
        this.string = string;
        this.shifts = shifts;
    }

    private String getShiftedString() {
        String shiftedString = string;
        for (int i = 0; i < shifts; i++) {
            shiftedString = shiftedString.substring(1) + shiftedString.charAt(0);
        }
        return shiftedString;
    }

    @Override
    public char charAt(int index) {
        return getShiftedString().charAt(index);
    }

    @Override
    public int length() {
        return string.length();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return getShiftedString().subSequence(start, end);
    }

    @Override
    public String toString() {
        return getShiftedString();
    }
}
