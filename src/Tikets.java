public class Tikets {
        public static void main(String[] args) {
            int count = 0;
            for (int ticket = 1; ticket <= 999999; ticket++) {
                int sumOne = 0;
                int sumTwo = 0;
                int temp = ticket;

                for (int i = 0; i < 3; i++) {
                    sumOne += temp % 10;
                    temp /= 10;
                }

                for (int i = 0; i < 3; i++) {
                    sumTwo += temp % 10;
                    temp /= 10;
                }

                if (sumOne == sumTwo) {
                    count++;
                }
            }

            System.out.println("Количество: " + count);
        }
}
