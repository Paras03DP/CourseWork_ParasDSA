package Week8;
// Week 8
// You are provided with a m x n grid representing rooms in the house with the following 
// information:
// '*' represents an empty cell.
// '#' is a wall.
// The starting point is '@'.
// Keys are represented lower case letters.
// Locks are represented by capital letters.
// You begin at the beginning and make one move by walking one space in one of the four 
// cardinal directions. You cannot wander off the beaten path or into a wall. You can pick 
// up a key if you walk over it, but you cannot walk over a lock unless you have the 
// associated key.
// There is exactly one lowercase and one capital letter from the first k letters of the English 
// alphabet in the grid for some 1= k = 6. 
// Input: grid = ["@*a*#","###*#","b*A.*B"]
// Output: 8
// Explanation: Note that the goal is to obtain all the keys, not to open all the locks.


class PathFinderWeek8 {

    String[] input;
    int rows;
    int columns;

    PathFinderWeek8(String[] input) {
        this.input = input;
        this.rows = input.length;
        this.columns = input[0].length();
    }

    int processor() {

        int keys = keysNumberFinder();

        int totalTravelled = 0;
        int keysFound = 0;
        boolean run = true;
        int x = 0;
        int travelledRow = 0;
        int adder = 1;
        char[] foundK = new char[2];

        while (run) {
            if (input[travelledRow].charAt(x + adder) != '#') {

                if (input[travelledRow].charAt(x + adder) == '*') {
                    x += adder;
                    totalTravelled++;
                    continue;
                } else {
                    if (input[travelledRow].charAt(x + adder) != input[travelledRow].toUpperCase().charAt(x + adder)) {
                        totalTravelled++;
                        foundK[keysFound] = input[travelledRow].charAt(x + adder);
                        x += adder;
                        keysFound++;

                        if (keysFound == keys) {
                            run = false;
                            break;
                        } else {
                            continue;
                        }

                    } else {

                        boolean yes = false;

                        for (int l = 0; l < foundK.length; l++) {
                            if (foundK[l] == input[travelledRow].toLowerCase().charAt(x + adder)) {

                                yes = true;
                            }
                        }

                        if (yes) {
                            // keysFound++;
                            totalTravelled++;
                            x += adder;
                            continue;
                        } else {
                            adder *= -1;
                            continue;
                        }

                    }
                }

            }

            if (input[travelledRow + 1].charAt(x) != '#') {

                if (input[travelledRow + 1].charAt(x) == '*') {

                    travelledRow += 1;
                    totalTravelled++;
                    continue;
                } else {
                    if (input[travelledRow + 1].charAt(x) != input[travelledRow + 1].toUpperCase().charAt(x)) {
                        totalTravelled++;
                        foundK[keysFound] = input[travelledRow + 1].charAt(x);
                        travelledRow += 1;
                        keysFound++;

                        if (keysFound == keys) {
                            run = false;
                            break;
                        } else {
                            continue;
                        }

                    } else {

                        boolean yes = false;

                        for (int l = 0; l < foundK.length; l++) {
                            if (foundK[l] == input[travelledRow + 1].toLowerCase().charAt(x)) {

                                yes = true;
                            }
                        }

                        if (yes) {
                            // keysFound++;
                            totalTravelled++;
                            travelledRow++;
                            continue;
                        }

                    }
                }

            }
        }

        return totalTravelled;
    }

    int keysNumberFinder() {

        int alphabets = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (input[i].charAt(j) == '@' || input[i].charAt(j) == '#'
                        || input[i].charAt(j) == '*') {
                    continue;
                } else {
                    alphabets++;
                }
            }
        }

        int keys = alphabets / 2;

        return keys;
    }

    public static void main(String[] args) {

        String[] value = { "@*a*#", "###*#", "b*A*B" };

        PathFinderWeek8 pth = new PathFinderWeek8(value);
        System.out.println(pth.processor());
    }

}

