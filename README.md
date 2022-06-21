# Processing Task 10 - Array Backed Grids

## Learning Objectives
In this task, you will learn and demonstrate how to create an interactive grid with data contained within a two-dimenstional array.


## Step 1 - Lesson
You will begin the task by carefully following the instructions set in the [Array-Backed Grids tutorial](Array_BackedGridsTheBasics.md). Completing this tutorial will cover the Level 2 Expectations of this task.  

## Step 2 - Task
Demonstrate your learning objectives by fulfulling the expectations in the levels below.

### LEVEL 2
Complete the [Array-Backed Grids tutorial](Array_BackedGridsTheBasics.md)

### LEVEL 3

#### Part 3.1
Modify it so that rather than just changing the block the user clicks on, also
change the blocks of the squares next to the user's click. (5 pts) If the user clicks
on an edge, make sure the program doesn't crash and still handles the click
appropriately.

![](https://github.com/pvcraven/arcade_book/raw/master/source/labs/lab_11_array_backed_grids/lab_11_sample.gif)

#### Part 3.2
Modify your program to include a loop that will count all of the cells that are selected in the grid and print them out. Put this code at the end of your `mousePressed()` function.  
**Sample Output:**
```
Total of 4 cells are selected.
Total of 5 cells are selected.
Total of 6 cells are selected.
Total of 7 cells are selected.
Total of 8 cells are selected.
Total of 9 cells are selected.
```


### LEVEL 4

#### Part 4.1
Modify your level 3 code with another loop that will print how many cells are selected in each row  
**Sample Output**
```
Total of 7 cells are selected.
Row 0 has 0 cells selected.
Row 1 has 0 cells selected.
Row 2 has 2 cells selected.
Row 3 has 2 cells selected.
Row 4 has 1 cells selected.
Row 5 has 2 cells selected.
Row 6 has 0 cells selected.
Row 7 has 0 cells selected.
Row 8 has 0 cells selected.
Row 9 has 0 cells selected.
```

#### Part 4.2
Modify your 4.1 code to include the number of cells selected in each column.  
**Sample Output:**
```
Total of 5 cells are selected.
Row 0 has 1 cells selected.
Row 1 has 1 cells selected.
Row 2 has 1 cells selected.
Row 3 has 1 cells selected.
Row 4 has 1 cells selected.
Row 5 has 0 cells selected.
Row 6 has 0 cells selected.
Row 7 has 0 cells selected.
Row 8 has 0 cells selected.
Row 9 has 0 cells selected.
Column 0 has 5 cells selected.
Column 1 has 0 cells selected.
Column 2 has 0 cells selected.
Column 3 has 0 cells selected.
Column 4 has 0 cells selected.
Column 5 has 0 cells selected.
Column 6 has 0 cells selected.
Column 7 has 0 cells selected.
Column 8 has 0 cells selected.
Column 9 has 0 cells selected.
```

#### Part 4.3
Modify your 4.2 code so that the program will also print how many cells are continuously selected in a row, if that number is greater than 2.
**Sample Output:**
```
Total of 18 cells are selected.
Row 0 has 0 cells selected.
There are 7 continuous blocks selected on row 1.
Row 1 has 7 cells selected.
Row 2 has 0 cells selected.
There are 4 continuous blocks selected on row 3.
Row 3 has 4 cells selected.
Row 4 has 0 cells selected.
There are 4 continuous blocks selected on row 5.
Row 5 has 4 cells selected.
There are 3 continuous blocks selected on row 6.
Row 6 has 3 cells selected.
Row 7 has 0 cells selected.
Row 8 has 0 cells selected.
Row 9 has 0 cells selected.
Column 0 has 1 cells selected.
Column 1 has 3 cells selected.
Column 2 has 3 cells selected.
Column 3 has 3 cells selected.
Column 4 has 3 cells selected.
Column 5 has 1 cells selected.
Column 6 has 1 cells selected.
Column 7 has 1 cells selected.
Column 8 has 1 cells selected.
Column 9 has 1 cells selected.
```


## Submission
1. Commit and push your code to this repository
2. Follow programming style conventions and best practices
3. Take a screen recording of your program running and displaying its functionality.
