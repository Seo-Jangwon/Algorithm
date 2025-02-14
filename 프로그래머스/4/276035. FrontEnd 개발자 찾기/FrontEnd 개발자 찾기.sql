-- 코드를 작성해주세요
select distinct d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
from SKILLCODES as s join DEVELOPERS as d on d.SKILL_CODE & s.CODE=s.CODE
where s.CATEGORY='Front End'
order by d.ID 