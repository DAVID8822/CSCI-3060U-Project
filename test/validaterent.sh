#!/bin/bash
#This test compares the expected output of delete to the actual output
for i in {1..4}; do #Loops through each file
echo "testing expected rent and output rent $i" 
diff expectedOutputs/rent/rent_dailytransaction$i output/rent/rent_dailytransaction$i #Comparing the daily transaction output to expected daily transaction
diff expectedOutputs/rent/rent_out$i.txt output/rent/rent_out$i.txt #Comparing the output files to expected output
done