#!/bin/bash
i=0 #Counts test number
#This test makes sure the program can look up a rental
for FILE in "Input/search"/*.txt; do #Loop through each file
i=$(( i + 1 ))#Increment test count
echo "SEARCH TEST "${i}" COMPLETE"
cd ../ #Navigate to parent folder to run our Java test
java otbnb.java rentals.txt users.txt dailyTransactions.txt < "test/"$FILE > "test/Output/search/search_out"${i}".txt"#Run our program
cat "dailyTransactions.txt" > "test/Output/search/search_dailytransaction"${i} #Send output file to test txt file
cd test #Return back to test folder to run next test
done

