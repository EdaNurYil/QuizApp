#  Quiz App

A dynamic Android Quiz App built using the MVVM architecture. It integrates Retrofit and ViewModel to fetch quiz questions from a custom PHP API backed by a MySQL database hosted on a local XAMPP server.

---

## Features

-  MVVM (Model-View-ViewModel) architecture
-  RESTful API integration with Retrofit
-  Real-time quiz questions from a MySQL database
-  Backend developed using PHP and hosted via XAMPP
-  ViewModel for lifecycle-aware data management
-  Clean UI with score tracking and result screen

---

## Tech Stack

| Layer          | Technology                      |
|----------------|----------------------------------|
| Frontend       | Android (Kotlin)                |
| Architecture   | MVVM                            |
| Networking     | Retrofit                        |
| Lifecycle      | ViewModel                       |
| Backend        | PHP                             |
| Database       | MySQL                           |
| Local Server   | XAMPP                           |

---

## Screenshots

*(Include screenshots of your app UI if available)*

---

## Setup Instructions

### Backend (PHP + MySQL)
1. Install [XAMPP](https://www.apachefriends.org/index.html)
2. Start **Apache** and **MySQL** from the XAMPP Control Panel
3. Import the `quiz_db.sql` file into **phpMyAdmin**
4. Place the backend PHP files in the `htdocs` folder of your XAMPP installation
5. Test the API by visiting:  
   `(http://localhost/quiz/)`
   `http://localhost/phpmyadmin/index.php?route=/sql&pos=0&db=quiz_db&table=math_quiz`
   

### Android App
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/quiz_app.git
