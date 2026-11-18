import java.util.Scanner;
import java.util.ArrayList;

/**
 * Operation Nightfall
 * Final Project - Week 2
 *
 * Controls Mission Control, operator registration,
 * mission environments, and tactical team management.
 */
public class Game {

    private Scanner input;
    private Player player;
    private boolean running;
    private ArrayList<TacticalOperator> tacticalTeam;

    // Prepares the game and tactical team collection.
    public Game() {
        input = new Scanner(System.in);
        running = true;
        tacticalTeam = new ArrayList<>();
    }

    // Starts Mission Control and keeps the menu running.
    public void start() {
        Utils.printHeader("OPERATION NIGHTFALL - Mission Control");

        System.out.println("Welcome to Operation Nightfall!");
        System.out.println("Your mission begins with preparation.");
        System.out.println("Assemble your tactical team for deployment.");

        while (running) {
            displayMenu();

            int choice = Utils.readInt(input, "Enter your choice: ");

            switch (choice) {
                case 1:
                    createPlayer();
                    break;

                case 2:
                    chooseGameMode();
                    break;

                case 3:
                    viewPlayer();
                    break;

                case 4:
                    runPlaceholderAction();
                    break;

                case 5:
                    registerTacticalOperator();
                    break;

                case 6:
                    displayTacticalTeam();
                    break;

                case 7:
                    exitGame();
                    break;

                default:
                    System.out.println("Invalid selection. Choose a number from 1 to 7.");
            }
        }

        input.close();
    }

    // Displays the main mission control menu.
    private void displayMenu() {
        System.out.println();
        System.out.println("========== OPERATION NIGHTFALL ==========");
        System.out.println("          MISSION CONTROL CENTER");
        System.out.println("=========================================");
        System.out.println("1. Register Your Operator");
        System.out.println("2. Select Mission Environment");
        System.out.println("3. View Operator Profile");
        System.out.println("4. Begin Mission Briefing");
        System.out.println("5. Recruit Tactical Team Member");
        System.out.println("6. View Tactical Team Roster");
        System.out.println("7. Exit Mission Control");
        System.out.println("=========================================");
    }

    // Creates an operator profile for the player.
    private void createPlayer() {
        if (player != null) {
            System.out.println("An operator is already registered.");
            System.out.println("Return to Mission Control to continue.");
            return;
        }

        System.out.println();
        System.out.println("===== OPERATOR REGISTRATION =====");

        String name = Utils.readNonEmptyString(
            input, "Enter your operator name: "
        );

        player = new Player(name);

        System.out.println();
        System.out.println("Operator registration successful!");
        System.out.println("Welcome to Operation Nightfall, "
            + player.getName() + "!");
        System.out.println("Your mission file has been created.");
    }

    // Allows the operator to select a mission environment.
    private void chooseGameMode() {
        if (player == null) {
            System.out.println("Register your operator before selecting a mission.");
            return;
        }

        System.out.println();
        System.out.println("===== MISSION ENVIRONMENTS =====");
        System.out.println("1. Shadow Fortress - Fantasy Dungeon");
        System.out.println("2. Digital Warfare - Cyber Hacker");
        System.out.println("3. Orbital Recon - Space Explorer");

        int choice = Utils.readInt(
            input, "Select your mission environment: "
        );

        switch (choice) {
            case 1:
                player.setGameMode(GameMode.FANTASY_DUNGEON);
                break;

            case 2:
                player.setGameMode(GameMode.CYBER_HACKER);
                break;

            case 3:
                player.setGameMode(GameMode.SPACE_EXPLORER);
                break;

            default:
                System.out.println("Invalid mission environment.");
                return;
        }

        System.out.println();
        System.out.println("Mission environment confirmed!");
        System.out.println("Assigned environment: "
            + player.getGameMode().getDisplayName());
        System.out.println("Await further instructions from Mission Control.");
    }

    // Displays the current operator profile.
    private void viewPlayer() {
        if (player == null) {
            System.out.println("No operator registered.");
            System.out.println("Select Option 1 to create your profile.");
            return;
        }

        Utils.printHeader("OPERATOR PROFILE");

        System.out.println("Operator Name: " + player.getName());
        System.out.println("Operator Level: " + player.getLevel());

        System.out.println("Mission Environment: "
            + (player.getGameMode() == null
                ? "Not assigned"
                : player.getGameMode().getDisplayName()));

        System.out.println("Current Status: Awaiting Deployment");
        System.out.println("Assigned Team Members: " + tacticalTeam.size());
        System.out.println("=========================================");
    }

    // Provides the current mission briefing.
    private void runPlaceholderAction() {
        if (player == null) {
            System.out.println("You must register an operator first.");
            return;
        }

        System.out.println();
        System.out.println("========== MISSION BRIEFING ==========");
        System.out.println("Operator: " + player.getName());
        System.out.println();

        if (player.getGameMode() == null) {
            System.out.println("No mission environment has been selected.");
            System.out.println("Return to Mission Control and select Option 2.");
            return;
        }

        System.out.println("Mission Environment: "
            + player.getGameMode().getDisplayName());

        System.out.println();
        System.out.println("MISSION OBJECTIVE:");
        System.out.println("Prepare for deployment into your assigned environment.");
        System.out.println("Review your operator profile and await mission orders.");
        System.out.println("Tactical Team Strength: " + tacticalTeam.size());
        System.out.println();
        System.out.println("MISSION STATUS: PREPARATION PHASE");
        System.out.println("Additional missions will become available");
        System.out.println("as the project develops.");
        System.out.println("======================================");
    }

    // Creates a new tactical operator and adds it to the collection.
    private void registerTacticalOperator() {
        Utils.printHeader("TACTICAL TEAM RECRUITMENT");

        String callSign = Utils.readNonEmptyString(
            input, "Enter tactical call sign: "
        );

        String specialty = Utils.readNonEmptyString(
            input, "Enter operator specialty: "
        );

        int readinessLevel = Utils.readInt(
            input, "Enter readiness level (0-100): "
        );

        while (readinessLevel < 0 || readinessLevel > 100) {
            System.out.println("Readiness must be between 0 and 100.");

            readinessLevel = Utils.readInt(
                input, "Enter readiness level again: "
            );
        }

        String missionZone = Utils.readNonEmptyString(
            input, "Enter assigned mission zone: "
        );

        TacticalOperator recruit = new TacticalOperator(
            callSign, specialty, readinessLevel, missionZone
        );

        tacticalTeam.add(recruit);

        System.out.println();
        System.out.println("Recruitment successful!");
        System.out.println(callSign + " has joined Operation Nightfall.");
        System.out.println("Total team members: " + tacticalTeam.size());
    }

    // Displays every tactical operator stored in the ArrayList.
    private void displayTacticalTeam() {
        Utils.printHeader("TACTICAL TEAM ROSTER");

        if (tacticalTeam.isEmpty()) {
            System.out.println("No tactical operators have been recruited.");
            System.out.println("Select Option 5 to assemble your team.");
            return;
        }

        int totalReadiness = 0;

        for (TacticalOperator member : tacticalTeam) {
            member.displayOperator();
            totalReadiness += member.getReadinessLevel();
        }

        double averageReadiness =
            (double) totalReadiness / tacticalTeam.size();

        System.out.println("Total Operators: " + tacticalTeam.size());
        System.out.printf("Team Readiness Average: %.1f%%%n",
            averageReadiness);

        if (averageReadiness >= 80) {
            System.out.println("Team Status: Deployment Ready");
        } else {
            System.out.println("Team Status: Additional Training Required");
        }
    }

    // Safely ends the game loop.
    private void exitGame() {
        System.out.println();
        System.out.println("Closing Operation Nightfall...");
        System.out.println("Mission Control signing off.");
        System.out.println("Stay ready for your next assignment.");

        running = false;
    }
}
