with actions as (
    select user_id, count(action) as actionCount from Confirmations group by action, user_id having action='confirmed'
), confirms as (
    select a.user_id, actionCount from actions a left join Confirmations c on a.user_id=c.user_id
)
select s.user_id, COALESCE(ROUND((actionCount::NUMERIC/count(c.user_id)), 2), 0) as confirmation_rate from Signups s left join confirms c on s.user_id=c.user_id group by actionCount, s.user_id order by s.user_id