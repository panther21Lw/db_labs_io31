# Тестування працездатності системи

## Запуск тестування

переходимо в директориію src/api/db_lab_6 де вихідний код api

```bash
cd src/api/db_lab_6
```

перевіряємо, чи встановлено maven:

```bash
mvn --version
```

якщо ні, то встановлюємо maven на нашу ОС.
<br>
<br>

компілюємо та збираємо прооект

```bash
mvn clean package
```

запускаємо проект за допомогою java

```bash
cd target
java -jar db_lab_6-0.0.1-SNAPSHOT.jar
```

Або ж запускаємо за допомогою maven (перед цим не треба додатково збирати та запаковувати проект)
```bash
mvn spring-boot:run
```
<hr>

## Тестування

### Response:

#### GET All
![ResponseGetAll.png](../../images/ResponseGetAll.png)
#### GET By ID
![ResponseGetById.png](../../images/ResponseGetById.png)
#### POST
![ResponsePost.png](../../images/ResponsePost.png)
#### PUT
![ResponsePut.png](../../images/ResponsePut.png)
#### DELETE
![ResponseDelete.png](../../images/ResponseDelete.png)
<hr>

### Dataset:

#### GET All
![DatasetGetAll.png](../../images/DatasetGetAll.png)
#### GET By ID
![DatasetGetById.png](../../images/DatasetGetById.png)
#### POST
![DatasetPost.png](../../images/DatasetPost.png)
#### PUT
![DatasetPut.png](../../images/DatasetPut.png)
#### DELETE
![DatasetDelete.png](../../images/DatasetDelete.png)
<hr>

### Feedback:

#### GET All
![FeedbackGetAll.png](../../images/FeedbackGetAll.png)
#### GET By ID
![FeedbackGetById.png](../../images/FeedbackGetById.png)
#### POST
![FeedbackPost.png](../../images/FeedbackPost.png)
#### PUT
![FeedbackPut.png](../../images/FeedbackPut.png)
#### DELETE
![FeedbackDelete.png](../../images/FeedbackDelete.png)
