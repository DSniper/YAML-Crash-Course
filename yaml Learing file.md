Getting Started With YAML

Key Contents Covered 

1. What is YAML? Introduction
2. Extensions
3. YAML Syntax Basics
4. Key Value
5. Objects
6. List
7. List of Objects
8. Multiline
9. Suprises
    1. Validate YAML Code
    2. Real World Use Cases

---

# 🟡 YAML (YAML Ain’t Markup Language)

## 1. 📌 What is YAML? Introduction

- Human-friendly data serialization format.
- Used for configuration, data exchange, and readability.
- An alternative to **JSON** & **XML,** but simpler.

💡 YAML is mostly used in **Kubernetes, Docker, GitHub Actions, Ansible, and CI/CD pipelines**.

---

## 2. 📂 Extensions

- `.yaml` (preferred)
- `.yml` (shorter, also works)

---

## 3. ✍️ YAML Syntax Basics

- Case sensitive.
- Uses **indentation (spaces, not tabs)**.
- Comments with `#`.

Example:

```yaml
# This is a comment
topic: YAML
extensions: yaml

```

---

## 4. 🔑 Key-Value

```yaml
username: yaml
language: English
active: true
followers: 1200

```

---

## 5. 🧩 Objects (Nested Key-Values)

```yaml
user:
  name: yaml
  contact:
    email: yaml@example.com
    phone: 9876543210

```

---

## 6. 📋 List (Array)

```yaml
fruits:
  - apple
  - mango
  - banana

```

---

## 7. 📋 List of Objects

```yaml
employees:
  - name: John
    role: Developer
  - name: Mohan
    role: Tester

```

---

## 8. 📜 Multiline Strings

```yaml
bio: |
  Daisy is a software developer.
  Loves YAML and automation.
  Enjoys teaching.

```

Folded style (keeps line breaks as spaces):

```yaml
note: >
  This is a single line
  even though written
  in multiple lines.

```

---

## 9. ⚡ Surprises in YAML

### (a) Validate YAML Code

- We Will Also Create an Java Java-based application to test if it's valid or not.

### (b) Real World Use Cases

- **Snipping up the container dynamically for phpMyAdmin**

```yaml
version: "3.8"

services:
  db:
    image: mysql:5.7
    container_name: singh-mysql
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: root
    ports:
      - "3306:3306"
    volumes:
      - ./mysql-data:/var/lib/mysql
    networks:
      - php_net

  phpmyadmin:
    image: phpmyadmin/phpmyadmin
    container_name: singh-phpmyadmin
    restart: always
    ports:
      - "8080:80"
    environment:
      PMA_HOST: db
      MYSQL_ROOT_PASSWORD: root
    depends_on:
      - db
    networks:
      - php_net
    healthcheck:
      test: ["CMD", "curl", "-f", "http://localhost:80"]
      interval: 10s
      retries: 5
      start_period: 10s
      timeout: 5s
      
networks:
  php_net:
    driver: bridge
```

---

---