Лабораторная работ №3\
Студента ИДБ-19-10 Романова Ильи\
Вариант №10\
Текст задания:\
Разработать приложение для прохождения тестов по заранее
подготовленным вопросам и вариантам ответов.\
Инструкция по запуску проекта:\
$ mvn clean install -Pproduction \
Затем в директории проекта\
$ java -jar target/*.jar

деплой в yandex cloud
```
mvn clean package -Pproduction
docker build . -t stankin-smart:latest
docker run -p 8080:8080 stankin-smart:latest

```