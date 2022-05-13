import java.util.Arrays;

public class MausKampf {
    Queue<Maus> eingang = new Queue<Maus>();
    Queue<Maus> ausgang = new Queue<Maus>();
    Stack<Maus> stapel = new Stack<Maus>();

    public MausKampf() {

    }

    public void zufallsBelegung(int anzahl) {
        for (int i = 1; i <= anzahl; i++) {
            int r = (int) (Math.random() * (10 - 1)) + 1;
            Maus m = new Maus(i, r);
            eingang.enqueue(m);
        }
    }

    public void manuelleBelegung(Queue<Maus> q) {
        while (!q.isEmpty()) {
            eingang.enqueue(q.front());
            q.dequeue();
        }
    }

    public void kampfAusfuehren() {
        while (!eingang.isEmpty() || !stapel.isEmpty()) {
            if (!eingang.isEmpty()) {
                if (stapel.isEmpty()) {
                    stapel.push(eingang.front());
                    eingang.dequeue();
                } else if (eingang.front().getStaerke() > stapel.top().getStaerke()) {
                    stapel.push(eingang.front());
                    eingang.dequeue();
                } else {
                    ausgang.enqueue(stapel.top());
                    stapel.pop();
                }
            } else {
                while (!stapel.isEmpty()) {
                    ausgang.enqueue(stapel.top());
                    stapel.pop();
                }
            }
        }

        System.out.println("Reihenfolge der Mäuse am Käse: ");
        while (!ausgang.isEmpty()) {
            System.out.println(ausgang.front().getNummer() + " (" + ausgang.front().getStaerke() + ")");
            ausgang.dequeue();
        }
    }

    public void reihenfolgeSimulieren(int[] arr) {
        Queue<Maus> start = new Queue<Maus>();
        Queue<Maus> ergebnis = new Queue<Maus>();
        Stack<Maus> stapel = new Stack<Maus>();

        for (int i : arr) {
            Maus m = new Maus(i, 0);
            ergebnis.enqueue(m);
        }

        Arrays.sort(arr);

        for (int i : arr) {
            Maus m = new Maus(i, 0);
            start.enqueue(m);
        }

        for (int i = 0; i < arr.length; i++) {
            if (stapel.isEmpty()) {
                stapel.push(start.front());
            }

            while (stapel.top().getNummer() != ergebnis.front().getNummer()) {
                if (start.isEmpty()) {
                    System.out.println("Die Kombination ist nicht möglich!");
                    return;
                }

                start.front().cGewonnen();

                if (!stapel.isEmpty()) {
                    stapel.top().cVerloren();
                }

                stapel.push(start.front());
                start.dequeue();
            }

            ergebnis.enqueue(stapel.top());
            ergebnis.dequeue();
            stapel.pop();
        }

        System.out.println("Die Kombination ist möglich!");

        while (!ergebnis.isEmpty()) {
            System.out.println(ergebnis.front().getNummer() + " - Gewonnen: " + ergebnis.front().getGewonnen()
                    + " Verloren: " + ergebnis.front().getVerloren());
            ergebnis.dequeue();
        }
    }
}