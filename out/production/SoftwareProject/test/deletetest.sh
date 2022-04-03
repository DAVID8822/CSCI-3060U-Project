#!/bin/bash
i=0 #Counts test number
#This test tests If the program can delete an account and update the user file
for FILE in "Input/delete"/*.txt; do #Loop through each file
i=$(( i + 1 )) #Increment test count
echo "DELETE TEST "${i}" COMPLETE"
cd ../ #Navigate to parent folder to run our Java test
java otbnb.java rentals.txt users.txt dailyTransactions.txt < "test/"$FILE > "test/Output/delete/delete_out"${i}".txt"#Run our program
cat "dailyTransactions.txt" > "test/Output/delete/delete_dailytransaction"${i} #Send output file to test txt file
cd test #Return back to test folder to run next test
done

