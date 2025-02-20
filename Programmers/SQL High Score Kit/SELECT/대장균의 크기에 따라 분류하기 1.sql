-- https://school.programmers.co.kr/learn/courses/30/lessons/299307
-- 대장균의 크기에 따라 분류하기 1.sql

SELECT ID, 
       CASE
           WHEN SIZE_OF_COLONY <= 100 THEN 'LOW'
           WHEN SIZE_OF_COLONY <= 1000 THEN 'MEDIUM'
           ELSE 'HIGH'
       END AS SIZE
 FROM ECOLI_DATA
ORDER BY 1;
