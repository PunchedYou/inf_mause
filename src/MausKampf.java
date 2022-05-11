public class MausKampf
{
    Queue<Maus> eingang = new Queue<Maus>();
    Queue<Maus> ausgang = new Queue<Maus>();
    Stack<Maus> stapel = new Stack<Maus>();
    public MausKampf()
    {

    }

    public void zufallsBelegung (int anzahl){
        for (int i = 1; i<=anzahl; i++){
            Maus m = new Maus();
            int random = ((int) (Math.random() * 9));
            m.setStaerke(random);
            m.setNummer(i);
            eingang.enqueue(m);
        }
    }

    public void manuelleBelegung(Queue<Maus> q){
        while (!q.isEmpty()){
            eingang.enqueue(q.front());
            q.dequeue();
        }
    }

    public void kampf(){
        stapel.push(eingang.front());
        eingang.dequeue();
        while (!eingang.isEmpty()){
             Maus mQ = new Maus();
             mQ = eingang.front();
             Maus mS = new Maus();
             mS = stapel.top();
             if (mQ.getStaerke() > mS.getStaerke()){
                 stapel.push(mQ);
                 eingang.dequeue();
             }
             else {
                 ausgang.enqueue(mS);
                 stapel.pop();
             }
        }
        while (!stapel.isEmpty()){
            ausgang.enqueue(stapel.top());
            stapel.pop();
        }
        System.out.println("Reihenfolge der Mäuse am Käse: " );
        while (!ausgang.isEmpty()){
           Maus maus = ausgang.front();
           ausgang.dequeue();
           System.out.print(maus.getStaerke());
        }
    }
    
    //test
}
