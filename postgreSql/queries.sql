-- Leetcode problem #1934. Confirmation Rate --MEDIUM
with actions as (
    select user_id, count(action) as actionCount from Confirmations group by action, user_id having action='confirmed'
), confirms as (
    select a.user_id, actionCount from actions a left join Confirmations c on a.user_id=c.user_id
)
select s.user_id, COALESCE(ROUND((actionCount::NUMERIC/count(c.user_id)), 2), 0) as confirmation_rate from Signups s left join confirms c on s.user_id=c.user_id group by actionCount, s.user_id order by s.user_id

-- Leetcode problem #1193. Monthly Transaction I --MEDIUM
select to_char(trans_date, 'YYYY-MM') as month, country, count(state) as trans_count, count(case when state='approved' then 1 else null end) as approved_count, sum(amount) as trans_total_amount, sum(case when state='approved' then amount else 0 end) as approved_total_amount from Transactions group by month, country order by country


--leetcode problem #570 Manager with at least five direct reports --MEDIUM
select e.name from Employee e join Employee c on e.id=c.managerId group by e.id having count(e.id)>4

--leetcode problem #1070 Product Sales Analysis III --MEDIUM
select s.product_id, year as first_year, quantity, price from Sales s where year=(select min(year) from Sales p group by product_id having p.product_id=s.product_id)


-- leetcode problem #1204 Last Person To Fit In The Bus --MEDIUM
with person as (
    select person_id, person_name, weight, sum(weight) over (order by turn) as cum_weight, turn from Queue order by turn
)
select person_name from person where cum_weight<=1000 order by turn desc limit 1

-- Leetcode problem #1907 Count Salary Categories --MEDIUM
select 'Low Salary' as category, count(account_id) as accounts_count from Accounts where income<20000
UNION
select 'Average Salary' as category, count(account_id) as accounts_count from Accounts where income>=20000 and income<=50000
UNION
select 'High Salary' as category, count(account_id) as accounts_count from Accounts where income>50000


-- Leetcode problem #1280 Students and Examinations --EASY
select s.student_id, student_name, sb.subject_name, count(e.subject_name) as attended_exams from Students s cross join Subjects sb
left join Examinations e on e.student_id=s.student_id and sb.subject_name=e.subject_name group by sb.subject_name, s.student_id, s.student_id, student_name order by s.student_id

-- Leetcode problem # 620 Not Boring Movie --EASY
select id, movie, description, rating from Cinema where (id%2)>0 and description !='boring' order by rating desc

-- Leetcode problem # 1251 Average Selling Price --EASY
select p.product_id, coalesce(round(sum(p.price*u.units)::numeric/sum(units), 2), 0) as average_price from Prices p left join UnitsSold u on p.product_id=u.product_id and purchase_date between start_date and end_date group by p.product_id

-- Leetcode problem #1075 Project Employees I 
select p.project_id, coalesce(round(sum(experience_years)::numeric/count(e.employee_id), 2), 0) as average_years from Project p left join Employee e on p.employee_id=e.employee_id group by project_id

-- Leetcode proble #1341 Movie Rating --MEDIUM
(select name as results from Users u left join MovieRating m on u.user_id=m.user_id group by m.user_id, name order by count(movie_id) desc, name asc limit 1)
UNION ALL
(select title as results from Movies mo left join MovieRating m on mo.movie_id=m.movie_id where to_char(created_at, 'yyyy-mm')= '2020-02' group by m.movie_id, title order by round(sum(m.rating)::numeric/count(m.movie_id), 2) desc, title asc limit 1)

-- Leetcode problem #595 Big Countries --EASY
select name, population, area from World where area>=3000000 or population>=25000000

-- Leetcode problem #550 Game Play Analysis IV --MEDIUM
select round(count(player_id)::numeric/(select count(distinct(player_id)) from Activity), 2) AS fraction from Activity a where (select count(player_id) from Activity c where a.player_id=c.player_id having a.event_date=min(c.event_date)+1)>0 

-- Leetcode problem #610 Triangle Judgement --EASY
select x, y, z, case when (x+y>z and y+z>x and x+z>y) then 'Yes' else 'No' end as triangle from Triangle 

-- Leetcode problem #1164 Product Price at a Given Date --MEDIUM
select product_id, case when min(change_date)>'2019-08-16' then 10 else (select new_price from Products s where p.product_id=s.product_id and change_date <='2019-08-16' order by change_date desc limit 1) end as price from Products p group by product_id order by product_id

-- # Leetcode problem #1731 The Number of Employees Which Repot to Each Employee --EASY
select y.employee_id, y.name, count(y.employee_id) as reports_count, round(sum(e.age)/count(y.employee_id)) as average_age from Employees e join Employees y on e.reports_to=y.employee_id group by y.employee_id, y.name order by y.employee_id