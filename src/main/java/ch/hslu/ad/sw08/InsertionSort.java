package ch.hslu.ad.sw08;

 class InsertionSort implements Sortieren{

    @Override
    public void sort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int current = a[j];
            int i = j - 1;
            while ((i > -1) && (a[i] > current)) {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = current;
        }
    }
}
