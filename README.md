# 🌸 Wishly ( Practice JetPackCompose )

Wishly is a **cute & minimal wishlist app** built with **Kotlin + Jetpack Compose + Room Database**.  
It lets you save and organize your wishes, along with descriptions, in a clean and girly UI 💖.  

---

## ✨ Features  

- ➕ Add new wishes with a title & description.  
- 📋 View a list of all saved wishes.  
- 💾 Local persistence using **Room Database**.  
- 🎀 Simple, modern, and girly UI with **Jetpack Compose**.  
- 🗂️ MVVM Architecture with Repository & ViewModel.  

---

## 📱 Screenshots  

<div style="display: flex; justify-content: center; gap: 20px;">
 <img width="250" alt="Home Screen" src="https://github.com/user-attachments/assets/e13017c6-a733-4322-98ca-7a01f38fc31c" />
 <img width="250" alt="Add Wish Screen" src="https://github.com/user-attachments/assets/02862e78-80aa-4c90-af54-301021c94e2e" />
</div>


---

## 🛠️ Tech Stack  

- **Language:** Kotlin  
- **UI:** Jetpack Compose  
- **Architecture:** MVVM (ViewModel + Repository + DAO)  
- **Database:** Room (SQLite) 
- **Navigation:** Jetpack Navigation Component  

---

## 📂 Project Structure

```text
com.example.wishly
├── dataClasses/
│   ├── Wish.kt                 # Entity class
│   ├── WishDao.kt              # DAO interface
│   ├── WishDatabase.kt         # Room database
│   └── WishRepository.kt       # Repository layer
│
├── ui/
│   └── theme/
│       ├── ActionBar.kt           # Custom Action Bar
│       ├── AddEditDetailScreen.kt # Add/Edit Wish UI
│       ├── HomeView.kt            # Home Screen UI
│       ├── Graph.kt               # Navigation Graph
│       ├── Navigation.kt          # Navigation setup
│       ├── Screen.kt              # Screen definitions
│       └── WishViewModel.kt       # ViewModel
│
├── MainActivity.kt
└── MyApplication.kt


```

---
## 🚀 Getting Started  

### Prerequisites  
- Android Studio (latest version)  
- Kotlin + Compose setup  

### Steps  
1. Clone this repository:  
   ```bash
   git clone https://github.com/Chaitnya-Ghai/Wishly.git

   2. Open the project in **Android Studio**.  
3. Build & run on an emulator or device.  

---

## 🎨 UI Theme  

- Color palette: Soft pink tones 🌸  
- Rounded cards & buttons for a playful look.  

---

## 🌟 Future Enhancements  

- 🗑️ Delete wishes.  
- ✏️ Edit existing wishes.  
- ☁️ Cloud sync with Firebase.  
- 🌈 Custom themes.  


