-- 코드를 입력하세요
SELECT i.INGREDIENT_TYPE as INGREDIENT_TYPE, sum(f.TOTAL_ORDER) as TOTAL_ORDER
FROM FIRST_HALF f JOIN ICECREAM_INFO i
ON f.flavor = i.flavor
GROUP BY i.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER;