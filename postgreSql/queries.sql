-- Leetcode problem #1934. Confirmation Rate
with actions as (
    select user_id, count(action) as actionCount from Confirmations group by action, user_id having action='confirmed'
), confirms as (
    select a.user_id, actionCount from actions a left join Confirmations c on a.user_id=c.user_id
)
select s.user_id, COALESCE(ROUND((actionCount::NUMERIC/count(c.user_id)), 2), 0) as confirmation_rate from Signups s left join confirms c on s.user_id=c.user_id group by actionCount, s.user_id order by s.user_id

-- Leetcode problem #1193. Monthly Transaction I
select to_char(trans_date, 'YYYY-MM') as month, country, count(state) as trans_count, count(case when state='approved' then 1 else null end) as approved_count, sum(amount) as trans_total_amount, sum(case when state='approved' then amount else 0 end) as approved_total_amount from Transactions group by month, country order by country
