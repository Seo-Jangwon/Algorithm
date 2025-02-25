SELECT YEAR(S.SALES_DATE) AS 'YEAR', MONTH(S.SALES_DATE) AS 'MONTH', U.GENDER, COUNT(DISTINCT U.USER_ID) AS 'USERS'
FROM ONLINE_SALE AS S JOIN USER_INFO AS U ON S.USER_ID = U.USER_ID
WHERE U.GENDER IS NOT NULL
GROUP BY YEAR(SALES_DATE), MONTH(SALES_DATE), GENDER
ORDER BY YEAR(SALES_DATE), MONTH(SALES_DATE), U.GENDER