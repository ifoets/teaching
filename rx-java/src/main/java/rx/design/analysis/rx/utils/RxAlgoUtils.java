package rx.design.analysis.rx.utils;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class RxAlgoUtils {

    public static Single<List<Integer>> mergeShort(List<Integer> list)
    {
        if(list.size()<=1) {
            return Single.just(list);//base case
        }
        int mid = list.size()/2;
        List<Integer> left = list.subList(0,mid);
        List<Integer> right = list.subList(mid,list.size());

        return
            Single.zip(
                mergeShort(left),
                mergeShort(right),
                RxAlgoUtils::merge
            ).observeOn(Schedulers.io());

    }

    public static List<Integer> merge(List<Integer> left,List<Integer> right)
    {
        List<Integer> result = new ArrayList<>();
        int i=0,j=0;
        while (i<left.size() && j<right.size())
        {
            if(left.get(i)<=right.get(j))
                result.add(left.get(i++));
            else result.add(right.get(j++));
        }
        while (i<left.size())result.add(left.get(i++));
        while (j<right.size())result.add(right.get(j++));
        return result;
    }
}
