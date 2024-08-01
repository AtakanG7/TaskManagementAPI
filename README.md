# Task Management API

## Overview

This API provides endpoints for user authentication, task management, and user management. Below are details of the available endpoints for each controller in the system.

## AuthController

Manages user authentication and registration.

### Endpoints

#### Register a New User

- **HTTP Method**: POST
- **Endpoint**: `/api/auth/signup`
- **Description**: Registers a new user.
- **Status Codes**:
  - `200 OK`: User registered successfully.

#### Authenticate a User

- **HTTP Method**: POST
- **Endpoint**: `/api/auth/login`
- **Description**: Authenticates a user.
- **Status Codes**:
  - `200 OK`: Authentication successful.

## TaskController

Handles CRUD operations for tasks.

### Endpoints

#### Create a New Task

- **HTTP Method**: POST
- **Endpoint**: `/api/tasks`
- **Description**: Creates a new task.
- **Status Codes**:
  - `201 Created`: Task created successfully.

#### Update an Existing Task

- **HTTP Method**: PUT
- **Endpoint**: `/api/tasks/{id}`
- **Description**: Updates an existing task.
- **Status Codes**:
  - `200 OK`: Task updated successfully.

#### Delete a Task

- **HTTP Method**: DELETE
- **Endpoint**: `/api/tasks/{id}`
- **Description**: Deletes a task.
- **Status Codes**:
  - `204 No Content`: Task deleted successfully.

#### Retrieve a Task by ID

- **HTTP Method**: GET
- **Endpoint**: `/api/tasks/{id}`
- **Description**: Retrieves a task by its ID.
- **Status Codes**:
  - `200 OK`: Task retrieved successfully.

#### Retrieve All Tasks

- **HTTP Method**: GET
- **Endpoint**: `/api/tasks`
- **Description**: Retrieves all tasks.
- **Status Codes**:
  - `200 OK`: Tasks retrieved successfully.

#### Retrieve Tasks by User ID

- **HTTP Method**: GET
- **Endpoint**: `/api/tasks/user/{userId}`
- **Description**: Retrieves tasks associated with a specific user ID.
- **Status Codes**:
  - `200 OK`: Tasks for the specified user retrieved successfully.

## UserController

Manages user details and operations.

### Endpoints

#### Retrieve a User by ID

- **HTTP Method**: GET
- **Endpoint**: `/api/users/{id}`
- **Description**: Retrieves a user by their ID.
- **Status Codes**:
  - `200 OK`: User retrieved successfully.

#### Retrieve All Users

- **HTTP Method**: GET
- **Endpoint**: `/api/users`
- **Description**: Retrieves all users.
- **Status Codes**:
  - `200 OK`: Users retrieved successfully.

#### Update a User by ID

- **HTTP Method**: PUT
- **Endpoint**: `/api/users/{id}`
- **Description**: Updates a user by their ID.
- **Status Codes**:
  - `200 OK`: User updated successfully.

#### Delete a User by ID

- **HTTP Method**: DELETE
- **Endpoint**: `/api/users/{id}`
- **Description**: Deletes a user by their ID.
- **Status Codes**:
  - `200 OK`: User deleted successfully.


## AuthController

Manages user authentication and registration.

| **HTTP Method** | **Endpoint**         | **Description**            | **Status Codes** |
|-----------------|-----------------------|----------------------------|------------------|
| POST            | /api/auth/signup      | Register a new user        | 200 OK           |
| POST            | /api/auth/login       | Authenticate a user        | 200 OK           |

## TaskController

Handles CRUD operations for tasks.

| **HTTP Method** | **Endpoint**                | **Description**                        | **Status Codes** |
|-----------------|------------------------------|----------------------------------------|------------------|
| POST            | /api/tasks                   | Create a new task                     | 201 Created      |
| PUT             | /api/tasks/{id}              | Update an existing task               | 200 OK           |
| DELETE          | /api/tasks/{id}              | Delete a task                         | 204 No Content   |
| GET             | /api/tasks/{id}              | Retrieve a task by ID                 | 200 OK           |
| GET             | /api/tasks                   | Retrieve all tasks                    | 200 OK           |
| GET             | /api/tasks/user/{userId}     | Retrieve tasks by user ID             | 200 OK           |

## UserController

Manages user details and operations.

| **HTTP Method** | **Endpoint**       | **Description**                  | **Status Codes** |
|-----------------|---------------------|----------------------------------|------------------|
| GET             | /api/users/{id}    | Retrieve a user by ID            | 200 OK           |
| GET             | /api/users         | Retrieve all users               | 200 OK           |
| PUT             | /api/users/{id}    | Update a user by ID              | 200 OK           |
| DELETE          | /api/users/{id}    | Delete a user by ID              | 200 OK           |

## Entity Classes

### Role

Represents user roles in the system.

- **Table**: `roles`
- **Fields**:
  - `id` (Long, Primary Key)
  - `name` (RoleName, Enum: ROLE_USER, ROLE_ADMIN)

### Task

Represents tasks assigned to users.

- **Table**: `tasks`
- **Fields**:
  - `id` (Long, Primary Key)
  - `title` (String, Required)
  - `description` (String, Optional)
  - `dueDate` (LocalDateTime, Required)
  - `status` (TaskStatus, Enum: TODO, IN_PROGRESS, COMPLETED)
  - `assignedUser` (User, Many-to-One)

### User

Represents users of the system.

- **Table**: `users`
- **Fields**:
  - `id` (Long, Primary Key)
  - `username` (String, Required, Unique)
  - `email` (String, Required, Unique)
  - `password` (String, Required)
  - `roles` (Set<Role>, Many-to-Many)
  - `tasks` (Set<Task>, One-to-Many)
