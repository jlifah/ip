# Duke User Guide ٩(^ᴗ^)۶ 

### Duke, named after the Java mascot, is a Personal Assistant Chatbot that helps a person to keep track of various things. 

<br>

* Quick Start
* Features 
  - Adding a new task:&nbsp; [deadline](#adding-a-new-task-deadline)&nbsp; [event](#adding-a-new-task-event) &nbsp; [todo](#adding-a-new-task-todo)
  - Checking/updating of tasks in list:&nbsp; [delete](#deleting-a-task-delete)&nbsp; [done](#marking-task-as-done-done)&nbsp; [find](#locating-a-task-using-a-keyword-find)&nbsp; [list](#viewing-all-task-list)&nbsp; [save](#saving-the-data-save)
  - Exiting the program: &nbsp;[exit](#exiting-the-program-exit)

* Command summary 

<br>

## Quick Start
1) [If needed] Download Java 11 from [Amazon Corretto](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)

2) Download the [ip.jar](https://github.com/jlifah/ip/releases/download/ip.jar-v0.2/ip.jar) file 

3) Create an empty folder in a convenient location eg. Desktop and copy jar file there

4) Open command window/terminal in that window and run the command java `java -jar {filename}.jar` e.g., `java -jar ip.jar`
   - Upon successful run, the following opening message will be shown,
      ```
      Hello! I'm Duke,
       ____        _        
      |  _ \ _   _| | _____ 
      | | | | | | | |/ / _ \
      | |_| | |_| |   <  __/
      |____/ \__,_|_|\_\___|
              
      What can I do for you? :)
      ```
     
5) Available commands for ip.jar will be available in the Features section below


<br>

## Features
> Take note 1: Inputs that look like \**THIS\** are parameters to be supplied by user.

> Take note 2: Do not to add tasks without specifying whether it is deadline/event/todo, if not the following error message will be shown:
```
OOPS!!! I'm sorry, but I don't know what that means (/ﾟДﾟ)/
```


### Adding a new task: `deadline`

Adds a deadline task to overall list

Format: `deadline *TASK DESCRIPTION* /by *DEADLINE DUE DATE*`
* All fields must be filled

Example: `deadline finish ip /by Sunday` (Where finish ip is the task and Sunday is the deadline due date)

Output:
```
Got it. I've added this task:
[D][✘] finish ip (by: Sunday)
Now you have 1 tasks in the list.
```

Note:
* `[D]` - Deadline Task 
* `[X]` - Deadline is **not** done


### Adding a new task: `event`

Adds an event task to overall list

Format: `event *TASK DESCRIPTION* /at *DATE OF EVENT*`
* All fields must be filled

Example: `event project meeting /at Monday` (Where project meeting is the task and Monday is the event day)

Output:
```
Got it. I've added this task:
[E][✘] project meeting (at: Monday)
Now you have 2 tasks in the list.
```

Note:
* `[E]` - Event task
* `[X]` - Event is **not** done


### Adding a new task: `todo`

Adds a todo task to overall list

Format: `todo *TASK DESCRIPTION*`
* All fields should be filled. If not, the following error message will be shown:
   ```
   OOPS!!! The description of a todo cannot be empty ☹
   ```

Example: `todo prepare for meeting` (Where prepare for meeting is the task)

Output:
```
Got it. I've added this task:
[T][✘] prepare for meeting
Now you have 3 tasks in the list.
```

Note:
* `[T]` - Todo task
* `[X]` - Todo is **not** done

### Deleting a task: `delete`

Following the order on the overall list, specified deadlines/events/todo will be deleted

Format: `delete *INDEX OF TASK ON LIST*`
* Index has to be an integer
* Only one deadlines/events/todo can be deleted at one time
[X] will be changed to [✔]

Example: `delete 1`

Output:
```
Noted. I've removed this task:
[D][✘] finish ip (by: Sunday)
Now you have 2 tasks in the list.
```

### Marking task as done: `done`

Following the order on the overall list, specified deadlines/events/todo will be marked as done

Format: `done *INDEX OF TASK ON LIST*`
* Index has to be an integer
* Only one deadlines/events/todo can be marked as done at one time
[✘] will be changed to [✔]

Example: `done 2`

Output:
```
Nice! I've marked this task as done:
[T][✓] prepare for meeting
```


### Locating a task using a keyword: `find`

Finds all deadlines/events/todo description recorded in list with specified keyword 

Format: `find *KEYWORD*`

Example: `find meeting`

Output:
```
1. [E][✘] project meeting (at: Monday)
2. [T][✓] prepare for meeting
```

### Viewing all task: `list`

Shows a list of all deadlines/events/todo recorded

Format: `list`

Output:
```
1. [E][✘] project meeting (at: Monday)
2. [T][✘] prepare for meeting
```

### Saving the data: `save`

List data will be saved automatically in the hard disk whenever the task list changes, there is no need to input a command

### Exiting the program: `exit`

Terminates the Duke program

Format: `bye`

Output:
```
Bye. Hope to see you again soon!
```

<br>

## Command summary

|    Action       |      Format     |   Examples | 
|:---:|:---:|:---:|
|       deadline   |    `deadline *TASK DESCRIPTION* /by *DEADLINE DUE DATE*`                 |   `deadline finish ip /by Sunday` |
|       event        |         `event *TASK DESCRIPTION* /at *DATE OF EVENT*`          |  `event project meeting /at Monday` |
|todo|        `todo *TASK DESCRIPTION*`       |   `todo prepare for meeting` | 
|          list             |            `list`            |    | 
|           find         |  `find *KEYWORD*`                    |    `find meeting`  |
|           done                |       `done *INDEX OF TASK ON LIST*`          |   `done 2`  |
|             exit             |                 `bye`          |    | 
