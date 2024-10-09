-- Leetcode problem #1934. Confirmation Rate
with actions as (
    select user_id, count(action) as actionCount from Confirmations group by action, user_id having action='confirmed'
), confirms as (
    select a.user_id, actionCount from actions a left join Confirmations c on a.user_id=c.user_id
)
select s.user_id, COALESCE(ROUND((actionCount::NUMERIC/count(c.user_id)), 2), 0) as confirmation_rate from Signups s left join confirms c on s.user_id=c.user_id group by actionCount, s.user_id order by s.user_id

-- Leetcode problem #1193. Monthly Transaction I
select to_char(trans_date, 'YYYY-MM') as month, country, count(state) as trans_count, count(case when state='approved' then 1 else null end) as approved_count, sum(amount) as trans_total_amount, sum(case when state='approved' then amount else 0 end) as approved_total_amount from Transactions group by month, country order by country


--leetcode problem #570 Manager with at least five direct reports
select e.name from Employee e join Employee c on e.id=c.managerId group by e.id having count(e.id)>4

--leetcode problem #1070 Product Sales Analysis III
select s.product_id, year as first_year, quantity, price from Sales s where year=(select min(year) from Sales p group by product_id having p.product_id=s.product_id)


-- leetcode problem #1204 Last Person To Fit In The Bus
with person as (
    select person_id, person_name, weight, sum(weight) over (order by turn) as cum_weight, turn from Queue order by turn
)
select person_name from person where cum_weight<=1000 order by turn desc limit 1

-- Leetcode problem #1907 Count Salary Categories
select 'Low Salary' as category, count(account_id) as accounts_count from Accounts where income<20000
UNION
select 'Average Salary' as category, count(account_id) as accounts_count from Accounts where income>=20000 and income<=50000
UNION
select 'High Salary' as category, count(account_id) as accounts_count from Accounts where income>50000


-- Leetcode problem #1280 Students and Examinations
select s.student_id, student_name, sb.subject_name, count(e.subject_name) as attended_exams from Students s cross join Subjects sb
left join Examinations e on e.student_id=s.student_id and sb.subject_name=e.subject_name group by sb.subject_name, s.student_id, s.student_id, student_name order by s.student_id
