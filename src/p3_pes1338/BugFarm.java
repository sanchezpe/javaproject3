package p3_pes1338;

import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class BugFarm {

    private int initialNumbeOfBugs = 0;
    private int initialNumberOfFemaleBugs = 0;
    private int initialNumberOfMaleBugs = 0;

    private int timesBugsMove = 0;
    private String fileNamePrintReport = "report.txt";
    private ArrayList<Bug> bugs = new ArrayList<Bug>();

    public BugFarm(int numberOfBugsIn, int upperBoundXIn, int upperBoundYIn, int timesBugsMoveIn, String fileNamePrintReportOut) {
        initialNumbeOfBugs = numberOfBugsIn;

        for (int i = 0; i < initialNumbeOfBugs; i++) {
            bugs.add(new Bug(upperBoundXIn, upperBoundYIn));
        }
        initialNumberOfFemaleBugs = this.countFemale();
        initialNumberOfMaleBugs = this.countMale();

        timesBugsMove = timesBugsMoveIn;
        fileNamePrintReport = fileNamePrintReportOut + ".txt";
    }

    public void startSimulation() {
        for (int i = 0; i < timesBugsMove; i++) {
            for (Bug bug : bugs) {
                bug.moveAtRandom();
            }
            this.checkBugsPosition();
        }
    }

    public void checkBugsPosition() {
        for (int i = 0; i < bugs.size(); i++) {
            for (int j = 0; j < bugs.size(); j++) {
                if (i != j && bugs.get(i).compareTo(bugs.get(j)) == 0) {
                    this.fight(bugs.get(i), bugs.get(j));
                    this.mate(bugs.get(i), bugs.get(j));
                }
            }
        }
    }

    public void fight(Bug bugA, Bug bugB) {
        if (bugA.getIsAlive() && bugB.getIsAlive()
                && bugA.getGender() == bugB.getGender()) {
            if (Math.random() >= .5) {
                bugA.setIsAlive(false);
            } else {
                bugB.setIsAlive(false);
            }
        }
    }

    public void mate(Bug bugA, Bug bugB) {
        if (bugA.getIsAlive() && bugB.getIsAlive()
                && bugA.getGender() != bugB.getGender()) {
            bugs.add(new Bug(bugA.getMaxX(), bugA.getMaxY()));
        }
    }

    public int countFemale() {
        int count = 0;
        for (Bug bug : bugs) {
            if (bug.getGender() == 0) {
                count++;
            }
        }
        return count;
    }

    public int countMale() {
        int count = 0;
        for (Bug bug : bugs) {
            if (bug.getGender() == 1) {
                count++;
            }
        }
        return count;
    }

    public int countFemaleAlive() {
        int count = 0;
        for (Bug bug : bugs) {
            if (bug.getIsAlive() && bug.getGender() == 0) {
                count++;
            }

        }
        return count;
    }

    public int countMaleAlive() {
        int count = 0;
        for (Bug bug : bugs) {
            if (bug.getIsAlive() && bug.getGender() == 1) {
                count++;
            }
        }
        return count;
    }

    public int countFemaleDead() {
        int count = 0;
        for (Bug bug : bugs) {
            if (bug.getIsAlive() == false && bug.getGender() == 0) {
                count++;
            }
        }
        return count;
    }

    public int countMaleDead() {
        int count = 0;
        for (Bug bug : bugs) {
            if (bug.getIsAlive() == false && bug.getGender() == 1) {
                count++;
            }
        }
        return count;
    }

    public void createReport() {
        PrintWriter printToFile;

        try {
            printToFile = new PrintWriter(new File(fileNamePrintReport));

            //Initial Stats
            printToFile.println(
                    "Initial number of bugs: " + this.initialNumbeOfBugs + "\n"
                            + "Initial number of male bugs: " + this.initialNumberOfMaleBugs + "\n"
                            + "Initial number of female bugs: " + this.initialNumberOfFemaleBugs + "\n");

            //Final Stats
            printToFile.println(
                    "Final number of bugs: " + (this.countFemale() + this.countMale()) + "\n"
                            + "Final number of alive bugs: " + (this.countFemaleAlive() + this.countMaleAlive()) + "\n"
                            + "Final number of dead bugs: " + (this.countFemaleDead() + this.countMaleDead()) + "\n" + "\n"
                            + "Final number of male bugs: " + this.countMale() + "\n"
                            + "Final number of alive male bugs: " + this.countMaleAlive() + "\n"
                            + "Final number of dead male bugs: " + this.countMaleDead() + "\n" + "\n"
                            + "Final number of female bugs: " + this.countFemale() + "\n"
                            + "Final number of alive female bugs: " + this.countFemaleAlive() + "\n"
                            + "Final number of dead female bugs: " + this.countFemaleDead()
            );
            printToFile.close();
            System.out.println("Report was created successfully! Check your current working directory to find the report file");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
