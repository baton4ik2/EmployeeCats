### Шаги для запуска

1. Клонируйте репозиторий:

   ```bash
   git clone https://github.com/baton4ik2/EmployeeCats.git

2. Перейдите в директорию проекта:

    ```bash
    cd EmployeeCats

3. Выполните команду для запуска приложения:
    
    ```bash
    docker-compose up --build
   
4. Приложение будет доступно по следующему адресу:

    ```bash
   http://localhost:8080

### Эндпоинты для работы с сотрудниками

- **GET /api/employees/{id}** — получить информацию о сотруднике по ID.
- **PUT /api/employees/{id}** — обновить информацию о сотруднике и котах.
- **POST /api/employees** —  добавить нового сотрудника.
- **DELETE /api/employees/{id}** — удалить сотрудника по ID.

#### Пример запроса

**GET /api/employees/1**:

    GET http://localhost:8080/api/employees/1

### Ответ:

    {
    "firstName": "John",
    "lastName": "Doe",
    "catIds": [1, 2]
    }

### POST /api/employees

    POST http://localhost:8080/api/employees
    {
    "firstName": "Alice",
    "lastName": "Smith",
    "catIds": [3, 4]
    }

### Ответ:

    {
    "firstName": "Alice",
    "lastName": "Smith",
    "catIds": [3, 4]
    }

**PUT /api/employees/1**

    PUT http://localhost:8080/api/employees/1 
    {
    "firstName": "John",
    "lastName": "DoeUpdated",
    "catIds": [1, 5]
    }

### Ответ:

    {
    "firstName": "John",
    "lastName": "DoeUpdated",
    "catIds": [1, 5]
    }

**DELETE /api/employees/1:**

    DELETE http://localhost:8080/api/employees/1

### Эндпоинты для работы с котами

- **GET /api/cats/{catId}** — получить информацию о коте по ID.
- **POST /api/cats** — добавить нового кота.
- **PUT /api/cats/{catId}** — обновить информацию о коте по ID.
- **DELETE /api/cats/{catId}** — удалить кота по ID.

#### Пример запроса

**GET /api/cats/1****:

    GET http://localhost:8080/api/cats/1

### Ответ:

    {
    "name": "Fluffy",
    "color": "White",
    "employeeId": 1
}

### POST /api/cats

    POST http://localhost:8080/api/cats
    {
    "name": "Mittens",
    "color": "Black",
    "employeeId": 2
    }

### Ответ:

    {
    "name": "Mittens",
    "color": "Black",
    "employeeId": 2
    }

**PUT /api/cats/1**

    PUT http://localhost:8080/api/cats/1
    {
    "name": "FluffyUpdated",
    "color": "Grey"
    }

### Ответ:

    {
    "name": "FluffyUpdated",
    "color": "Grey"
    }

**DELETE /api/cats/1**

    DELETE http://localhost:8080/api/cats/1

