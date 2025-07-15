package com.leetcode.algorithms.sql;

public class ISqlEasyQuery {
/**1757. Recyclable and Low Fat Products*/
/*
Write a solution to find the ids of products that are both low fat and recyclable.

ANS:-
select product_id
from products
where low_fats='Y' AND recyclable='Y';
*/
/**584. Find Customer Referee*/
/*
Find the names of the customer that are not referred by the customer with id = 2.
Return the result table in any order

ANS-
select name
from customer
where referee_id!=2 or referee_id is null;
 */

/** /**595. Big Countries*/
/*
A country is big if:

it has an area of at least three million (i.e., 3000000 km2), or
it has a population of at least twenty-five million (i.e., 25000000).
Write a solution to find the name, population, and area of the big countries.

Return the result table in any order.

ANS-
select name, population, area
from world
where area>=3000000 or population>=25000000;
     */

/** 1148. Article Views I*/
/*
Write a solution to find all the authors that viewed at least one of their own articles.
Return the result table sorted by id in ascending order.

ANS-
select distinct author_id as id
from views
where author_id=viewer_id
order by id
 */

/**1683. Invalid Tweets */
/*
Write a solution to find the IDs of the invalid tweets. The tweet is invalid if the number of characters used in the content of the tweet is strictly greater than 15.

ANS-
select tweet_id
from tweets
where LENGTH(content)>15
 */

    /**1378. Replace Employee ID With The Unique Identifier*/
    /*
    Write a solution to show the unique ID of each user, If a user does not have a unique ID replace just show null.
Return the result table in any order.
ANS-
select unique_id, e.name
from EmployeeUNI as eu
 right JOIN Employees as e
on e.id=eu.id
*/

     /**1068. Product Sales Analysis I*/
     /*
     Write a solution to report the product_name, year, and price for each sale_id in the Sales table.
Return the resulting table in any order.

ANS-
select product_name, year, price
from Sales s
join Product p on p.product_id=s.product_id
      */

    /**1581. Customer Who Visited but Did Not Make Any Transactions*/
    /*
Write a solution to find the IDs of the users who visited without making any transactions and the number of times they made these types of visits.
Return the result table sorted in any order.

ANS-
select ct.customer_id, count(ct.customer_id) as count_no_trans
from
(
select v.customer_id,t.visit_id
from Visits v
 left join Transactions t
on v.visit_id=t.visit_id
) ct
where ct.visit_id is null
group by ct.customer_id
order by ct.customer_id
     */

    /**197. Rising Temperature*/
    /*
Write a solution to find all dates' id with higher temperatures compared to its previous dates (yesterday).
Return the result table in any order.

ANS-
select w1.id
from Weather w1, Weather w2
where  w1.temperature>w2.temperature and DATEDIFF(w1.recordDate, w2.recordDate) = 1
order by w1.id
     */

    /**1661. Average Time of Process per Machine*/
    /*
    There is a factory website that has several machines each running the same number of processes. Write a solution to find the average time each machine takes to complete a process.
The time to complete a process is the 'end' timestamp minus the 'start' timestamp. The average time is calculated by the total time to complete every process on the machine divided by the number of processes that were run.
The resulting table should have the machine_id along with the average time as processing_time, which should be rounded to 3 decimal places.
Return the result table in any order.

ANS-
# Write your MySQL query statement below
select start.machine_id, ROUND(AVG(end.timestamp-start.timestamp),3) AS processing_time
from

(select * from activity where activity_type='start'
) start
join
(select * from activity where activity_type='end'
) end
on start.machine_id=end.machine_id and start.process_id=end.process_id

group by start.machine_id
     */

    /**577. Employee Bonus*/
    /*
    Write a solution to report the name and bonus amount of each employee with a bonus less than 1000.
Return the result table in any order.

ANS-
select e.name, b.bonus
from
(
select * from employee
) e
 left join
(
    select *from bonus
) b
on e.empId=b.empId where b.bonus is null or b.bonus<1000

     */

    /**1280. Students and Examinations*/
    /*
Write a solution to find the number of times each student attended each exam.
Return the result table ordered by student_id and subject_name.

ANS-
select
s.student_id, s.student_name, sb.subject_name, count(e.student_id) as attended_exams
from
(
select * from students
) s
cross join
(
    select * from subjects
) sb
left join
(
    select * from examinations
) e
on s.student_id=e.student_id and e.subject_name=sb.subject_name
group by s.student_id, s.student_name,sb.subject_name
order by s.student_id;
     */
}
