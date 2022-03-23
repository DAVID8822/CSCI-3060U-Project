#!/bin/bash
i=0 #Counts test number
#This test test whether the program can create a new Account and update the user file
for FILE in "Input/create"/*.txt; do #Loop through each file
i=$(( i + 1 )) #Increment test count
echo "CREATE TEST "${i}" COMPLETE"
cd ../ #Navigate to parent folder to run our Java test
java otbnb.java rentals.txt users.txt dailyTransactions.txt < "test/"$FILE > "test/Output/create/create_out"${i}".txt" #Run our program
cat "dailyTransactions.txt" > "test/Output/create/create_dailytransaction"${i}  #Send output file to test txt file
cd test #Return back to test folder to run next test
done

