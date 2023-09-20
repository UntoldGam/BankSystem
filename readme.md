# Bank Management System

Written in Java, utilises SQL for saving users.

Features:

- Login / Logout
- View Balance, Edit Balance
- Delete Account

## Currently fixing FileManagement and setting up a menu, then adding database equivalent of the file system (either sqlite + jdbc or jdbc + Microsoft access)

### Admins will matter more when the System is made into a mobile app (admins can view all accounts within a region - and their balances / information)

AdminType = 1, 2 or 3
1 = All Regions
2 = 1 region,
3 = Not an Admin


### Design

LoginFrame -> Sends a UserAccount to the MenuFrame -> MenuFrame -> Click one of the buttons -> Each frame renders a new _Frame, this Frame is temporary and is deleted upon the completed action (unless it's the BalanceButton in which, the output is displayed within the MenuFrame) 
