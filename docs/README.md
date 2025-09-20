# Chintu User Guide

Welcome to Chintu, your personal task management assistant! This guide will help you understand all the features available in Chintu.
<img width="1400" height="1318" alt="Screenshot 2025-09-20 161621" src="https://github.com/user-attachments/assets/cbc13fbb-9074-43d4-9e23-abed17ae32e2" />
## Getting Started
1. Run Chintu to see the welcome message and instructions
2. Start adding tasks using `todo`, `deadline`, or `event` commands
3. Use `list` to view all your tasks
4. Mark tasks as done using `mark` when completed
5. Use `find` to search for specific tasks
6. Use `bye` to save and exit when finished

## Features

### Adding a Todo task: `todo`

Adds a simple task without any time constraints to your task list.

**Format:** `todo DESCRIPTION`

* The `DESCRIPTION` cannot be empty.
* The task will be added to your task list and marked as not done by default.

**Examples:**
* `todo homework` - Adds a todo task with description "homework"
* `todo buy groceries` - Adds a todo task with description "buy groceries"

### Adding a Deadline task: `deadline`

Adds a task with a specific deadline to your task list.

**Format:** `deadline DESCRIPTION /by DEADLINE`

* The `DESCRIPTION` cannot be empty.
* The `DEADLINE` cannot be empty and must be preceded by `/by`.
* Both description and deadline are required fields.

**Examples:**
* `deadline homework /by 3pm` - Adds a deadline task "homework" due by 3pm
* `deadline assignment /by Sunday` - Adds a deadline task "assignment" due by Sunday

### Adding an Event task: `event`

Adds an event with start and end times to your task list.

**Format:** `event DESCRIPTION /from START_TIME /to END_TIME`

* The `DESCRIPTION` cannot be empty.
* Both `START_TIME` and `END_TIME` are required and cannot be empty.
* The format must include `/from` before start time and `/to` before end time.

**Examples:**
* `event wedding /from august 12pm /to 3pm` - Adds an event "wedding" from august 12pm to 3pm
* `event meeting /from Monday 2pm /to Monday 4pm` - Adds an event "meeting" from Monday 2pm to Monday 4pm

### Listing all tasks: `list`

Shows all tasks currently in your task list.

**Format:** `list`

* Displays all tasks with their task numbers, types, completion status, and descriptions.
* If no tasks exist, displays a message indicating the list is empty.
* Tasks are numbered starting from 1.

**Example:**
* `list` - Displays all tasks in the format: `1.[T][ ] homework`

### Marking a task as done: `mark`

Marks a specific task as completed.

**Format:** `mark INDEX`

* Marks the task at the specified `INDEX` as done.
* The `INDEX` refers to the index number shown in the displayed task list.
* The `INDEX` must be a positive integer.
* The `INDEX` must be within the range of existing tasks.
* Use the function `list` to display all tasks and choose the appropriate `INDEX`.

**Examples:**
* `mark 1` - Marks the 1st task as completed
* `mark 3` - Marks the 3rd task as completed

### Unmarking a task: `unmark`

Marks a specific task as not done.

**Format:** `unmark INDEX`

* Marks the task at the specified `INDEX` as not done.
* The `INDEX` refers to the index number shown in the displayed task list.
* The `INDEX` must be a positive integer.
* The `INDEX` must be within the range of existing tasks.
* Use the function `list` to display all tasks and choose the appropriate `INDEX`.

**Examples:**
* `unmark 1` - Marks the 1st task as not completed
* `unmark 2` - Marks the 2nd task as not completed

### Deleting a task: `delete`

Removes a task permanently from your task list.

**Format:** `delete INDEX`

* Deletes the task at the specified `INDEX`.
* The `INDEX` refers to the index number shown in the displayed task list.
* The `INDEX` must be a positive integer.
* The `INDEX` must be within the range of existing tasks.
* Once deleted, the task cannot be recovered.
* Use the function `list` to display all tasks and choose the appropriate `INDEX`.

**Examples:**
* `delete 1` - Deletes the 1st task from the list
* `delete 3` - Deletes the 3rd task from the list

### Finding tasks by keyword: `find`

Searches for tasks containing a specific keyword in their description.

**Format:** `find KEYWORD`

* Finds all tasks that contain the `KEYWORD` in their description.
* The search is case-insensitive.
* The `KEYWORD` cannot be empty.
* Displays all matching tasks with their details.

**Examples:**
* `find homework` - Finds all tasks containing "homework" in their description
* `find meeting` - Finds all tasks containing "meeting" in their description

### Exiting the program: `bye`

Saves all tasks and exits the Chintu application.

**Format:** `bye`

* Saves all current tasks to the data file.
* Displays a goodbye message.
* Terminates the program.

**Example:**
* `bye` - Saves tasks and exits Chintu

## Data Storage

* Chintu automatically saves your tasks to a file called `Task_Data.txt`.
* Tasks are automatically loaded when you start Chintu.
* All changes (adding, deleting, marking, unmarking) are saved immediately.
* If no saved tasks are found, Chintu starts with an empty task list.

## Task Display Format

Tasks are displayed in the following format:
* `[T]` - Todo task
* `[D]` - Deadline task  
* `[E]` - Event task
* `[X]` - Completed task
* `[ ]` - Incomplete task
