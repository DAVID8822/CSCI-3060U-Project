#!/bin/bash
#This test compares the expected output of create to the actual output
for i in {1..4}; do #Loops through each file
echo "testing expected create and output create $i"
diff expectedOutputs/create/create_dailytransaction$i output/create/create_dailytransaction$i #Comparing the daily transaction output to expected daily transaction
diff expectedOutputs/create/create_out$i.txt output/create/create_out$i.txt #Comparing the output files to expected output
done