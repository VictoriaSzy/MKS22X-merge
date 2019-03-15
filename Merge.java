public class Merge {
  public static void main(String[] args) {
    System.out.println() ;
  }
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data) {
    /* pseudocode from Mr. K's website:
    mergesort(data,lo,hi):
      if lo >= hi :
        return
      mergesort left side
      mergesort right side
      merge
    */
    int half = (data.length - 1) / 2 ;
    int[] a = mergeH(data, 0, half) ;
    int[] b = mergeH(data, half + 1, data.length - 1) ;
    data = merge(a,b) ;
  }
  // Helper method for merge sorting that will be the recursive part
  public static int[] mergeH(int[] data, int lo, int hi) {
    if (lo >= hi) return data ; // when there is only one element
    if (data.length == 2) {
      // we have 2 values to compare
      if (data[0] > data[1]) {
        // we need to flip them
        swap(0, 1, data) ;
      }
      // after this they are in the correct order
      return data ;
    }
    else {
      // data is not length 2
      return mergeH(data, lo, hi / 2) ;
    }
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
    for (int i = 0 ; i < res.length ; i++) {
      if (a[aIndex] < b[bIndex]) {
        // a has the smaller element so it will go to res
        res[i] = a[aIndex] ;
        aIndex++ ;
      }
      else if (b[bIndex] > a[aIndex]) {
        // b has the smaller element so it will go to res
        
      }
    }
    return res ;
  }
}
