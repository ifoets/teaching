/*make quesions from given query, quesion are available in corresponding question.doc
*/

/*day 1*/
select * from city where CountryCode='USA' and population>100000;

select name from city where countryCode='USA' and population>120000;

select *from city;

select *from city where id=1661;

select * from city where CountryCode='JPN'; 

select name from city where CountryCode='JPN';

select city, state from station;

select distinct(city) from station where id%2=0

select count(*)-count(distinct(city)) from station;

select city, length(city) from station order by length(city) desc,city limit 1;
select city, length(city) from station order by length(city) ,city limit 1;

select distinct(city) from station where city REGEXP '^[aeiou]';

select distinct(city) from station where city REGEXP '[aeiou]$';

/*day 2*/
select distinct(city) from station where city REGEXP '^[aeiou]' and city REGEXP '[aeiou]$';

select distinct city from station where city REGEXP '^[^aeiou]';

select distinct city from station where city REGEXP '[^aeiou]$';

select distinct(city) from station where city REGEXP '^[^aeiou]' or city REGEXP '[^aeiou]$';

select distinct(city) from station where city REGEXP '^[^aeiouAEIOU]' and city REGEXP '[^aeiouAEIOU]$';

select name from students where marks>75 order by RIGHT(name,3),id;

select name from employee order by name;

select name from employee where salary>2000 and months<10 order by employee_id;

select if(a+b>c and b+c>a and a+c>b,
          if(a=b and b=c,
             'Equilateral',
             if(a=b or b=c or c=a,
                'Isosceles',
                'Scalene')), 
          'Not A Triangle')
from TRIANGLES;

/*day 3*/
