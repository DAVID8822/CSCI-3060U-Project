#!/bin/bash
i=0
for FILE in "Input/delete"/*.txt; do #Loop through each file
i=$(( i + 1 ))
echo "DELETE TEST "${i}" COMPLETE"
cd ../
java otbnb.java rentals.txt users.txt dailyTransactions.txt < "test/"$FILE > "test/Output/delete/delete_out"${i}".txt"
cat "dailyTransactions.txt" > "test/Output/delete/delete_dailytransaction"${i} 
cd test
done

