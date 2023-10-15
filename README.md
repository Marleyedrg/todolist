# Todo List
## A to-do list created with:
- Java 17 ☕
- Spring Boot 3 🍃
- Maven 🍂
- Docker 🐋

You can access it by using the following URL and sending requests through a REST client:

[https://todolist-rocket-3o0r.onrender.com](https://todolist-rocket-3o0r.onrender.com)

You can create users, create tasks related to a user, retrieve tasks for a user, and modify task information.

# Create Users
**Method:** POST

[https://todolist-rocket-3o0r.onrender.com/users/](https://todolist-rocket-3o0r.onrender.com/users/)

Pass a JSON with the user information:
```
{
    "name": "[user's name]",
    "username": "[username]",
    "password": "[password]"
}
```

# Create Task
**Method:** POST

[https://todolist-rocket-3o0r.onrender.com/tasks/](https://todolist-rocket-3o0r.onrender.com/tasks/)

Pass a JSON with the task information:
```
{
    "description": "calculate 1+1",
    "title": "Homework",
    "priority": "high",
    "startAt": "[startAt]",
    "endAt": "[endAt]"
}
```

# Retrieve Tasks
**Method:** GET

[https://todolist-rocket-3o0r.onrender.com/tasks/](https://todolist-rocket-3o0r.onrender.com/tasks/)

Provide authentication for an existing user.

# Modify Tasks
**Method:** PUT

[https://todolist-rocket-3o0r.onrender.com/tasks/[TASK_ID]](https://todolist-rocket-3o0r.onrender.com/tasks/[TASK_ID])

Provide the information you want to change:
```
{
    "title": "changing title"
}
```
