Для запуска тестов необходимо использовать переменную среды для созданного вами токена, например для Windows в cmd прописать: 
set YOUTRACK_TOKEN=«свой_токен»

Реализовано 5 авто-тестов с использованием TestNG и RestAssured. 
Тесты выполняются параллельно в 4-х потоках (настроено в testng.xml).
В качестве источника для входных данных используется файл issues.xlsx.

ТЕСТ-КЕЙСЫ: https://docs.google.com/spreadsheets/d/19nwdNTggQA8ea4z9pgiNpflSeKmlabDcxqUnZYBCC-Q/edit?gid=1637172309#gid=1637172309