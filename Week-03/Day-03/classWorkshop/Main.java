package classWorkshop;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

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
