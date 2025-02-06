-- 코드를 입력하세요
SELECT ai.NAME as NAME, ai.DATETIME as DATETIME
from ANIMAL_INS as ai left join ANIMAL_OUTS as ao
on ao.ANIMAL_ID = ai.ANIMAL_ID
where ao.ANIMAL_ID is null
order by ai.DATETIME
LIMIT 3;