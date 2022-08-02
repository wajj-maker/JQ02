#上升的温度
-- select w.id as id from weather w where w.temperature > (select w1.temperature from weather w1 where w1.recordDate = w.recordDate - 1);

#上升的温度
select w1.id as 'id' from weather w1, weather w2 where dateDiff(w1.recordDate, w2.recordDate) = 1 and w1.temperature > w2.temperature;

