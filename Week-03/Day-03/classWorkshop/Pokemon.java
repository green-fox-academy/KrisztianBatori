package classWorkshop;

public class Pokemon {
    String name;
    String type;
    String effectiveAgainst;

    public Pokemon (String newName, String newType, String newEffectiveness) {
        name = newName;
        type = newType;
        effectiveAgainst = newEffectiveness;
    }

    public boolean isEffectiveAgainst(Pokemon anotherPokemon) {
        return effectiveAgainst.equals(anotherPokemon.type);
    }
}
