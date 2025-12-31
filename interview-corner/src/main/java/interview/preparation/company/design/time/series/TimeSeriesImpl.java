package interview.preparation.company.design.time.series;

import interview.preparation.company.design.time.series.model.Event;

import java.util.*;
import java.util.stream.Collectors;

public class TimeSeriesImpl implements ITimeSeries{
    static final long FIVE_MIN = 5 * 60 * 1000;
    /**How to process time-series data and remove entries repeating within 5 minutes for the same ID**/

    /**Java Streams – Keep FIRST event in every 5-minute window**/
    @Override
    public List<Event> dedupeKeepFirst(List<Event> entries)
    {
        return
            entries.stream().collect(Collectors.groupingBy(Event::id))
                .values()
                .stream()
                .flatMap(list->
                {
                    list.sort(Comparator.comparing(Event::time));
                    List<Event> result = new ArrayList<>();
                    Event lastTime=null;
                    for(Event e:list)
                    {
                        if(lastTime==null||e.time()- lastTime.time()>=FIVE_MIN)
                        {
                            result.add(e);
                            lastTime = e;
                        }
                    }
                    return result.stream();
                })
                .collect(Collectors.toList());
    }

    /**JJava Streams – Keep LATEST event within 5 minutes**/
    @Override
    public List<Event> dedupeKeepLatest(List<Event> entries){
        return
            entries.stream().collect(Collectors.groupingBy(Event::id))
                .values()
                .stream()
                .flatMap(list->{
                    list.sort(Comparator.comparing(Event::time));

                    List<Event> result = new ArrayList<>();
                    Event last = null;
                    for(Event e:list)
                    {
                        if(last==null)
                            last=e;
                        if(e.time()- last.time()<FIVE_MIN)
                        {
                            last = e; //update last
                        }
                        else
                        {
                            result.add(last);
                            last=e;
                        }
                    }
                    if(last!=null)
                        result.add(last);
                    return result.stream();
                })
                .toList();
    }

    @Override
    public  List<Event> keepLastEventPer5MinWindow(List<Event> events) {

        return events.stream()
            .collect(Collectors.groupingBy(
                e -> new AbstractMap.SimpleImmutableEntry<>(
                    e.id(),
                    (e.time() / FIVE_MIN) * FIVE_MIN
                ),
                Collectors.maxBy(Comparator.comparingLong(Event::time))
            ))
            .values()
            .stream()
            .flatMap(Optional::stream)
            .sorted(Comparator.comparingLong(Event::time))
            .toList();
    }
}
