#!/bin/bash
#This test compares the expected output of delete to the actual output
for i in {1..4}; do #Loops through each file
echo "testing expected delete and output delete $i"
diff expectedOutputs/delete/delete_dailytransaction$i output/delete/delete_dailytransaction$i #Comparing the daily transaction output to expected daily transaction
diff expectedOutputs/delete/delete_out$i.txt output/delete/delete_out$i.txt #Comparing the output files to expected output
done