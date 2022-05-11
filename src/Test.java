public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.kampfTesten();

        Kampf z = new Kampf();
        z.zufallsBelegung(5);
        z.mausKampf();
    }

    public void kampfTesten() {
        int[] arr = { 10, 5, 1, 7, 4 }; // Hier Stärken der Mäuse angeben
        Queue<Maus> q = new Queue<Maus>();

        for (int i = 0; i < arr.length; i++) {
            Maus m = new Maus(i + 1, arr[i]);
            q.enqueue(m);
        }

        Kampf k = new Kampf();
        k.manuelleBelegung(q);
        k.mausKampf();
    }
}
