Щоб запустити цей проєкт «Powershell Terminal», виконайте наступні кроки:

1. Підготовка бази даних (MySQL) Перед запуском програми необхідно створити базу даних, оскільки додаток намагатиметься підключитися до неї при старті.

Переконайтеся, що у вас встановлено та запущено сервер MySQL.

Виконайте SQL-скрипт з файлу INFO/SQL.txt у вашій консолі MySQL або через клієнт (наприклад, Workbench):

CREATE DATABASE IF NOT EXISTS powershell_terminal;
USE powershell_terminal;

CREATE TABLE IF NOT EXISTS command_history (
    id INT AUTO_INCREMENT PRIMARY KEY,
    command_text TEXT NOT NULL,
    executed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS snippets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    command_body TEXT NOT NULL,
    description VARCHAR(255)
);

Важливо: Перевірте налаштування підключення у файлі src/main/java/org/kpi/dao/DBConnection.java. За замовчуванням там вказано користувача root та пароль localhost. Змініть їх на ваші актуальні дані.

2. Запуск через IntelliJ IDEA:

Дочекайтеся, поки Maven завантажить усі залежності.

Знайдіть клас org.kpi.Launcher.

Натисніть зелений трикутник (Run) біля методу main у цьому класі.
