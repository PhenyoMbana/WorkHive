WorkHive - Student Side Hustle Marketplace


Project Overview

WorkHive is a modern Android marketplace built with Kotlin that enables students to find and post short-term gig opportunities. Whether it's tutoring, delivery, design work, or cleaning services, WorkHive provides a seamless platform for students to earn extra income while building their professional network.

Features

Authentication & Security
- Secure Registration/Login with Firebase Authentication
- Password Encryption using industry-standard hashing
- Profile Management with photo upload capability

Gig Management
- Post Gigs with detailed descriptions, budgets, and categories
- Browse & Search gigs with advanced filtering
- Category System (Tutoring, Delivery, Design, Cleaning, Tech Support)
- Location-based gig discovery

Real-time Communication
- In-app Messaging between gig posters and applicants
- Push Notifications for new messages and gig updates
- Real-time Chat with Firebase Firestore

Advanced Features
- Multilingual Support (English & Setswana)
- Offline Mode with draft synchronization
- Dark/Light Theme support
- Responsive Design for all screen sizes


Installation

 Prerequisites
- Android Studio Arctic Fox or later
- Android SDK 21+

Setup Instructions

1. Clone the repository
   ```bash
   git clone https://github.com/your-username/workhive-android.git
   cd workhive-android
   

2. Open in Android Studio
   - Open Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned repository

3. Configure Firebase
   - Create a new Firebase project at 
   - Add Android app to your Firebase project
   - Download `google-services.json` and place it in `app/` directory

4. Build and Run
   - Connect Android device or start emulator
   - Click Run → Run 'app' or press Shift + F10



Demo Video

[[WorkHive Demo]( https://www.youtube.com/shorts/iTFF4O53B4E)

Video demonstrates:
- User registration and onboarding
- Gig creation and browsing workflow
- Real-time messaging system
- Offline functionality
- Multilingual support (English/Setswana)
- Location-based features



Tech Stack

Frontend
- Kotlin - Primary programming language
- Material Design 3 - Design system
- ViewModel & LiveData - Architecture components

Backend
- Firebase Authentication - User management
- Cloud Firestore - Real-time database
- Firebase Storage - File storage
- Cloud Messaging - Push notifications

Architecture
- MVVM Pattern - Model-View-ViewModel
- Repository Pattern - Data abstraction
- Dependency Injection - With Hilt/Dagger


## 📄 License

This project is developed for educational purposes as part of the OPSC6312 course requirements.

