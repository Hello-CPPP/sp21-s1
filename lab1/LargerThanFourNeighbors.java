public class LargerThanFourNeighbors {
    public static void main(String[] args) {
        int[] arr = {10, 15, 20, 15, 10, 5, 10, 15, 22, 20};
        Dog[] dogs = new Dog[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dogs[i] = new Dog(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(dogs[i].weight + " ");
        }

        

    }
}

class Dog {
    int weight;

    Dog(int i) {
        weight = i;
    }
}
