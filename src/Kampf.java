public class Kampf {
    Queue<Maus> eingang = new Queue<Maus>();
    Queue<Maus> ausgang = new Queue<Maus>();
    Stack<Maus> stapel = new Stack<Maus>();

    public Kampf() {

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

    public void mausKampf() {
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
}
