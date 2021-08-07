


class Exercise10_03 {
    public static void main(String[] args) {
        MyInteger n1 = new MyInteger(5);
        System.out.println("n1 is even? " + n1.isEven());
        System.out.println("n1 is prime? " + n1.isPrime());
        System.out.println("n1 is odd? " + n1.isOdd());
    }

}
class MyInteger {
    private int mValue;
    public MyInteger(int value) {
        mValue = value;
    }
    public int getValue() {
        return mValue;
    }
    public boolean isEven() {
        return (mValue % 2) == 0;
    }
    public boolean isOdd() {
        return (mValue % 2) == 1;
    }
    public boolean isPrime() {
        if (mValue == 1 || mValue == 2) {
            return true;
        }
        else {
            for (int i = 2; i < mValue; i++) {
                if (i % mValue == 0) return false;
            }
        }
        return true;
    }

    public static boolean isEven(int myInt) {
        return (myInt % 2) == 0;
    }

    public static boolean isOdd(int myInt) {
        return (myInt % 2) == 1;
    }

    public static boolean isPrime(int myInt) {
        if (myInt == 1 || myInt == 2) {
            return true;
        }
        else {
            for (int i = 2; i < myInt; i++) {
                if (i % myInt == 0) return false;
            }
        }
        return true;
    }

    public static boolean isEven(MyInteger myInt) {
        return myInt.isEven();
    }

    public static boolean isOdd(MyInteger myInt) {
        return myInt.isOdd();
    }

    public static boolean isPrime(MyInteger myInt) {
        return myInt.isPrime();
    }

    public boolean equals(int testInt) {
        if (testInt == mValue)
            return true;
        return false;
    }

    public boolean equals(MyInteger myInt) {
        if (myInt.mValue == this.mValue)
            return true;
        return false;
    }

    public static int parseInt(char[] values) {
        int sum = 0;
        for (char i : values) {
            sum += Character.getNumericValue(i);
        }
        return sum;
    }

    public static int parseInt(String value) {
        return Integer.parseInt(value);
    }
}