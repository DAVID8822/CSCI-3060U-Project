#!/bin/bash
i=0 #Counts test number
#This test tests if the user can log in 
for FILE in "Input/login"/*.txt; do #Loop through each file
i=$(( i + 1 )) #Increment test count
echo "LOGIN TEST "${i}" COMPLETE"
cd ../ #Navigate to parent folder to run our Java test
java otbnb.java rentals.txt users.txt dailyTransactions.txt < "test/"$FILE > "test/Output/login/login_out"${i}".txt"#Run our program
cat "dailyTransactions.txt" > "test/Output/login/login_dailytransaction"${i} #Send output file to test txt file
cd test #Return back to test folder to run next test
done

