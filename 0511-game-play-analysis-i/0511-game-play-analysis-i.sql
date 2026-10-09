# Write your MySQL query statement below
select prev.player_id , MIN(prev.event_date) as first_login
from Activity prev
group by player_id;