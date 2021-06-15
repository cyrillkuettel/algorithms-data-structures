package ch.hslu.ad.Ausprobieren;

/**
 *
 * @author cyrill
 */
public final class search {

    private final int[] data;

    public search(final int[] data) {
        this.data = data;
    }

    public int doit(final int value) {
        int min = 0;
        int max = this.data.length - 1;
        int index = (min + max) / 2;
        while ((min <= max) && (this.data[index] != value)) {
            if (this.data[index] < value) {
                min = index;
            } else {
                max = index;
            }
            index = (min + max) / 2;
        }
        if (min > max) {
            index = -1;
        }
        return index;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        
        search s = new search(arr);
        System.out.println(s.doit(4));
        
    }
}
