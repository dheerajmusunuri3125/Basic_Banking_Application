# Basic_Banking_Application

This program is a basic banking application in Java. It simulates a bank where customers can:  Login (or create a new account if they are new).  View their account details.  Deposit money.  Withdraw money.  Check balance.  Currently, it’s console-based, but you’re extending it towards a GUI (with Swing login page).

Important Components

1. Customer Class

This class stores customer details:

name → Customer’s name.

address → Where they live.

phonenumber → Their phone number.

balance → Current balance (starts with some default or deposited money).

withdrawlamount → Withdrawal amount (used when withdrawing).

It has:

Setters & Getters → to safely update and retrieve customer details.

display() → prints customer details neatly.


Bank Class (Main Class)

This is where the logic runs. It contains:

A List<Customer> to store multiple customers (acts like our "database").

A menu-driven system:

If user is new → asks for details (name, address, phone, deposit amount) and creates an account.

If user is existing → asks for name, searches in the list, and shows their details.


Planned GUI Version

In the Swing-based version:

A Login Page will allow existing customers to log in.

A Registration Page will allow new customers to sign up.

After login, a Dashboard will show options:

Deposit

Withdraw

Check Balance

View Account Details

This will make the program user-friendly and interactive instead of console-based.

📌 Limitations

Currently, data is lost every time you close the program (no database yet).

No password-based authentication (only name search is used).

Balance is stored per object, but not persistent.

Needs validation (e.g., can’t withdraw more than balance

getRemaingBalance() → shows balance after withdrawal.
