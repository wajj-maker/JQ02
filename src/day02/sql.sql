#连续出现的数字
select distinct (a.num) as 'ConsecutiveNums 'from logs a, logs b, logs c where a.num = b.num and b.num = c.num and a.id = b.id - 1 && b.id = c.id - 1;

#部门工资前三高的员工
select d.name as 'Department', e.name as 'Employee', e.salary as 'Salary' from employee e left join department d on e.departmentId = d.id where e.salary in (select (distinct e2.salary)  from employee e2 where e1.departmentId = e2.departmentId order by e2.salary desc limit (0, 3));