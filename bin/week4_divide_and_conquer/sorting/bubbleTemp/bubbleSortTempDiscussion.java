import java.util.ArrayList;

import java.util.Scanner;

public class TestClass {

    private static Scanner sc = new Scanner(System.in);

    private static ArrayList<ArrayList<Data>> data = new ArrayList<>();

    public static void main(String[] args) {

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            data.add(i, new ArrayList<>());

            int n = sc.nextInt();

            for (int j = 0; j < n; j++) {

                data.get(i).add(j, new Data(sc.nextInt(), sc.nextInt(), sc.nextInt()));

            }

            System.out.println(printIsPossible(data.get(i), n));

        }

    }

    public static String printIsPossible(ArrayList<Data> data, int n) {

        int upperSum = 0;

        int lowerSum = 0;

        int xiyisum = 0;

        for (int i = 0; i < n; i++) {

            if (data.get(i).getXi() == 0 && data.get(i).getYi() == 1)
                continue;

            if (isXYNorthEast(data.get(i).getXi(), data.get(i).getYi())) {

                xiyisum += data.get(i).getHi();

            }

            if (!isXYNorthEast(data.get(i).getXi(), data.get(i).getYi())
                    && ((data.get(i).xi > -1 && (data.get(i).xi < data.get(i).yi))
                            || (data.get(i).xi < 1 && (data.get(i).xi < data.get(i).yi)))) {

                upperSum += data.get(i).hi;

                if (i == n - 1 && upperSum < lowerSum) {

                    upperSum += xiyisum;

                }

            } else if (!isXYNorthEast(data.get(i).getXi(), data.get(i).getYi())
                    && ((data.get(i).xi > -1 && (data.get(i).xi > data.get(i).yi))
                            || (data.get(i).xi < 1 && (data.get(i).xi > data.get(i).yi)))) {

                lowerSum += data.get(i).hi;

                if (i == n - 1 && upperSum > lowerSum) {

                    lowerSum += xiyisum;

                }

            }

        }

        if (lowerSum == upperSum) {

            return "YES";

        } else
            return "NO";

    }

    public static boolean isXYNorthEast(int xi, int yi) {

        if (xi == yi) {

            return true;

        }

        return false;

    }

    private static class Data {

        private int xi;

        private int yi;

        private int hi;

        public Data(int xi, int yi, int hi) {

            this.xi = xi;

            this.yi = yi;

            this.hi = hi;

        }

        public int getXi() {

            return xi;

        }

        public int getYi() {

            return yi;

        }

        public int getHi() {

            return hi;

        }

    }

}