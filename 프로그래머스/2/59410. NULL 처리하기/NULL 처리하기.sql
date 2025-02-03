-- 코드를 입력하세요
SELECT ANIMAL_TYPE,
    case 
        when Name is null 
        then 'No name' 
        else Name
        end as name,
    SEX_UPON_INTAKE
from ANIMAL_INS 
order by ANIMAL_ID