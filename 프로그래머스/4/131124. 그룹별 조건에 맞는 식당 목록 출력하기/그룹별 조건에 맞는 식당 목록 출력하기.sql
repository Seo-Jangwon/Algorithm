with review_count as (
    select MEMBER_ID , count(*) as cnt 
    from REST_REVIEW 
    group by MEMBER_ID
)
select P.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE,'%Y-%m-%d') AS REVIEW_DATE
from MEMBER_PROFILE as p join REST_REVIEW as r on p.MEMBER_ID=r.MEMBER_ID
where p.MEMBER_ID in (
    select MEMBER_ID
    from review_count
    where cnt=(select MAX(cnt) from review_count)
)
ORDER BY r.REVIEW_DATE ASC, r.REVIEW_TEXT ASC;