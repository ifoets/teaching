finding the employee who have more salary than their manager

employee(
id,nam,sal,mid
)

SELECT e2.name,e2.sal from Employee e1 inner join Employee e2 ON e1.id=e2.mid  WHERE e1.sal<e2.sal;