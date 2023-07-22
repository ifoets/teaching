package com.design.analysis.advance.simple.example.creational.objectpool;

import java.util.Enumeration;
import java.util.Hashtable;

public abstract class ObjectPool<T> {
    long deadTime;
    Hashtable<T, Long> lock, unlock;

    public ObjectPool()
    {
        deadTime = 50000; //50 sec
        lock = new Hashtable<>();
        unlock = new Hashtable<>();
    }
    abstract T create();
    abstract boolean validate(T t);
    abstract void dead(T t);
    synchronized T takeOut()
    {
        long now = System.currentTimeMillis();
        T t;
        if(unlock.size() > 0)
        {
            Enumeration<T> e = unlock.keys();
            while (e.hasMoreElements())
            {
                t = e.nextElement();
                if(now- unlock.get(t)>50)
                {
                    //object is dead
                    unlock.remove(t);
                    dead(t);
                    t = null;
                }
                else if(validate(t))
                {
                    unlock.remove(t);
                    lock.put(t,now);
                    return t;
                }
                else //object fail validation
                {
                    unlock.remove(t);
                    dead(t);
                    t = null;
                }
            }
        }
        //no object available create new object
        t =create();
        lock.put(t, now);
        return  t;
    }
    synchronized void takeIn(T t)
    {
        lock.remove(t);
        unlock.put(t, System.currentTimeMillis());
    }
}
