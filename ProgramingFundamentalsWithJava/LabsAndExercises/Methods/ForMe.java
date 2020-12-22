public class ForMe {
    public static void main(String[] args) {
        int [] array1 = new int[]{15,25,26,45,56};
        int [] array2 = new int[array1.length];
        int firstElement = array1[array1.length-1];

        for (int i = array1.length-1; i >=0; i--) {
            for (int j = 0; j <array2.length ; j++) {
                array2[j]=array1[i];

            }

            System.out.println(array2[i]);

        }



    }
}
