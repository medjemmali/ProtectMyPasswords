<div id="header" align="center">
  <img src="https://media.giphy.com/media/M9gbBd9nbDrOTu1Mqx/giphy.gif" width="100"/>
</div>


About the project Idea: A small app to store passwords: It should ask you for a master password and you should be able to store username and passwords for websites. You should also be able to search passwords by the name of the website. Uses JavaFX, file IO, Json, Collections, java SHA or other encryption for the master password.

Application Menu:

First Menu: 

![Screen Shot 2022-05-11 at 5 38 40 PM](https://user-images.githubusercontent.com/98445818/167963764-97c1251b-409f-4230-8752-5bdfee8ad10f.png)


User can login if he/she already has an account, otherwise, you have to put a password, and hit save. A message will let you know that your account is ready, and you can login. If the password is alredy used, error message will appear. 

Main Menu: 

![Screen Shot 2022-05-11 at 6 09 31 PM](https://user-images.githubusercontent.com/98445818/167963903-b9797747-1504-4e0e-8390-f4564aad017e.png)

Very simple screen, with 3 buttons, every button lead you to operate a task. 

Button one, Passwords, when its pushed, all the saved data wil appear on a Table. Data will be in a format of :
- URL 
- User Name
- Password

![Screen Shot 2022-05-11 at 6 09 48 PM](https://user-images.githubusercontent.com/98445818/167964076-2e43264c-b99a-4bac-878e-fef68bc98dc5.png)

Button two, add new Password, when its pushed, will allow the user to insert new data of the format (URL, username, password)

![Screen Shot 2022-05-11 at 6 16 46 PM](https://user-images.githubusercontent.com/98445818/167964137-abe4e8c7-14b9-4574-88a6-2f2a95cd47a6.png)

Button three, Update Master Passwor, when its pushed, will give you a simple menu to change the master password.

![Screen Shot 2022-05-11 at 6 18 55 PM](https://user-images.githubusercontent.com/98445818/167965797-925c0b96-fcd9-4d78-aaec-c497e908a555.png)


Coding section: 

The software has been build using Model–view–controller. 
All interfaces has been created using Scenebuilder and they are FXML extension. Anyone who copies this project, please be carefule when you change the FXML, dont change FX:id. 
Jason simple has been used to create Json format file, data is saved on Json format, JsonModule class has all operations, including, saving, reading and updating the file. File is saved as a binary file, and serialized before saved. 
Master password is encrypted using SHA3-256 Hashing method. The method can be endorsed in the future using salting technique. Here an example :https://www.javaguides.net/2020/02/java-sha-256-hash-with-salt-example.html
Lambda operation has been used to encrypt the password. Also Inner class is used as well. Check encryptPassword Method. 

The application can be better in the future. I have built it as a practice, and to learn JavaFX, Json, practicing Lambda, File IO, as singleton. 


Dependency issues: 
please refer to the folder https://github.com/medjemmali/ProtectMyPasswords/tree/master/src/main/resources/dependency where you can find all dependency packages. 

To run the application, please use LogInView.java


Thank you 

Contact: Jemmalimd@gmail.com
