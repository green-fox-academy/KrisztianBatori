package comparable;

public class FleetOfThings {
    public static void main(String[] args) {
        Fleet fleet = new Fleet();
        // Create a fleet of things to have this output:
        // 1. [ ] Get milk
        // 2. [ ] Remove the obstacles
        // 3. [x] Stand up
        // 4. [x] Eat lunch

        fleet.add(new Thing("Get milk"));
        fleet.add(new Thing("Remove the obstacles"));
        fleet.add(new Thing("Stand up") {{ this.complete(); }} );
        fleet.add(new Thing("Eat lunch") {{ this.complete(); }} );

        System.out.println(fleet);
    }
}
