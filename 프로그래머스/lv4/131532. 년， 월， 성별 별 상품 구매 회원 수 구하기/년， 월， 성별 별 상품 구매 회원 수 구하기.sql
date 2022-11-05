-- 코드를 입력하세요
SELECT 
    YEAR(SALES_DATE) AS YEAR, 
    MONTH(SALES_DATE) AS MONTH, 
    GENDER,
    COUNT(DISTINCT(U.USER_ID)) AS USERS
FROM USER_INFO AS U 
RIGHT JOIN ONLINE_SALE AS O
ON U.USER_ID = O.USER_ID
WHERE GENDER IS NOT NULL 
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER

# SELECT
#     YEAR(SALES_DATE) AS YEAR, 
#     MONTH(SALES_DATE) AS MONTH, 
#     GENDER,
#     COUNT(*) AS USERS
# FROM USER_INFO AS U
# RIGHT JOIN ONLINE_SALE AS O ON O.USER_ID=U.USER_ID
# WHERE GENDER IS NOT NULL
# GROUP BY YEAR, MONTH, GENDER 
# ORDER BY YEAR, MONTH, GENDER

# SELECT
#      YEAR(SALES_DATE) AS YEAR, MONTH(SALES_DATE) AS MONTH, GENDER, COUNT(*) AS USERS
# FROM ONLINE_SALE AS O
# LEFT JOIN USER_INFO AS U ON O.USER_ID=U.USER_ID
# WHERE GENDER IS NOT NULL
# GROUP BY YEAR, MONTH, GENDER 
# ORDER BY YEAR, MONTH, GENDER