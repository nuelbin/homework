# 일정 애플리케이션 API


### 1. 일정 생성 API
- **URL**: `/todos`
- **Method**: `POST`
- **Request Body**:
```json
{
  "userName": "오민수",
  "todoTitle": "과제가 내일 2시까지래",
  "todoContents": "이건 있을 수 없는 일이야 과제를 해야해",
  "createAt": "2024-12-19T10:00:00"
}
```
- **Response**:
```json
{
  "id": 1,
  "todoTitle": "과제가 내일 2시까지래",
  "todoContents": "이건 있을 수 없는 일이야 과제를 해야해",
  "createAt": "2024-12-19T10:00:00"
}
```

---

### 2. Get Todo by ID
- **URL**: `/todos/{id}`
- **Method**: `GET`
- **Response**:
```json
{
  "userName": "오민수",
  "todoTitle": "과제가 내일 2시까지래",
  "todoContents": "이건 있을 수 없는 일이야 과제를 해야해",
  "updateAt": "2024-12-19T12:00:00"
}
```

---

### 3. Get All Todos
- **URL**: `/todos`
- **Method**: `GET`
- **Response**:
```json
[
  {
    "id": 1,
    "userName": "오민수",
    "todoTitle": "과제가 내일 2시까지래",
    "todoContents": "이건 있을 수 없는 일이야 과제를 해야해",
    "creatAt": "2024-12-19T10:00:00"
  },
  {
    "id": 2,
    "userName": "오민수",
    "todoTitle": "나는..",
    "todoContents": "문어 꿈을 꾸는 문어",
    "creatAt": "2024-12-18T09:00:00"
  }
]
```

---

### 4. Update Todo
- **URL**: `/todos/{id}`
- **Method**: `PUT`
- **Request Body**:
```json
{
  "todoTitle": "잠깐 벌써 12시?",
  "todoContents": "클났네 과제는 언제 다하냐",
  "updateAt": "2024-12-19T14:00:00"
}
```
- **Response**:
```json
{
  "userName": "오민수",
  "todoTitle": "잠깐 벌써 12시?",
  "todoContents": "클났네 과제는 언제 다하냐",
  "updateAt": "2024-12-19T14:00:00"
}
```

---

### 5. Delete Todo
- **URL**: `/todos/{id}`
- **Method**: `DELETE`
- **Response**: `204 No Content`

---

# ERD


### 1. `todos`
| Column         | Type         | Constraints            |
|----------------|--------------|------------------------|
| `id`           | `BIGINT`     | Primary Key, Auto Increment |
| `userName`     | `VARCHAR`    | Not Null              |
| `todoTitle`    | `VARCHAR`    | Not Null              |
| `todoContents` | `VARCHAR`    | Not Null              |
| `createdAt`    | `TIMESTAMP`  | Not Null, Immutable   |
| `updatedAt`    | `TIMESTAMP`  | Not Null              |
