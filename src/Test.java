public class Test {
    public static void main(String[] args) {
        final long timeStart = System.currentTimeMillis();

        Test t = new Test();
        t.kampfTesten(); // Kampf wird mit mit festen Stärken getestet

        MausKampf mk = new MausKampf();
        mk.zufallsBelegung(5);
        mk.kampfAusfuehren(); // Kampf wird mit zufällligen Stärken getestet

        int[] arr = { 7, 6, 5, 4, 3, 2, 8, 9, 1 };
        mk.reihenfolgeSimulieren(arr); // Eine vorgegebene Reihenfolge wird simuliert

        final long timeEnd = System.currentTimeMillis();
        System.out.println("Zeit des Programms: " + (timeEnd - timeStart) + "ms");
    }

    public void kampfTesten() {
        int[] arr = { 10, 5, 1, 7, 4 }; // Hier Stärken der Mäuse angeben
        Queue<Maus> q = new Queue<Maus>();

        for (int i = 0; i < arr.length; i++) {
            Maus m = new Maus(i + 1, arr[i]);
            q.enqueue(m);
        }

        MausKampf k = new MausKampf();
        k.manuelleBelegung(q);
        k.kampfAusfuehren();
    }
}