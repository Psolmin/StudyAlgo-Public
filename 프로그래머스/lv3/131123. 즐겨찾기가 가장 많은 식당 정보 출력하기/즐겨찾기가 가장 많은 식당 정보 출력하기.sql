-- 코드를 입력하세요
SELECT
    I.FOOD_TYPE, I.REST_ID, I.REST_NAME, I.FAVORITES
FROM REST_INFO AS I
INNER JOIN (
    SELECT FOOD_TYPE, MAX(FAVORITES) AS FAVORITES
    FROM REST_INFO
    GROUP BY FOOD_TYPE
) AS MF
WHERE I.FOOD_TYPE = MF.FOOD_TYPE AND I.FAVORITES=MF.FAVORITES
ORDER BY I.FOOD_TYPE DESC


# SELECT FOOD_TYPE, MAX(FAVORITES) AS FAVORITES
#     FROM REST_INFO
#     GROUP BY FOOD_TYPE