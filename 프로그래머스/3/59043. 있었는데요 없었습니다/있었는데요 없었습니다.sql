-- 코드를 입력하세요
SELECT i.ANIMAL_ID, i.NAME
from ANIMAL_INS as i join ANIMAL_OUTS as o on i.ANIMAL_ID=o.ANIMAL_ID
where TIMESTAMPDIFF(second,i.DATETIME,o.DATETIME) < 0
order by i.DATETIME