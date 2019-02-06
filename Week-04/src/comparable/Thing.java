package comparable;

class Thing implements Comparable<Thing> {
    private String name;
    public boolean completed;

    public Thing(String name) {
        this.name = name;
    }

    public void complete() {
        this.completed = true;
    }

    @Override
    public int compareTo(Thing o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + name;
    }
}
