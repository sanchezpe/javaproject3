package p3_pes1338;

public class Bug implements Comparable<Bug> {

    private int X = 0;
    private int Y = 0;
    private int maxX = 99;
    private int maxY = 99;
    private final int minX = 0;
    private final int minY = 0;
    private boolean isAlive = true;
    private final int gender = this.randomInt(2); // 0 female, 1 male

    private int randomInt(int numberOfIntegers) {
        int randomInt = (int) (Math.random() * numberOfIntegers);
        return randomInt;
    }

    public Bug(int upperBoundXIn, int upperBoundYIn) {
        if (upperBoundXIn < maxX) { //Limits max value of X to 99
            maxX = upperBoundXIn;
        }
        if (upperBoundYIn < maxY) { //Limits max value of Y to 99
            maxY = upperBoundYIn;
        }

        X = randomInt(maxX + 1); //Puts bug in a random X place
        Y = randomInt(maxY + 1); //Puts bug in a random Y place
    }

    public void moveAtRandom() {
        int direction = randomInt(9); //8 possible directions and 1 for hold
        if (this.getIsAlive()) {
            switch (direction) {
                case 0:
                    if (X != maxX) {
                        X += 1;
                        //Y += 0;
                    }
                    break;
                case 1:
                    if (Y != maxY) {
                        //X += 0;
                        Y += 1;
                    }
                    break;
                case 2:
                    if (X != maxX && Y != maxY) {
                        X += 1;
                        Y += 1;
                    }

                    break;
                case 3:
                    if (X != minX) {
                        X -= 1;
                        //Y -= 0;
                    }
                    break;
                case 4:
                    if (Y != minY) {
                        //X += 0;
                        Y -= 1;
                    }
                    break;
                case 5:
                    if (X != minX && Y != minY) {
                        X -= 1;
                        Y -= 1;
                    }
                    break;
                case 6:
                    if (X != maxX && Y != minY) {
                        X += 1;
                        Y -= 1;
                    }

                    break;
                case 7:
                    if (X != minX && Y != maxY) {
                        X -= 1;
                        Y += 1;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void setX(int XIn) {
        X = XIn;
    }

    public int getX() {
        return X;
    }

    public void setY(int YIn) {
        Y = YIn;
    }

    public int getY() {
        return Y;
    }

    public void setMaxX(int XIn) {
        maxX = XIn;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxY(int maxYIn) {
        maxY = maxYIn;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setIsAlive(boolean statusIn) {
        isAlive = statusIn;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public int getGender() {
        return gender;
    }

    @Override
    public int compareTo(Bug compareBug) {
        if ((X - compareBug.getX()) + (Y - compareBug.getY()) > 0) {
            return 1;
        }
        if ((X - compareBug.getX()) + (Y - compareBug.getY()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
