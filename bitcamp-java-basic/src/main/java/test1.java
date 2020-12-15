

public class test1 {
  public static void main(String[] args) {
    //    Calendar cal = new GregorianCalendar(Locale.KOREA);
    //    Date today = new Date(cal.getTimeInMillis());
    //    cal.setTime(today);
    //    Date day = new Date(cal.getTimeInMillis());
    //    System.out.println(day);
    //
    //    cal.add(Calendar.DATE, -1);
    //    Date yesterday = new Date(cal.getTimeInMillis());
    //
    //    cal.add(Calendar.DATE, 1 - cal.get(Calendar.DAY_OF_WEEK));
    //    cal.setTime(today);
    //    cal.add(Calendar.DATE, 1-cal.get(Calendar.DAY_OF_MONTH));
    //    day = new Date(cal.getTimeInMillis());
    //    System.out.println(day);

    AutoGenTrmEnm auto = new AutoGenTrmEnm();

    char[] combinationOfChar = {'게','시','중', '오'};
    auto.solve(1, combinationOfChar);
    auto.solve(2, combinationOfChar);
    auto.solve(3, combinationOfChar);
    auto.solve(4, combinationOfChar);

  }
}

class AutoGenTrmEnm {

  public void solve( final int n, final char[] a ) {
    final int[] selected = new int[n];
    print( n, a, 0, selected );
  }

  // need to know how many items are selected - n, input array - a
  // item which can be selected next - from and already selected items
  private void print( final int n, final char[] a, final int from, final int[] selected) {
    if ( n == 0 ) { // all selected, just print them
      for ( int i = 0; i < selected.length; ++i ) {
        System.out.print( a[ selected[ i ] ] + " " );
      }
      System.out.println();
      return;
    }
    // select one and use recursion for others
    for ( int i = from; i < a.length; ++i ) {
      selected[ selected.length - n ] = i;
      print( n - 1, a, i + 1, selected );
    }
  }

}
