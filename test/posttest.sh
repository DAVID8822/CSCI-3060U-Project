#!/bin/bash
i=0 #Counts test number
#This test tests whether the user can create a new rental
for FILE in "Input/post"/*.txt; do #Loop through each file
i=$(( i + 1 ))#Increment test count
echo "POST TEST "${i}" COMPLETE"
cd ../ #Navigate to parent folder to run our Java test
java otbnb.java rentals.txt users.txt dailyTransactions.txt < "test/"$FILE > "test/Output/post/post_out"${i}".txt"#Run our program
cat "dailyTransactions.txt" > "test/Output/post/post_dailytransaction"${i} #Send output file to test txt file
cd test #Return back to test folder to run next test
done

