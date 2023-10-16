package maths.basic;

//IMP

// GCD=> Greatest Common Divisor
// HCF=> Highest common factor
// GCD = HCF

// EX => if there are 2 number
// a= 9, b= 12, the GCD will be 3. Bcz the greatest number that is dividing both the values is GCD
// a= 20, b= 40, the GCD will be 20. Bcz the greatest number that is dividing both the values is GCD
//  TC => O(min(a,b))  // for above example


// To find GCD we use Euclidean Algorithm
// Euclidean Algorithm says gcd(a,b) = gcd(a-b) where a>b. We use this till one of the value become 0. So after using this when gcd(0,b) than b is the GCD answer.
// But this can take lots of time, so the more optimised way is => gcd(a % b, b) where a>b
public class GCDorHCF {

    public static void main(String[] args) {
        System.out.println(EuclideanALgo(20, 40));
    }

    static int EuclideanALgo(int a, int b) {
// TC=> O(log∅(min(a,b)))
// Here ∅ is Phy, something like this, need to check
        //(a > 0 && b > 0) bcz both the values should be greater than 0 or the gcd is the value that is non-zero
        while (a > 0 && b > 0) {

            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        if (a == 0) {
            return b;
        } else {
            return a;
        }
    }

}
