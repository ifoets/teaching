package interview.preparation.company.interviews.design.hcl;
class FiveTon
{
    private static volatile FiveTon[] fiveTon;
    static int i=0;

    private FiveTon()
    {
    }

    public synchronized FiveTon getFiveTon(){
        if(fiveTon==null || fiveTon[i%5]==null)
        {
            synchronized (this)
            {
                if(fiveTon==null || fiveTon[i%5]==null) {
                    fiveTon = new FiveTon[5];
                    fiveTon[i % 5] = new FiveTon();
                    return fiveTon[i++ % 5];
                }
                return fiveTon[i++ % 5];
            }
        }
        return fiveTon[i++ % 5];
    }
}