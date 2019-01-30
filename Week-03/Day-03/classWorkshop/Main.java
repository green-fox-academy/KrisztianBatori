package classWorkshop;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        // 01 - Post it
        PostIt object1 = new PostIt(Color.ORANGE, "Idea 1", Color.BLUE);
        PostIt object2 = new PostIt(Color.PINK, "Awesome", Color.BLACK);
        PostIt object3 = new PostIt(Color.YELLOW, "Superb", Color.GREEN);

        // 02 - Blog post
        BlogPost post1 = new BlogPost(
                "John Doe",
                "Lorem Ipsum",
                "Lorem ipsum dolor sit amet.",
                new Date(2000, 5, 4));

        BlogPost post2 = new BlogPost("Tim Urban",
                "Wait but why",
                "A popular long-form, stick-figure-illustrated blog about almost everything.",
                new Date(2010, 10, 10));

        BlogPost post3 = new BlogPost("William Turton",
                "One Engineer Is Trying to Get IBM to Reckon With Trump",
                "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention." +
                        "When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t" +
                        "really into the whole organizer profile thing.",
                new Date(2017, 3, 28));

        // 03 - Animal
        Animal dog = new Animal();

        // 04 - Sharpie
        Sharpie obj1 = new Sharpie("red", 0.1544465f);

        // 05 - Counter
        Counter number = new Counter();

        // 06 - Pokemon
        List<Pokemon> pokemonOfAsh = initializePokemons();

        Pokemon wildPokemon = new Pokemon("Oddish", "leaf", "water");

        for (Pokemon pokemon: pokemonOfAsh) {
            if (pokemon.isEffectiveAgainst(wildPokemon)) {
                System.out.print("I choose you, " + pokemon.name + "!");
                System.out.println();
                break;
            }
        }

        // 07 - Fleet of things
        // main() is at FleetOfThings

        // 08 - Dice set
        DiceSet diceSet = new DiceSet();
        diceSet.roll();

        while (!diceSet.getCurrent().equals(new ArrayList<Integer>() {{ for (int i = 0; i < 6; i++) { add(6); } }}))
        {
            if (!diceSet.getCurrent().contains(6)) {
                diceSet.reroll();
            }
            else {
                for (int i = 0; i < diceSet.getCurrent().size(); i++) {
                    if (diceSet.getCurrent(i) != 6) {
                        diceSet.reroll(i);
                        break;
                    }
                }
            }
        }
        System.out.println(diceSet.getCurrent());

        // 09 - Dominoes
        Dominoes domino = new Dominoes();
        domino.printDominoes();
        domino.reorderDominoes();
        System.out.println();
        domino.printDominoes();
        System.out.println();

        // 10 - Teacher student
        // Teacher, Student classes

        // 11 - Petrol station
        // Car, Station classes

        // 12 - SharpieSet
        SharpieSet sharpies = new SharpieSet(new ArrayList<>() {{
                add(new Sharpie("Green", 5.213f));
                add(new Sharpie("Red", 6.345f));
                add(new Sharpie("Gray", 1.324f));
                add(new Sharpie("Black", 4.2134f));
                add(new Sharpie("Yellow", 7.435345f));
            }});

        // 13 - Farm
        Farm farm = new Farm(new ArrayList<>() {{
            add(new Animal());
            add(new Animal());
            add(new Animal());
            add(new Animal());
            add(new Animal());
            add(new Animal());
            add(new Animal());
        }});

        // 14 - Blog
        Blog blogPosts = new Blog(new ArrayList<>() {{
            add(new BlogPost("Boss", "Attention", "Important stuff", new Date(2019, 9, 1)));
            add(new BlogPost("King", "Servants!", "Not important stuff", new Date(1433, 12, 31)));
            add(new BlogPost("HR", "Important!", "Stuff", new Date(2019, 1, 2)));
        }});

        // +1 - 5 trees
        ArrayList<Tree> trees = new ArrayList<>() {{
            add(new Tree("Yellow Birch", Color.YELLOW, 12, "Male"));
            add(new Tree("Mopane", Color.GREEN, 23, "Female"));
            add(new Tree("Olive", Color.PINK, 5, "Female"));
            add(new Tree("Black walnut", Color.BLACK, 8, "Male"));
            add(new Tree("Gymea Lily", Color.RED, 44, "Male"));
        }};
    }

    private static List<Pokemon> initializePokemons() {
        List<Pokemon> pokemon = new ArrayList<>();

        pokemon.add(new Pokemon("Balbasaur", "leaf", "water"));
        pokemon.add(new Pokemon("Pikatchu", "electric", "water"));
        pokemon.add(new Pokemon("Charizard", "fire", "leaf"));
        pokemon.add(new Pokemon("Balbasaur", "water", "fire"));
        pokemon.add(new Pokemon("Kingler", "water", "fire"));

        return pokemon;
    }
}
