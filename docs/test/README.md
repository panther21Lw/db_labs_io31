# Тестування працездатності системи
Збірку та тестування будемо проводити за допомогою Maven


## Збірка проекту

Із директорії ./src/api/db_lab_6 виконуємо команду для збірки проекту

```bash
mvn clean install
```

## Запуск тестування

Запускаємо додаток за допомогою команди

```bash
mvn spring-boot:run
```
<hr>

## Тестування

### User:

#### GET All
![UserGetAll.png](../../images/UserGetAll.png)
#### GET By ID
![UserGetById.png](../../images/UserGetById.png)
#### POST
![UserPost.png](../../images/UserPost.png)
#### PUT
![UserPut.png](../../images/UserPut.png)
![UserPutResult](../../images/UserPutconsole.png)
#### DELETE
![UserDelete.png](../../images/UserDelete.png)

<hr>

### Request:

#### GET All
![RequestGetAll.png](../../images/RequestGetAll.png)
#### GET By ID
![RequestGetById.png](../../images/RequestGetById.png)
#### POST
![RequestPost.png](../../images/RequestPost.png)

З таблиці requests виберемо всі записи. Бачимо, що новий запит з id=4 успішно доданий
![NewRequest.png](../../images/NewRequest.png)

#### PUT
![RequestPut.png](../../images/RequestPut.png)

З таблиці requests виберемо всі записи. Бачимо, що запит з id=4 змінив user_id із 3 на 2 та вміст стовпця url був
замінений на /api/data/task/changed

![PutRequest.png](../../images/PutRequest.png)

#### DELETE
![RequestDelete.png](../../images/RequestDelete.png)
