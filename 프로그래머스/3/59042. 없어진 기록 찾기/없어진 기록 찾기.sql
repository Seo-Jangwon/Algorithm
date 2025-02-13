-- 코드를 입력하세요
SELECT o.ANIMAL_ID, o.NAME
from ANIMAL_INS as i right join ANIMAL_OUTS as o on i.ANIMAL_ID=o.ANIMAL_ID
where i.DATETIME is null
order by o.ANIMAL_ID