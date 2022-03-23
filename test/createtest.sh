#!/bin/bash
i=0
for FILE in "Input/create"/*.txt; do #Loop through each file
i=$(( i + 1 ))
echo "CREATE TEST "${i}" COMPLETE"
cd ../
java otbnb.java rentals.txt users.txt dailyTransactions.txt < "test/"$FILE > "test/Output/create/create_out"${i}".txt"
cat "dailyTransactions.txt" > "test/Output/create/create_dailytransaction"${i} 
cd test
done

