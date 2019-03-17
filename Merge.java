import java.util.* ;

public class Merge {
  public static void main(String[] args) {
    System.out.println("Size\t\tMax Value\tMerge/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long mtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Merge.mergesort(data2);
          t2 = System.currentTimeMillis();
          mtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*mtime/btime);
      }
      System.out.println();
    }
    /*System.out.println("******************TESTING MERGE******************") ;
    int[] a = {1, 2, 4, 5, 6, 9} ;
    System.out.println("a = " + Arrays.toString(a)) ;
    int[] b = {-4, 0, 8, 25} ;
    System.out.println("b = " + Arrays.toString(b)) ;
    System.out.println( Arrays.toString(merge(a,b)) ) ;*/
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
    int half = l / 2 ;
    int[] a = new int[half] ;
    for (int i = 0 ; i < a.length ; i++) {
      a[i] = data[i] ;
    }
    int lenA = a.length ;
    //System.out.println("We split it into half: " + Arrays.toString(a)) ;
    mergeH(a, 0, lenA - 1) ;
    int[] b = new int[l - half] ;
    for (int x = 0 ; x < b.length ; x++) {
      b[x] = data[half + x] ;
    }
    int lenB = b.length ;
    //System.out.println("We split it into half: " + Arrays.toString(b)) ;
    mergeH(b, 0, lenB- 1) ;
    // finished creating halved arrays
    int position = 0, iA = 0, iB = 0 ;
    ////// while loop starts
    while (position < l) {
      if (iA >= lenA) {
        // done with array a
        //System.out.println("We finished going through array a") ;
        data[position] = b[iB] ;
        iB++ ;
      }
      else if (iB >= lenB) {
        // done with array b
        //System.out.println("We finished going through array b") ;
        data[position] = a[iA] ;
        iA++ ;
      }
      // comparing values to see which is smaller
      else if (a[iA] <= b[iB]) {
        //System.out.println("The value in array a is smaller than OR equal to the value in array b") ;
        data[position] = a[iA] ;
        iA++ ;
      }
      else {
        //System.out.println("The value in array b is smaller than the value in array a") ;
        data[position] = b[iB] ;
        iB++ ;
      }
      position++ ;
    }
    ///////// while loop ends
    ///////////////////////////////////////////////////////////////////////////////
    /*data = merge(a,b) ;
    if (data.length == 2) {
      // we have 2 values to compare
      if (data[0] > data[1]) {
        // we need to flip them
        swap(0, 1, data) ;
      }
      // after this they are in the correct order
      return data ;
    }*/
  }
  /*// helper method to move around values
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
  }*/
}
