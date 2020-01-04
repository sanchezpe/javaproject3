package p3_pes1338;

public class P3_pes1338 {

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter number of bugs: ");
        int numberOfBugs = input.nextInt();

        System.out.print("Enter upper bounds of the range X: ");
        int upperBoundX = input.nextInt();

        System.out.print("Enter upper bounds of the range Y: ");
        int upperBoundY = input.nextInt();

        System.out.print("Enter number of times the alive bugs will move: ");
        int timesBugsMove = input.nextInt();

        System.out.print("Enter the name of the report file (.txt): ");
        String fileNamePrintReport = input.next();
//        String fileNamePrintReport = "out";

        //Startup
        BugFarm myBugs = new BugFarm(numberOfBugs, upperBoundX, upperBoundY, timesBugsMove, fileNamePrintReport);

        //Process
        myBugs.startSimulation();

        //Wrapup
        myBugs.createReport();

    }

}
