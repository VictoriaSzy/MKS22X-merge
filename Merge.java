import java.util.* ;

public class Merge {
  public static void main(String[] args) {
    System.out.println("******************TESTING MERGE******************") ;
    int[] a = {1, 2, 4, 5, 6, 9} ;
    System.out.println("a = " + Arrays.toString(a)) ;
    int[] b = {-4, 0, 8, 25} ;
    System.out.println("b = " + Arrays.toString(b)) ;
    System.out.println( Arrays.toString(merge(a,b)) ) ;
  }
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data) {
    mergeH(data, 0, data.length - 1) ;
  }
  // Helper method for merge sorting that will be the recursive part
  public static void mergeH(int[] data, int lo, int hi) {
    /* pseudocode from Mr. K's website:
    mergesort(data,lo,hi):
      if lo >= hi :
        return
      mergesort left side
      mergesort right side
      merge
    */
    if (lo >= hi) return ; // when there is only one element
    int l = data.length ;
    int half = (l - 1) / 2 ;
    int[] a = new int[half] ;
    for (int i = 0 ; i < a.length ; i++) {
      a[i] = data[i] ;
    }
    mergeH(a, 0, a.length - 1) ;
    int[] b = new int[l - half] ;
    for (int x = 0 ; x < b.length ; x++) {
      b[x] = data[half + x] ;
    }
    mergeH(b, 0, b.length - 1) ;
    // finished creating halved arrays
    int position = 0, iA = 0, iB = 0 ;
    int lenA = a.length, lenB = b.length ;
    ////// while loop starts
    while (position < l) {
      if (iA >= lenA) {
        data[position] = b[iB] ;
        iB++ ;
        position++ ;
      }
    }
    ///////// while loop ends
    ///////////////////////////////////////////////////////////////////////////////
    data = merge(a,b) ;
    /*if (data.length == 2) {
      // we have 2 values to compare
      if (data[0] > data[1]) {
        // we need to flip them
        swap(0, 1, data) ;
      }
      // after this they are in the correct order
      return data ;
    }*/
  }
  // helper method to move around values
  public static void swap(int a, int b, int[] data) {
    int temp = data[a] ;
    data[a] = data[b] ;
    data[b] = temp ;
  }
  // final step for mergesort
  public static int[] merge(int[] a, int[] b) {
    int[] res = new int[a.length + b.length] ;
    int aIndex = 0, bIndex = 0 ;
    int ind = 0 ;
    for (int i = 0 ; i < res.length && aIndex < a.length && bIndex < b.length; i++) {
      if (a[aIndex] <= b[bIndex]) {
        // a has the smaller element so it will go to res
        res[i] = a[aIndex] ;
        aIndex++ ;
      }
      else {
        // b[bIndex] > a[aIndex]
        // b has the smaller element so it will go to res
        res[i] = b[bIndex] ;
        bIndex++ ;
      }
      ind++ ;
    }
    // now we have to check whether we finished going through one of the arrays that we are merging
    if (aIndex == a.length && bIndex != b.length) {
      // we went through a completely and now we have to add the rest of the values (which should be in the correct increasing order)
      while (ind < res.length && bIndex < b.length) {
        res[ind] = b[bIndex] ;
        bIndex++ ;
      }
    }
    if (bIndex == b.length && aIndex != a.length) {
      // adding any remaining values from a
      while (ind < res.length && aIndex < a.length) {
        res[ind] = a[aIndex] ;
        aIndex++ ;
      }
    }
    return res ;
  }
}
