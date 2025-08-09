package interview.preparation.company.interviews.design.hcl;

public class Doubleton {
    private static volatile Doubleton[] doubletons ;
    static int i=0;

    private Doubleton()
    {
    }

    public  synchronized Doubleton getDoubleton(){
        if(doubletons==null)
        {
            synchronized (this)
            {
                if(doubletons==null) {
                    doubletons = new Doubleton[2];
                    doubletons[0] = new Doubleton();
                    doubletons[1] = new Doubleton();
                    return i++ % 2 == 0 ? doubletons[0] : doubletons[1];
                }
            }
        }
        return i++%2==0? doubletons[0]: doubletons[1];
    }
}
