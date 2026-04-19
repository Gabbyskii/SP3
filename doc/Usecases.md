
## USECASES

**UC0 StartApplication:**

The system loads saved user data and media content from files.
A text‑based start menu is displayed with two options: Log In or Create New User.

Rainy day:
If the file cannot be read or data is missing, the system shows an error message and stops the program safely.

**UC1 CreateUser:**
The system prompts the user to type a username and password. The user provides both, followed by Enter.
The system creates a new User object and saves it in the user file.

Rainy day:
If the username already exists, the system shows a message “Username already taken” and asks the user to try again or log in instead.

**UC2 LogIn:**
The system asks for a username and password. The user enters the data.
The system validates the credentials against the saved user list.
If the credentials match, the system logs in the user and shows the main menu.

Rainy day:
If the login fails, the system shows “Invalid username or password” and allows retry or return to the start menu.

**UC3 SearchMedia:**
The user selects “Search media” in the main menu.
The system prompts for either a title or category.
After input is entered, the system lists all matching movies or series.

Rainy day:
If no media matches the search, the system displays “No results found” and returns to the main menu.

**UC4 SelectMedia:**
The system shows details of the chosen media and lists possible actions:
Play, Save for later, Remove from saved list, or Back.
User chooses an option.

 - onAccept(Play): The system shows “title is now playing…” and adds the media to the user’s watched list.
 - onAccept(Save): The media is added to the user’s “to‑watch” list.
 - onAccept(Remove): The media is removed from saved list.

Each choice updates the user file in memory.

Rainy day:
If the same media is already saved, the system shows message “Already in your list.”

**UC5 ViewLists:**
The user chooses to view either Watched movies or Saved movies from main menu.
System displays the relevant list.
User can select a media from the list, which leads to UC4 "SelectMedia".

Rainy day:
If the list is empty, the system displays “No items found.” and returns to main menu.

**UC6 PlayMedia:**
The user selects “Play” in UC4.
The system displays “title is now playing…”, simulates that it is playing, and moves the media to the watched list.
The system updates the data in memory.

**UC7 ExitProgram:**
The user selects “Log out” or “Exit” from the main menu.
The system saves all user lists and login data to files.
Then displays a message “Data saved. Goodbye” and terminates safely.

Rainy day:
If the file write operation fails, system warns “Unable to save data.”