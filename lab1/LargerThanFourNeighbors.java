public class LargerThanFourNeighbors {
    public static void main(String[] args) {
        int[] arr = {10, 15, 20, 15, 10, 5, 10, 15, 22, 20};
        Dog[] dogs = new Dog[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dogs[i] = new Dog(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(dogs[i].weight + " ");
        }
        System.out.println();

        /*
         * the point is how to pick the object to compare with
         * thought: define a number = -2!
         * this eg show the importance of helper method
         * 1.make code easier to read and debug
         * 2.more structure
         */
        for (int i = 0; i < dogs.length; i++) {
            if (i == 0)
                if (dogs[i].weight > dogs[i+1].weight && dogs[i].weight > dogs[i+2].weight) {
                    System.out.println(i + ": " + dogs[i].weight);
                    i += 2;
                }
            if (i == 1)
                if (dogs[i].weight > dogs[i+1].weight && dogs[i].weight > dogs[i+2].weight
                        && dogs[i].weight > dogs[i-1].weight) {
                    System.out.println(i + ": " + dogs[i].weight);
                    i += 2;
                }

            if (i > 1 && i < dogs.length-2)
                if (dogs[i].weight > dogs[i+1].weight && dogs[i].weight > dogs[i+2].weight
                        && dogs[i].weight > dogs[i-1].weight && dogs[i].weight > dogs[i-2].weight) {
                    System.out.println(i + ": " + dogs[i].weight);
                    i += 2;
                }

            if (i == dogs.length-2)
                if (dogs[i].weight > dogs[i+1].weight &&
                        dogs[i].weight > dogs[i-1].weight && dogs[i].weight > dogs[i-2].weight) {
                    System.out.println(i + ": " + dogs[i].weight);
                    i += 2;
                }

            if (i == dogs.length-1)
                if (dogs[i].weight > dogs[i-1].weight && dogs[i].weight > dogs[i-2].weight) {
                    System.out.println(i + ": " + dogs[i].weight);
                    break;
                }
        }

    }
}

class Dog {
    int weight;

    Dog(int i) {
        weight = i;
    }
}
