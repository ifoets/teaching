package interview.preparation.company.interviews.question;

public interface IGoldmanSach {

    double shortestDistance(String document, String word1, String word2);

    int minJumToReachEndOfArray(int[] a);

    /**Given two arrays start[] and finish[], representing the start and finish times of activities. A person can perform only one activity at a time, and an activity can be performed only if its start time is greater than the finish time of the last chosen activity.
     Find the maximum number of activities that can be performed without overlapping.*/
    int maxActivity(int[]start, int[]end);
}
